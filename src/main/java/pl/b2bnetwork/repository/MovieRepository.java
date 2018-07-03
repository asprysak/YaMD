package pl.b2bnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.b2bnetwork.model.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT * FROM movie WHERE title LIKE %:movieTitle%",
            nativeQuery = true)
    List<Movie> findByTitle(@Param("movieTitle") String movieTitle);

    @Query(value = "SELECT COUNT(*) FROM movie;",
            nativeQuery = true)
    String countAllMovies();

    List<Movie> findByYear(@Param("year") Integer year);

}