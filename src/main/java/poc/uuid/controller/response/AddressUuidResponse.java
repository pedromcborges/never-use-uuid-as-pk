package poc.uuid.controller.response;

import java.util.UUID;
import lombok.Builder;

@Builder
public class AddressUuidResponse {

  public Long id;
  public UUID user_id;
  public String street;
  public String neighborhood;
  public String city;
  public String country;
  public Integer number;
}
