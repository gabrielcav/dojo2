package com.dojo.apiServer.api;

import com.dojo.apiServer.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MovieApi {

    private String apiKey = "b699d4b2";

    private String url = "http://www.omdbapi.com/?apikey=";

    private List<Movie> movies;

    @RequestMapping("/movie/{id}")
    public Movie findById (@PathVariable("id") String id){
        RestTemplate restTemplate = new RestTemplate();

        Movie movie = restTemplate.getForObject(url + apiKey + "&i=" + id, Movie.class);

        return movie;
    }

}
