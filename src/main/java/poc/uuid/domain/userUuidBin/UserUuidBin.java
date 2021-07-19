package poc.uuid.domain.userUuidBin;

import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_uuid_bin")
public class UserUuidBin {

    @Id
    private UUID id;

    private String name;

    @OneToMany(targetEntity = AddressUuidBin.class, fetch = FetchType.EAGER, mappedBy = "userId")
    private List<AddressUuidBin> address;
}
