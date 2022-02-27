package de.dhbw.ase.plugins.rest;

import de.dhbw.ase.mangacollector.domain.episode.Episode;
import de.dhbw.ase.mangacollector.episode.EpisodeApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/episode")
public class EpisodeController {
    private EpisodeApplicationService episodeApplicationService;
    @Autowired
    public EpisodeController(EpisodeApplicationService episodeApplicationService){
        this.episodeApplicationService = episodeApplicationService;
    }
    @GetMapping("")
    public List<Episode> getAllEpisodes() {
        return episodeApplicationService.getEpisodes();
    }
}
