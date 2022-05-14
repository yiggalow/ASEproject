package de.dhbw.ase.mangacollector.domain.publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherRepository {
    List<Publisher> findAll();

    Optional<Publisher> findById(Integer publisherId);

    Publisher save(Publisher publisher);
}
