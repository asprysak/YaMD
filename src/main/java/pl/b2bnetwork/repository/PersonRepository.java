package pl.b2bnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.b2bnetwork.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
