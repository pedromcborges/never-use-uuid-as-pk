package poc.uuid.controller.response;

import lombok.Builder;

@Builder
public class AddressResponse {

  public String street;
  public String neighborhood;
  public String city;
  public String country;
  public Integer number;
}
