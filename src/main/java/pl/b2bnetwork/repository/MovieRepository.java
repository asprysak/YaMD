package pl.b2bnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.b2bnetwork.domain.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitle(@Param("title") String title);

    @Query(value = "SELECT COUNT(*) FROM movie;",
            nativeQuery = true)
    String countAllMovies();

    List<Movie> findByYear(@Param("year") Integer year);

}