package de.dhbw.ase.plugins.persistence.hibernate.author;

import de.dhbw.ase.mangacollector.domain.author.Author;
import de.dhbw.ase.mangacollector.domain.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryBridge implements AuthorRepository {
    private SpringDataAuthorRepository springDataAuthorRepository;
    @Autowired
    public AuthorRepositoryBridge(SpringDataAuthorRepository springDataAuthorRepository){
        this.springDataAuthorRepository = springDataAuthorRepository;
    }

    @Override
    public List<Author> findAll() {
        return springDataAuthorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
         return springDataAuthorRepository.save(author);
    }

    @Override
    public Optional<Author> findById(Integer authodId) {
        return springDataAuthorRepository.findById(authodId);
    }

    @Override
    public void deleteById(Integer authorId){
        springDataAuthorRepository.deleteById(authorId);
    }
}
