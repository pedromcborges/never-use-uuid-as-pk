package poc.uuid.controller.response;

import lombok.Builder;

@Builder
public class AddressUuidResponse {

  public String street;
  public String neighborhood;
  public String city;
  public String country;
  public Integer number;
}
