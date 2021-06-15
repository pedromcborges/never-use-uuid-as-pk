package poc.uuid.controller;

import com.github.javafaker.Faker;
import javassist.NotFoundException;
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

    public UserController(UserStringRepository userStringRepository, UserBinaryRepository userBinaryRepository) {
        this.userStringRepository = userStringRepository;
        this.userBinaryRepository = userBinaryRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/string")
    public List<UserResponse> getStringUuids() {
        final var userString = userStringRepository.findAll();
        return userString.stream()
                .map(it -> UserResponse.set(it.getId(), it.getName()))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/string/{id}")
    public UserResponse getStringUuid(@PathVariable String id) throws NotFoundException {
        final var userString = userStringRepository.findById(id);
        if (userString.isPresent()) {
            return UserResponse.set(userString.get().getId(), userString.get().getName());
        } else {
            throw new NotFoundException("Not found");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/binary")
    public List<UserResponse> getBinaryUuids() {
        final var userBinary = userBinaryRepository.findAll();
        return userBinary.stream()
                .map(it -> UserResponse.set(UuidHelper.getUUIDFromBytes(it.getId()).toString(), it.getName()))
                .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/binary/{id}")
    public UserResponse getBinaryUuid(@PathVariable String id) throws NotFoundException {
        final var userBinary = userBinaryRepository.findById(UuidHelper.getBytesFromUUID(UUID.fromString(id)));
        if (userBinary.isPresent()) {
            return UserResponse.set(UuidHelper.getUUIDFromBytes(userBinary.get().getId()).toString(), userBinary.get().getName());
        } else {
            throw new NotFoundException("Not found");
        }
    }
}
