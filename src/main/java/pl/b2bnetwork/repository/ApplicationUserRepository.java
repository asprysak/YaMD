package pl.b2bnetwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.b2bnetwork.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
