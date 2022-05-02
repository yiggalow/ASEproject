package de.dhbw.ase.mangacollector.author;

import de.dhbw.ase.mangacollector.domain.author.Author;
import de.dhbw.ase.mangacollector.domain.author.AuthorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorApplicationService {
    private AuthorRepository authorRepository;
    @Autowired
    public AuthorApplicationService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public Author getAuthorById(Integer id) throws NotFoundException {
        Optional<Author> foundAuthor = authorRepository.findById((id));
        if(foundAuthor.isPresent()){
            return foundAuthor.get();
        }
        throw new NotFoundException("Author not found!");
    }

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public void deleteAuthor(Integer id){
        authorRepository.deleteById(id);
    }

    public Author updateAuthor(Author author) throws NotFoundException {
        Optional<Author> optionalAuthor = authorRepository.findById(author.getId());
        if(optionalAuthor.isPresent()){
            Author foundAuthor = optionalAuthor.get();
            if(!foundAuthor.getName().equals(author.getName())){
                foundAuthor.setName(author.getName());
                return authorRepository.save(foundAuthor);
            }
            return foundAuthor;
        }
        throw new NotFoundException("Author not found!");
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }
}
