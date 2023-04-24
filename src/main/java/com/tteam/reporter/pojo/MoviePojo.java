package com.tteam.reporter.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MoviePojo {

    private String nameUkr;
    private String nameNative;
    private Integer yearOfRelease;
    private String description;
    private Double price;
    private Double rating;
    @JsonProperty("picturePath")
    private String poster;
    @JsonProperty("countriesDto")
    private Set<CountryPojo> countries;
    @JsonProperty("genresDto")
    private Set<GenrePojo> genres;
}
