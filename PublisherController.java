package guru.springframework.webapp.controllers;

import guru.springframework.webapp.domain.Author;
import guru.springframework.webapp.repositories.PublisherRepository;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.webapp.domain.Publisher;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    private PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }
@RequestMapping("")
    public String getPublishers(Model model){
        model.addAttribute( "publishers", publisherRepository.findAll());
        return "publishers/publishersList";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editPublisherById(Model model, @PathVariable("id") Optional<Long> id)
            throws NotFoundException
    {
        if (id.isPresent()) {
            Optional<Publisher> response = publisherRepository.findById(id.get());
            if(!response.isPresent()){
                throw new NotFoundException("Publisher not found.");
                // return "not-found";
            }
            Publisher publisher = response.get();
            model.addAttribute("publisher", publisher);
        } else {
            model.addAttribute("publisher", new Publisher());
        }
        return "publishers/add-edit";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deletePublisherById(Model model, @PathVariable("id") Long id)
            throws Exception //RecordNotFoundException
    {
        publisherRepository.deleteById(id);
        return "redirect:/publishers";
     }

    @RequestMapping(path = "/createPublisher", method = RequestMethod.POST)
    public String createOrUpdatePublisher(Publisher publisher)
    {
        publisherRepository.save(publisher);
        return "redirect:/publishers";
    }


}//end class PublisherController

