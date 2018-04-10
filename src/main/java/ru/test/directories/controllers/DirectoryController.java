package ru.test.directories.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.test.directories.models.Post;
import ru.test.directories.services.DirectoryService;


@Controller
public class DirectoryController {

    @Autowired
    private DirectoryService directoryService;

    @GetMapping("/")
    public String getDirectories(Model model) {
        model.addAttribute("path", new Post());
        model.addAttribute("dirs",directoryService.getDirectoriesList());
        return "index";
    }

    @PostMapping("/")
    public String pathSubmit(@ModelAttribute Post path) {
        directoryService.addDirectory(path.getContent());
        return "redirect:/";
    }

    @GetMapping(value="/files/{id}")
    public String getFiles(@PathVariable String id, Model model) {
        model.addAttribute("files", directoryService.getFilesForDirectory(id));
        return "files";
    }
}
