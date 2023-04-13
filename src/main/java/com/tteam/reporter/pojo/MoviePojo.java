package com.tteam.reporter.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class MoviePojo {

    private String nameUkr;
    private String nameNative;
    private Integer yearOfRelease;
    private String description;
    private Double price;
    private Double rating;
    private String poster;
    private Set<CountryPojo> countries;
    private Set<GenrePojo> genres;
}
