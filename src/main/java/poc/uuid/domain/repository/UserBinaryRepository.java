package poc.uuid.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poc.uuid.domain.UserBinary;

@Repository
public interface UserBinaryRepository  extends JpaRepository<UserBinary, byte[]> {
}
