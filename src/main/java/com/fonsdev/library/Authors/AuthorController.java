package com.fonsdev.library.Authors;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired private AuthorRepository authorRepo;

    @GetMapping
    public @ResponseBody List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    @GetMapping("/byId")
    public @ResponseBody List<Author> getAuthorById(
            @RequestParam Integer id
    ) {
        return authorRepo.findAllById(Collections.singleton(id));
    }

    @GetMapping("/byName")
    public @ResponseBody List<Author> getAuthorByName(
            @RequestParam String name
    ) {
        return authorRepo.findByName(name);
    }

    @PostMapping("/add")
    public @ResponseBody String addNewAuthor(
            @RequestParam String name
    ){
        try {
            Author author = new Author(name);
            authorRepo.save(author);
            return "Author saved successfully";
        } catch (Exception e) {
               return e.toString();
        }
    }
}
