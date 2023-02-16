package com.interviews.rickmortyapi.infrastructure.integration;

import com.interviews.rickmortyapi.domain.model.CharacterResponse;
import com.interviews.rickmortyapi.domain.model.EpisodeResponse;
import com.interviews.rickmortyapi.domain.model.ListOfEpisodesResponse;
import com.interviews.rickmortyapi.domain.model.LocationResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@Slf4j
public class RickMortyRestClient {

    private WebClient webClient;

    public RickMortyRestClient() {
        webClient = WebClient.builder().baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<CharacterResponse> findCharacterById(String id) {

        return webClient.
                get()
                .uri("/character/" + id)
                .accept(APPLICATION_JSON)
                .retrieve().
                onStatus(HttpStatusCode::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Params invalid"))).
                onStatus(HttpStatusCode::is5xxServerError,
                        error -> Mono.error(new RuntimeException("API Server error"))).
                bodyToMono(CharacterResponse.class);
    }

    public Mono<LocationResponse> findLocationById(String id) {

        return webClient
                .get()
                .uri("/location/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Params invalid")))
                .onStatus(HttpStatusCode::is5xxServerError,
                        error -> Mono.error(new RuntimeException("API Server error")))
                .bodyToMono(LocationResponse.class);
    }

    public Mono<EpisodeResponse> findEpisodeById(String id) {

        return webClient
                .get()
                .uri("/episode/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Params invalid")))
                .onStatus(HttpStatusCode::is5xxServerError,
                        error -> Mono.error(new RuntimeException("API Server error")))
                .bodyToMono(EpisodeResponse.class);
    }

    public Flux<ListOfEpisodesResponse> findAllEpisodes() {

        return webClient
                .get()
                .uri("/episode")
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,
                        error -> Mono.error(new RuntimeException("Params invalid")))
                .onStatus(HttpStatusCode::is5xxServerError,
                        error -> Mono.error(new RuntimeException("API Server error")))
                .bodyToFlux(ListOfEpisodesResponse.class);
    }
}


