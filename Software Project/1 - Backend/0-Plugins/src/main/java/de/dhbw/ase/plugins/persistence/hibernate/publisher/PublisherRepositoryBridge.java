package de.dhbw.ase.plugins.persistence.hibernate.publisher;

import de.dhbw.ase.mangacollector.domain.author.Author;
import de.dhbw.ase.mangacollector.domain.publisher.Publisher;
import de.dhbw.ase.mangacollector.domain.publisher.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PublisherRepositoryBridge implements PublisherRepository {
    private SpringDataPublisherRepository springDataPublisherRepository;
    @Autowired
    public PublisherRepositoryBridge(SpringDataPublisherRepository springDataPublisherRepository){
        this.springDataPublisherRepository = springDataPublisherRepository;
    }

    @Override
    public List<Publisher> findAll() {
        return springDataPublisherRepository.findAll();
    }

    @Override
    public Publisher save(Publisher publisher) {
        return springDataPublisherRepository.save(publisher);
    }

    @Override
    public Optional<Publisher> findById(Integer publisherId) {
        return springDataPublisherRepository.findById(publisherId);
    }
}
