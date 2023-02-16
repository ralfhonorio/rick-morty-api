package com.interviews.rickmortyapi.domain.service;

import com.interviews.rickmortyapi.domain.model.CharacterResponse;
import com.interviews.rickmortyapi.domain.model.EpisodeResponse;
import com.interviews.rickmortyapi.domain.model.ListOfEpisodesResponse;
import com.interviews.rickmortyapi.domain.model.LocationResponse;
import com.interviews.rickmortyapi.infrastructure.integration.RickMortyRestClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class RickMortyServiceImpl implements IRickMortyService {

    private RickMortyRestClient rickMortyRestClient;

    public RickMortyServiceImpl(RickMortyRestClient rickMortyRestClient) {
        this.rickMortyRestClient = rickMortyRestClient;


    }

    @Override
    public CharacterResponse findCharacterById(String id) {
        return rickMortyRestClient.findCharacterById(id).block();
    }

    @Override
    public LocationResponse findLocationById(String id) {
        return rickMortyRestClient.findLocationById(id).block();
    }

    @Override
    public EpisodeResponse findEpisodeById(String id) {
        return rickMortyRestClient.findEpisodeById(id).block();
    }

    @Override
    public Flux<ListOfEpisodesResponse> findAllEpisodes() {
        return rickMortyRestClient.findAllEpisodes();
    }
}
