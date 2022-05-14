package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.domain.episode.Episode;
import de.dhbw.ase.mangacollector.episode.EpisodeApplicationService;
import de.dhbw.ase.mangacollector.episode.EpisodeDTO;
import de.dhbw.ase.mangacollector.episode.EpisodeToEpisodeDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/episode")
public class EpisodeController {
    private EpisodeApplicationService episodeApplicationService;
    private EpisodeToEpisodeDTOMapper episodeToEpisodeDTOMapper;
    @Autowired
    public EpisodeController(EpisodeApplicationService episodeApplicationService, EpisodeToEpisodeDTOMapper episodeToEpisodeDTOMapper){
        this.episodeApplicationService = episodeApplicationService;
        this.episodeToEpisodeDTOMapper = episodeToEpisodeDTOMapper;
    }
    @GetMapping("")
    public List<EpisodeDTO> getAllEpisodes() {
        return episodeApplicationService.getEpisodes().stream().map(episodeToEpisodeDTOMapper).collect(Collectors.toList());
    }
}
