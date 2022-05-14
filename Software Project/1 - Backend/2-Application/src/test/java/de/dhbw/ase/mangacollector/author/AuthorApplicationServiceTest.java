package de.dhbw.ase.mangacollector.author;

import de.dhbw.ase.mangacollector.domain.author.Author;
import de.dhbw.ase.mangacollector.domain.author.AuthorRepository;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorApplicationServiceTest {

    public static final String authorName = "Danny Kroll";
    public static final String authorNameNew = "Manfred Kroll";
    public static final int id = 1;

     @Mock
     private AuthorRepository authorRepository;
     @InjectMocks
     private AuthorApplicationService authorApplicationService;

    @Test
    void getAuthorById() throws NotFoundException {
        Author newAuthor = new Author(id,authorName);
        when(authorRepository.findById(id)).thenReturn(Optional.of(newAuthor));
        Author gettedAuthor = authorApplicationService.getAuthorById(id);
        assertEquals(newAuthor,gettedAuthor);
    }

    @Test
    void createAuthor() {
        Author author = new Author(authorName);
        when(authorRepository.save(author)).thenReturn(author);

        Author createdAuthor = authorApplicationService.createAuthor(author);

        verify(authorRepository).save(any(Author.class));
        assertEquals(author,createdAuthor);
    }

    @Test
    void deleteAuthor() {
        authorApplicationService.deleteAuthor(id);
        verify(authorRepository).deleteById(any(Integer.class));
    }

    @Test
    void updateAuthor() throws NotFoundException {
        Author authorNormal = new Author(id,authorName);
        Author updatedAuthor = new Author(id,authorNameNew);

        when(authorRepository.findById(id)).thenReturn(Optional.of(authorNormal));
        when(authorRepository.save(any(Author.class))).thenReturn(updatedAuthor);

        Author changedAuthor = authorApplicationService.updateAuthor(updatedAuthor);

        assertEquals(authorNameNew,changedAuthor.getName());
    }

    @Test
    void getAuthors() {
        when(authorRepository.findAll()).thenReturn(Arrays.asList(
                new Author("1"),
                new Author("2"),
                new Author("3")
        ));

        List<Author> authorList = authorApplicationService.getAuthors();

        assertEquals("1",authorList.get(0).getName());
        assertEquals("2",authorList.get(1).getName());
        assertEquals("3",authorList.get(2).getName());

    }
}
