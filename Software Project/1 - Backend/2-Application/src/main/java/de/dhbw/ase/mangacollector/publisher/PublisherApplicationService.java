package de.dhbw.ase.mangacollector.publisher;

import de.dhbw.ase.mangacollector.domain.publisher.Publisher;
import de.dhbw.ase.mangacollector.domain.publisher.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherApplicationService {
    private PublisherRepository publisherRepository;
    @Autowired
    public PublisherApplicationService(PublisherRepository publisherRepository){
        this.publisherRepository = publisherRepository;
    }

    public List<Publisher> getPublisher() {         return publisherRepository.findAll();     }
}
