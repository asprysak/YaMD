package pl.eninja.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.eninja.domain.Movie;
import pl.eninja.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceV1 {
  @Autowired
  private MovieRepository movieRepository;
  public List<Movie> getAll() {
    return this.movieRepository.findAll();
  }
  public Movie findById(Long id) throws NotFoundException {
    return movieRepository.findOne(validateMovie(id));
  }
  public List<Movie> findByTitle(String title) {
    return movieRepository.findByTitle(title);
  }
  public void add(Movie movie) {
    movieRepository.save(movie);
  }

  private Long validateMovie(Long movieId) throws NotFoundException {
    return Optional.ofNullable(movieRepository.findOne(movieId))
                   .map(movie -> movie.getId())
                   .orElseThrow(() -> new NotFoundException("Movie not found"));
  }
}
