package io.discordia.netflux.service;

import io.discordia.netflux.domain.Movie;
import io.discordia.netflux.domain.MovieEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieService {

  Flux<MovieEvent> events(String movieId);

  Mono<Movie> getMovieById(String id);

  Flux<Movie> getAllMovies();
}
