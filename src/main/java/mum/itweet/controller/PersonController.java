package mum.itweet.controller;

import mum.itweet.components.storage.StorageService;
import mum.itweet.model.Person;
import mum.itweet.service.IPersonService;
import mum.itweet.components.storage.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/person")
public class PersonController {

    //@Autowired
    private IStorageService storageService = new StorageService();

    @Autowired
    IPersonService personService;

    @Autowired
    ServletContext servletContext;

    @GetMapping()
    public String view(@ModelAttribute Person person) {
        return "person";
    }

    @PostMapping()
    public String add(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult, Model model) throws IOException {
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
        if (!person.getImage().isEmpty()) {
            String path = storageService.uploadMultipartFile(person.getImage(), savedPerson.getId().toString());
            savedPerson.setImageUrl(path);
        } else if (!person.getVideo().isEmpty()) {
            String path = storageService.uploadMultipartFile(person.getVideo(), savedPerson.getId().toString());
            savedPerson.setVideoUrl(path);
        }

        savedPerson = personService.update(savedPerson);

        model.addAttribute("person", savedPerson);
        return "login";
    }
}
