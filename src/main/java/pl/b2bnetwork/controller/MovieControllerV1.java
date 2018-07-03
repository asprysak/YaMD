package pl.b2bnetwork.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.b2bnetwork.model.Movie;
import pl.b2bnetwork.service.MovieServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/v1/movies")
public class MovieControllerV1 {

    private final MovieServiceImpl movieServiceImplV1;

    @Autowired
    public MovieControllerV1(MovieServiceImpl movieServiceImplV1) {
        this.movieServiceImplV1 = movieServiceImplV1;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getAllMovies() {
        return movieServiceImplV1.getAllMovies();
    }

    @GetMapping(path = "/id={id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Movie getMovieById(@PathVariable("id") Long movieId) throws NotFoundException {
        return movieServiceImplV1.getMovieById(movieId);
    }

    @GetMapping(path = "/t={movieTitle}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getMovieByTitle(@PathVariable("movieTitle") String movieTitle) {
        return movieServiceImplV1.getMoviesByTitle(movieTitle);
    }

    @GetMapping(path = "/y={year}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getMovieByYear(@PathVariable("year") Integer year) {
        return movieServiceImplV1.getMoviesByYear(year);
    }

    @GetMapping(path = ("/count"),
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String countMovies() {
        return movieServiceImplV1.countMovies();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMovie(@RequestBody Movie movie) {
        movieServiceImplV1.addMovie(movie);
    }

    @PutMapping(path = ("/id={id}"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateMovie(
            @PathVariable("id") Long movieId, @RequestBody Movie movie) throws NotFoundException {
        movieServiceImplV1.updateMovie(movieId, movie);
    }

}