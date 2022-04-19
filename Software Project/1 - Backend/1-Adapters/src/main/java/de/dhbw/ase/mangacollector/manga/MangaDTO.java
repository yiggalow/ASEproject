package de.dhbw.ase.mangacollector.manga;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import de.dhbw.ase.mangacollector.author.AuthorDTO;
import de.dhbw.ase.mangacollector.episode.EpisodeDTO;
import de.dhbw.ase.mangacollector.genre.GenreDTO;
import de.dhbw.ase.mangacollector.publisher.PublisherDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "publisher",
        "author",
        "genre",
        "episodeList"
})
@Generated("jsonschema2pojo")
public class MangaDTO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("publisher")
    private PublisherDTO publisher;
    @JsonProperty("author")
    private AuthorDTO author;
    @JsonProperty("genre")
    private GenreDTO genre;
    @JsonProperty("episodeList")
    private List<EpisodeDTO> episodeList = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("publisher")
    public PublisherDTO getPublisher() {
        return publisher;
    }

    @JsonProperty("publisher")
    public void setPublisher(PublisherDTO publisher) {
        this.publisher = publisher;
    }

    @JsonProperty("author")
    public AuthorDTO getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    @JsonProperty("genre")
    public GenreDTO getGenre() {
        return genre;
    }

    @JsonProperty("genre")
    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }

    @JsonProperty("episodeList")
    public List<EpisodeDTO> getEpisodeList() {
        return episodeList;
    }

    @JsonProperty("episodeList")
    public void setEpisodeList(List<EpisodeDTO> episodeList) {
        this.episodeList = episodeList;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
