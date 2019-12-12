package mum.itweet.controller;

import mum.itweet.model.Person;
import mum.itweet.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    IPersonService personService;

    @GetMapping()
    public String view(@ModelAttribute Person person)
    {
        return "person";
    }

    @PostMapping()
    public String add(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors()) {
            return "person";
        }

        String[] suppressedFields = bindingResult.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
                    + StringUtils.addStringToArray(suppressedFields, ", "));
        }

        // save here
        Person savedPerson = personService.add(person);
        model.addAttribute("person", savedPerson);
        return "index";
    }



}
