package guru.springframework.webapp.controllers;

import guru.springframework.webapp.domain.Author;
import guru.springframework.webapp.domain.Book;
import guru.springframework.webapp.repositories.AuthorRepository;
import guru.springframework.webapp.repositories.BookRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorController(AuthorRepository authorRepository,BookRepository bookRepository){
        this.authorRepository =  authorRepository;
        this.bookRepository = bookRepository;

    }//end constr AuthorController()

    @RequestMapping("")
    public String getAuthors(Model model){
        model.addAttribute(  "authors",  authorRepository.findAll());

        return "authors/list";
    }//end getAuthors


    @RequestMapping(path = {"/edit", "/edit/{id}"},method = RequestMethod.GET)
    public String editAuthorById(Model model , @PathVariable("id") Optional<Long> id,Author author )
            throws NotFoundException
    {
        if (id.isPresent()) {
            Optional<Author> response = authorRepository.findById(id.get());
            if(!response.isPresent()){
                throw new NotFoundException("Author not found.");
                // return "not-found";
            }

            author = response.get();
            model.addAttribute("Authors", author);
        } else {
            model.addAttribute("Author", new Author());
        }
        model.addAttribute("Books",bookRepository.findAll());
        return "authors/add-edit";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteAuthorById(Model model, @PathVariable("id") Long id)
            throws Exception //RecordNotFoundException
    {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }//end deletePublisherById()

    @RequestMapping(path = "/createAuthor", method = RequestMethod.POST)
    public String createOrUpdateAuthor(Author author,BindingResult bindingResult)
    {
        authorRepository.save(author);
        return "redirect:/authors";
    }//end createOrUpdatePublisher()

  }//end class AuthorController
