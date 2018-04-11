package ru.test.directories.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.test.directories.models.Post;
import ru.test.directories.services.DirectoryService;

import javax.validation.Valid;


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
    public String pathSubmit(@Valid @ModelAttribute("path") Post path,BindingResult bindingResult) {
        if (bindingResult.hasErrors())
        {
            return "redirect:/";
        }
        else directoryService.addDirectory(path.getContent());
        return "redirect:/";
    }

    @GetMapping(value="/files/{id}")
    public String getFiles(@PathVariable String id, Model model) {
        model.addAttribute("files", directoryService.getFilesForDirectory(id));
        model.addAttribute("dir",directoryService.getDirectoryDTO(id));
        return "files";
    }
}
