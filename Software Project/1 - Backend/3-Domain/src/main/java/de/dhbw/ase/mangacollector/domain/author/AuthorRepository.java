package de.dhbw.ase.mangacollector.domain.author;

import java.util.List;

public interface AuthorRepository {
    List<Author> findAll();

    Author save(Author author);
}
