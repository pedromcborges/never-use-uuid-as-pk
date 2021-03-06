package poc.uuid.controller.response;

import java.util.List;
import java.util.UUID;
import lombok.Builder;

@Builder
public class UserUuidResponse {
    public UUID id;
    public String name;
    public List<AddressUuidResponse> addresses;
}
