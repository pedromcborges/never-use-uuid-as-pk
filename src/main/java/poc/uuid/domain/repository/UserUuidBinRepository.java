package poc.uuid.domain.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc.uuid.domain.userUuidBin.UserUuidBin;

@Repository
public interface UserUuidBinRepository extends JpaRepository<UserUuidBin, UUID> {
}
