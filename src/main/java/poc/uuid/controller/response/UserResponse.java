package poc.uuid.controller.response;

import java.util.List;
import lombok.Builder;

@Builder
public class UserResponse {
    public Long id;
    public String name;
    public List<AddressResponse> addresses;
}
