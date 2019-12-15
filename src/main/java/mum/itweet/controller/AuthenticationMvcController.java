package mum.itweet.controller;

import mum.itweet.model.User;
import mum.itweet.model.dto.UserDto;
import mum.itweet.security.JwtToken;
import mum.itweet.service.JwtUserDetailsService;
import mum.itweet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/login")
    public String loginForm(@ModelAttribute UserDto user) {
        return "login";
    }

//    @GetMapping("/register")
//    public String register(@ModelAttribute User user) {
//        return "register";
//    }

    @PostMapping("/signin")
    public String signin(@ModelAttribute UserDto user, HttpServletRequest request) throws Exception {
        authenticate(user.getEmail(), user.getPass());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        request.getSession().setAttribute("access_token", token);
        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute UserDto user, BindingResult bindingResult) throws Exception {

        if (bindingResult.hasErrors()) {
            return "login";
        }
        User userToAdd = new User();
        userToAdd.setPass(user.getPass());
        userToAdd.setEmail(user.getEmail());
        userToAdd.setActive(true);
        userService.create(userToAdd);
        return "redirect:/";
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
