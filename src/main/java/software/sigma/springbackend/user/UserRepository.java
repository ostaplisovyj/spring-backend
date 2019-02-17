package software.sigma.springbackend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByFirstname(String firstname);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
    
}
