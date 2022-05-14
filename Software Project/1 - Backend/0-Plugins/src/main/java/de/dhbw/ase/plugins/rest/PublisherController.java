package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.domain.publisher.Publisher;
import de.dhbw.ase.mangacollector.publisher.PublisherApplicationService;
import de.dhbw.ase.mangacollector.publisher.PublisherDTO;
import de.dhbw.ase.mangacollector.publisher.PublisherToPublisherDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/publisher")
public class PublisherController {
    private PublisherApplicationService publisherApplicationService;
    private PublisherToPublisherDTOMapper publisherToPublisherDTOMapper;
    @Autowired
    public PublisherController(PublisherApplicationService publisherApplicationService, PublisherToPublisherDTOMapper publisherToPublisherDTOMapper){
        this.publisherApplicationService = publisherApplicationService;
        this.publisherToPublisherDTOMapper = publisherToPublisherDTOMapper;
    }
    @GetMapping("")
    public List<PublisherDTO> getAllPublishers() {
        return publisherApplicationService.getPublisher().stream().map(publisherToPublisherDTOMapper).collect(Collectors.toList());
    }
}
