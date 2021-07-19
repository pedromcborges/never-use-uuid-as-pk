package poc.uuid.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc.uuid.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
