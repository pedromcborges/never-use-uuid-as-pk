package poc.uuid.domain.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc.uuid.domain.userBin.UserHybrid;

@Repository
public interface UserHybridRepository extends JpaRepository<UserHybrid, Long> {

  Optional<UserHybrid> findByExternalId(UUID uuid);
}
