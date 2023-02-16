package com.interviews.rickmortyapi.domain.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Setter
@Getter
public class EpisodeResponse {

    private String id;
    private String name;
    private String air_date;
    private String episode;
    private List<String> characters;
    private String url;

}