package poc.uuid.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc.uuid.domain.UserString;

@Repository
public interface UserStringRepository extends JpaRepository<UserString, String> {
}