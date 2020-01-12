package io.discordia.netflux.service;

import static reactor.core.publisher.Flux.generate;

import io.discordia.netflux.domain.Movie;
import io.discordia.netflux.domain.MovieEvent;
import io.discordia.netflux.repositories.MovieRepository;
import java.time.Duration;
import java.util.Date;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieServiceimpl implements MovieService {

  private final MovieRepository movieRepository;

  public MovieServiceimpl(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  @Override
  public Flux<MovieEvent> events(String movieId) {
    return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
      movieEventSynchronousSink.next(new MovieEvent(movieId, new Date()));
    }).delayElements(Duration.ofSeconds(1));
  }

  @Override
  public Mono<Movie> getMovieById(String id) {
    return this.movieRepository.findById(id);
  }

  @Override
  public Flux<Movie> getAllMovies() {
    return this.movieRepository.findAll();
  }
}
