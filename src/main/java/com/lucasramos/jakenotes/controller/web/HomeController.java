package com.lucasramos.jakenotes.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("styles", new ArrayList<String>());
        model.addAttribute("content", "home");
        return "layout";
    }

    @GetMapping("/home")
    public RedirectView redirect() {
        return new RedirectView("");
    }
}