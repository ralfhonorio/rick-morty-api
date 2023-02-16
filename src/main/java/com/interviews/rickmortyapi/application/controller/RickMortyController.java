package com.interviews.rickmortyapi.application.controller;

import com.interviews.rickmortyapi.domain.model.CharacterResponse;
import com.interviews.rickmortyapi.domain.model.EpisodeResponse;
import com.interviews.rickmortyapi.domain.model.ListOfEpisodesResponse;
import com.interviews.rickmortyapi.domain.model.LocationResponse;
import com.interviews.rickmortyapi.domain.service.RickMortyServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/api/v1/rickmorty")
public class RickMortyController {

    private RickMortyServiceImpl rickMortyService;

    public RickMortyController(RickMortyServiceImpl rickMortyService) {
        this.rickMortyService = rickMortyService;
    }

    @GetMapping("/character/{id}")
    public ResponseEntity<CharacterResponse> findCharacterById(@PathVariable String id) {

        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }

        try {
            CharacterResponse characterResponse = rickMortyService.findCharacterById(id);

            if (characterResponse == null) {
                return ResponseEntity.notFound().build();
            } else
                return ResponseEntity.ok(characterResponse);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }




    @GetMapping("/location/{id}")
    public ResponseEntity<LocationResponse> findLocationById(@PathVariable String id) {


        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }

        try {
            LocationResponse locationResponse = rickMortyService.findLocationById(id);

            if (locationResponse == null) {
                return ResponseEntity.notFound().build();
            } else
                return ResponseEntity.ok(locationResponse);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/episode/{id}")
    public ResponseEntity<EpisodeResponse> findEpisodeById(@PathVariable String id) {

        try {
            Integer.parseInt(id);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }

        try {
            EpisodeResponse episodeResponse = rickMortyService.findEpisodeById(id);

            if (episodeResponse == null) {
                return ResponseEntity.notFound().build();
            } else
                return ResponseEntity.ok(episodeResponse);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/episodes")
    public ResponseEntity<Flux<ListOfEpisodesResponse>> findAllEpisodes() {

        try {
            Flux<ListOfEpisodesResponse> episodes = rickMortyService.findAllEpisodes();

            if (episodes == null) {
                return ResponseEntity.notFound().build();
            } else
                return ResponseEntity.ok(episodes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
