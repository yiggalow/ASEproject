package de.dhbw.ase.mangacollector.domain.author;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository {
    List<Author> findAll();

    void deleteById(Integer id);

    Optional<Author> findById(Integer authodId);

    Author save(Author author);
}
