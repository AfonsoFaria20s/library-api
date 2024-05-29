package com.fonsdev.library.Authors;

import com.fonsdev.library.User.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired private AuthorRepository authorRepo;

    //Get all the authors in the database
    @GetMapping
    public @ResponseBody List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    // Get author by either id or name or even both for more accuracy
    @GetMapping("/find")
    public @ResponseBody List<Author> findByName(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "name", required = false) String name
    ) {
        if(id != null) {
            return authorRepo.findAllById(Collections.singleton(id));
        } else if (name != null) {
            return authorRepo.findAllByName(name);
        } else {
            return Collections.emptyList(); 
        }
    }

    // Create new author
    @PostMapping("/add")
    public @ResponseBody String addNewAuthor(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "contact") String contact,
            @RequestParam(value = "age") Integer age,
            @RequestParam(value = "bio") String bio
    ){
        try {
            Author author = new Author(name,contact,age,bio);
            authorRepo.save(author);
            return "Author saved successfully";
        } catch (Exception e) {
               return e.toString();
        }
    }

    // Delete author using id
    @DeleteMapping("/delete")
    public String deleteAuthor(
            @RequestParam(value = "id") Integer id
    ) {
        authorRepo.deleteById(id);
        return "Author with id "+id+" was deleted successfully";
    }

    // Update author's information
    @PutMapping("/update/{id}")
    public @ResponseBody String updateAuthor(
            @PathVariable(value = "id") Integer id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "contact", required = false) String contact,
            @RequestParam(value = "age", required = false) Integer age,
            @RequestParam(value = "bio", required = false) String bio
    ) {
        Optional<Author> authorOptional = authorRepo.findById(id);
        if(authorOptional.isEmpty()) {
            return "Author with id "+id+" was not found";
        }

        Author author = authorOptional.get();

        if(name!=null) {
            author.setName(name);
        }
        if(contact!=null) {
            author.setContact(contact);
        }
        if(age!=null) {
            author.setAge(age);
        }
        if(bio!=null) {
            author.setBio(bio);
        }

        authorRepo.save(author);

        return "Author information was updated successfully.\nNew Information:\n"+ author;
    }
}
