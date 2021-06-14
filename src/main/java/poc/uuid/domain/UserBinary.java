package poc.uuid.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_binary")
public class UserBinary {

    @Id
    private byte[] id;

    private String name;

    public static UserBinary set(byte[] id, String name) {
        UserBinary userBinary = new UserBinary();

        userBinary.id = id;
        userBinary.name = name;

        return userBinary;
    }

    public byte[] getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
