package poc.uuid.domain.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc.uuid.domain.userVarchar.UserVarchar;

@Repository
public interface UserVarcharRepository extends JpaRepository<UserVarchar, UUID> {
}
