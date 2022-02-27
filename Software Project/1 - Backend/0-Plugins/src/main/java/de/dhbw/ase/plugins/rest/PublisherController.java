package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.domain.publisher.Publisher;
import de.dhbw.ase.mangacollector.publisher.PublisherApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/publisher")
public class PublisherController {
    private PublisherApplicationService publisherApplicationService;
    @Autowired
    public PublisherController(PublisherApplicationService publisherApplicationService){
        this.publisherApplicationService = publisherApplicationService;
    }
    @GetMapping("")
    public List<Publisher> getAllPublishers() {
        return publisherApplicationService.getPublisher();
    }
}
