package pl.eninja.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.eninja.domain.Movie;
import pl.eninja.service.MovieServiceV1;

import java.util.List;

@RestController
@RequestMapping("/v1/movie")
public class MovieControllerV1 {

  @Autowired
  private MovieServiceV1 movieServiceV1;

  @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<Movie> getAllMovies() {
    return movieServiceV1.getAll();
  }

  @GetMapping(path = "/id={id}",
              produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Movie getMovieById(
          @PathVariable("id")
                  Long movieId) throws NotFoundException {
    return movieServiceV1.findById(movieId);
  }
  @GetMapping(path = "/t={title}",
              produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<Movie> getMovieByTitle(
          @PathVariable("title")
                  String title) {
    return movieServiceV1.findByTitle(title);
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
               consumes = MediaType.APPLICATION_JSON_VALUE)
  public void addMovie(
          @RequestBody
                  Movie movie) {
    movieServiceV1.add(movie);
  }
}