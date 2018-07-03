package pl.b2bnetwork.service;

import javassist.NotFoundException;
import pl.b2bnetwork.model.Movie;

import java.util.List;

interface MovieService {

    List<Movie> getAllMovies();

    Movie getMovieById(Long id) throws NotFoundException;

    List<Movie> getMoviesByTitle(String movieTitle);

    List<Movie> getMoviesByYear(Integer year);

    void addMovie(Movie movie);

    String countMovies();

    void updateMovie(Long movieId, Movie movie) throws NotFoundException;
}
