package de.dhbw.ase.mangacollector.domain.publisher;

import java.util.List;

public interface PublisherRepository {
    List<Publisher> findAll();

    Publisher save(Publisher publisher)
}
