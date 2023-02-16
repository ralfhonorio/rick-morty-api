package com.interviews.rickmortyapi.domain.service;

import com.interviews.rickmortyapi.domain.model.CharacterResponse;
import com.interviews.rickmortyapi.domain.model.EpisodeResponse;
import com.interviews.rickmortyapi.domain.model.ListOfEpisodesResponse;
import com.interviews.rickmortyapi.domain.model.LocationResponse;
import reactor.core.publisher.Flux;


public interface IRickMortyService {
    CharacterResponse findCharacterById(String id);

    LocationResponse findLocationById(String id);

    EpisodeResponse findEpisodeById(String id);

    Flux<ListOfEpisodesResponse> findAllEpisodes();

}