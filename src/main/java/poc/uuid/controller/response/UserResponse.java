package poc.uuid.controller.response;

public class UserResponse {
    public String id;
    public String name;

    public static UserResponse set(String id, String name) {
        UserResponse response = new UserResponse();
        response.id = id;
        response.name = name;

        return response;
    }
}
