package org.example.web.controllers;

import org.apache.log4j.Logger;
import org.example.web.app.services.PoemService;
import org.example.web.dto.Poem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "poem")
public class PoemController {

    PoemService poemService;
    private Logger logger = Logger.getLogger(BookShelfController.class);

    public PoemController(PoemService poemService) {
        this.poemService = poemService;
    }

    @GetMapping("/stack")
    public String books(Model model){
        logger.info("get poem stack");
        model.addAttribute("poem", new Poem());
        model.addAttribute("poemList", poemService.getAllBooks());
        return "poem_stack";
    }

    @PostMapping("/add")
    public String postWith (Poem poem){
        poemService.savePoem(poem);
        logger.info("current repository size: " + poemService.getAllBooks().size());
        return "redirect:/poem/stack";
    }
}
