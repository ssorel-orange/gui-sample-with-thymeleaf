package com.orange.soamanager.gui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.orange.soamanager.gui.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @GetMapping("/")
    public String main(Model model) {
    	List<User> result = new ArrayList<User>();
    	result.add(new User("SOREL", "STYEPHANE", "Chief Architect", "toto", "ssorel","Lol"));
    	result.add(new User("PATINI", "Marvin", "Developer", "titi", "mpatini","Lol"));
    	model.addAttribute("result", result);
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "testuser"; //view
    }

    // /hello?name=kotlin
    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") 
			String name, Model model) {

        model.addAttribute("message", name);

        return "welcome"; //view
    }

}
