package io.discordia.netflux.controllers;

import io.discordia.netflux.domain.Movie;
import io.discordia.netflux.domain.MovieEvent;
import io.discordia.netflux.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {

  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping(value="/{id}/events")
  Flux<MovieEvent> streamMovieEvents(@PathVariable String id){
    return movieService.events(id);
  }
  @GetMapping(value="/{id}")
  Mono<Movie> getMovieById(@PathVariable String id){
    return movieService.getMovieById(id);
  }
  @GetMapping
  Flux<Movie> getAllMovies(){
    return movieService.getAllMovies();
  }

}
