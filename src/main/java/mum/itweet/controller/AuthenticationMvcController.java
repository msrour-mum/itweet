package mum.itweet.controller;

import mum.itweet.model.User;
import mum.itweet.model.dto.UserDto;
import mum.itweet.security.JwtToken;
import mum.itweet.service.JwtUserDetailsService;
import mum.itweet.service.UserService;
import mum.itweet.utitlity.ConstantKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AuthenticationMvcController {

    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtToken jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;

    private FacebookConnectionFactory factory =
            new FacebookConnectionFactory("2478446085736540",
                    "31a82b6db3b9fdbe74461ebe5253a824");

    @GetMapping("/login")
    public String loginForm(@ModelAttribute UserDto user) {
        return "login";
    }

    @GetMapping("/register")
    public String register(@ModelAttribute UserDto user) {
        return "register";
    }

    @PostMapping("/signin")
    public String signin(@ModelAttribute UserDto user, HttpServletRequest request) throws Exception {
        authenticate(user.getEmail(), user.getPass());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        request.getSession().setAttribute(ConstantKeys.ACCESS_TOKEN_SESSION_NAME, token);
        request.getSession().setAttribute(ConstantKeys.USER_DETAILS_SESSION_NAME, userDetails);
        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserDto user, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            return "register";
        }
        User userToAdd = new User();
        userToAdd.setName(user.getName());
        userToAdd.setPass(user.getPass());
        userToAdd.setEmail(user.getEmail());
        userToAdd.setActive(true);
        userService.create(userToAdd);
        return "redirect:/";
    }

    @GetMapping(value = "/facebook")
    public String producer() {

        OAuth2Operations operations = factory.getOAuthOperations();
        OAuth2Parameters params = new OAuth2Parameters();

        params.setRedirectUri("http://localhost:8080/forwardLogin");
        params.setScope("email,public_profile");

        String url = operations.buildAuthenticateUrl(params);
        System.out.println("The URL is" + url);
        return "redirect:" + url;

    }

    @RequestMapping(value = "/forwardLogin")
    public ModelAndView prodducer(@RequestParam("code") String authorizationCode) {
        OAuth2Operations operations = factory.getOAuthOperations();
        AccessGrant accessToken = operations.exchangeForAccess(authorizationCode, "http://localhost:8080/forwardLogin",
                null);

        Connection<Facebook> connection = factory.createConnection(accessToken);
        Facebook facebook = connection.getApi();
        String[] fields = {"id", "email", "first_name", "last_name"};
        org.springframework.social.facebook.api.User userProfile =
                facebook.fetchObject("me",
                        org.springframework.social.facebook.api.User.class, fields);
        ModelAndView model = new ModelAndView("login");
        model.addObject("user", userProfile);
        return model;

    }

    private Authentication authenticate(String username, String password) throws Exception {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
