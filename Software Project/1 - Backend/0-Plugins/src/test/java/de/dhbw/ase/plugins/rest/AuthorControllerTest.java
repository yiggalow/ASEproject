package de.dhbw.ase.plugins.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.dhbw.ase.mangacollector.author.AuthorApplicationService;
import de.dhbw.ase.mangacollector.author.AuthorDTO;
import de.dhbw.ase.mangacollector.domain.author.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = de.dhbw.ase.mangacollector.AseProjectApplication.class)
@AutoConfigureMockMvc
class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private AuthorController authorController;

    private static Integer authorID = 1;
    private static String author1Name = "Danny 1";
    private static String author2Name = "Danny 2";
    private static String authorNAMECHANGED = "Danny 3";
    private static Author AUTHOR_1_NORMAL = new Author(1,author1Name);
    private static AuthorDTO AUTHOR_1 = new AuthorDTO(1,author1Name,null);
    private static AuthorDTO AUTHOR_2 = new AuthorDTO(2,author2Name,null);

    @Test
    void findAuthorById() throws Exception{
        when(authorController.findAuthorById(authorID)).thenReturn(AUTHOR_1);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/author/"+authorID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        Author readAuthor = objectMapper.readValue(responseBody, Author.class);
        assertEquals(readAuthor.getId(),AUTHOR_1_NORMAL.getId());
        assertEquals(readAuthor.getName(),AUTHOR_1_NORMAL.getName());
    }

    @Test
    void deleteAuthorById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .delete("/author/"+authorID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void createAuthor()  throws Exception{
        when(authorController.createAuthor(any(AuthorDTO.class))).thenReturn(AUTHOR_1);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .post("/author/")
                .content(objectMapper.writeValueAsString(AUTHOR_1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String responseBody = mvcResult.getResponse().getContentAsString();
        AuthorDTO readOutAuthor = objectMapper.readValue(responseBody, AuthorDTO.class);
        assertEquals(readOutAuthor.getName(),author1Name);
    }

    @Test
    void updateAuthor()  throws Exception{
        AuthorDTO changedAuthor = new AuthorDTO(authorID, authorNAMECHANGED,null);
        when(authorController.updateAuthor(any(AuthorDTO.class))).thenReturn(new AuthorDTO(authorID,authorNAMECHANGED,null));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .put("/author/")
                .content(objectMapper.writeValueAsString(changedAuthor))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        AuthorDTO readOutAuthor = objectMapper.readValue(responseBody, AuthorDTO.class);
        assertEquals(changedAuthor.getName(),readOutAuthor.getName());
    }

    @Test
    void getAllAuthors() throws Exception {
        List<AuthorDTO> authors = new ArrayList<>(Arrays.asList(AUTHOR_1,AUTHOR_2));
        when(authorController.getAllAuthors()).thenReturn(authors);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/author/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String responseBody = mvcResult.getResponse().getContentAsString();
        AuthorDTO[] readAuthors = objectMapper.readValue(responseBody, AuthorDTO[].class);
        for(int i = 0;i<readAuthors.length;i++){
            assertEquals(authors.get(i).getName(),readAuthors[i].getName());
        }
    }
}
