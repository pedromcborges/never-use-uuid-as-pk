package poc.uuid.domain.userUuidVarchar;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address_uuid_varchar")
public class AddressUuidVarchar {

    @Id
    @Column(columnDefinition = "VARCHAR(36)", nullable = false, unique = true)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @JoinColumn(name = "user_id", nullable = false)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID userId;

    private String street;

    private String neighborhood;

    private String city;

    private String country;

    private Integer number;
}
