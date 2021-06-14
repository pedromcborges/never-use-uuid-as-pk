package poc.uuid.controller;

import com.github.javafaker.Faker;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import poc.uuid.controller.response.UserResponse;
import poc.uuid.domain.UserBinary;
import poc.uuid.domain.UserString;
import poc.uuid.domain.repository.UserBinaryRepository;
import poc.uuid.domain.repository.UserStringRepository;
import poc.uuid.helpers.UuidHelper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserStringRepository userStringRepository;
    private final UserBinaryRepository userBinaryRepository;
    private final Faker faker = new Faker();

    public UserController(UserStringRepository userStringRepository, UserBinaryRepository userBinaryRepository) {
        this.userStringRepository = userStringRepository;
        this.userBinaryRepository = userBinaryRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/string")
    public UserString createString() {
        final UserString userString = UserString.set(UUID.randomUUID().toString(), faker.name().name());
        return userStringRepository.save(userString);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/string")
    public List<UserResponse> getUserStrings() {
        final var userString = userStringRepository.findAll();
        return userString.stream()
                .map(it -> UserResponse.set(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/binary")
    public UserBinary createBinary() {
        final UserBinary userBinary = UserBinary.set(UuidHelper.getBytesFromUUID(UUID.randomUUID()), faker.name().name());
        return userBinaryRepository.save(userBinary);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/binary")
    public List<UserResponse> getUserBinaries() {
        final var userBinary = userBinaryRepository.findAll();
        return userBinary.stream()
                .map(it -> UserResponse.set(UuidHelper.getUUIDFromBytes(it.getId()).toString(), it.getName()))
                .collect(Collectors.toList());
    }
}
