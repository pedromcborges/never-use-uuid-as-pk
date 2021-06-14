package poc.uuid.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_string")
public class UserString {

    @Id
    private String id;

    private String name;

    public static UserString set(String id, String name) {
        UserString userString = new UserString();

        userString.id = id;
        userString.name = name;

        return userString;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
