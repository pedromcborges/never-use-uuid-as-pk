package poc.uuid.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import poc.uuid.controller.response.UserUuidResponse;
import poc.uuid.domain.repository.UserUuidBinRepository;
import poc.uuid.domain.repository.UserUuidVarcharRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserUuidVarcharRepository userUuidVarcharRepository;
    private final UserUuidBinRepository userUuidBinRepository;

    public UserController(UserUuidVarcharRepository userUuidVarcharRepository,
        UserUuidBinRepository userUuidBinRepository) {
        this.userUuidVarcharRepository = userUuidVarcharRepository;
        this.userUuidBinRepository = userUuidBinRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/string")
    public List<UserUuidResponse> getStringUuids() {
        final var userString = userUuidVarcharRepository.findAll();
        return userString.stream()
            .map(it -> UserUuidResponse.builder()
                .id(it.getId())
                .name(it.getName())
                .build())
            .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/string/{id}")
    public UserUuidResponse getStringUuid(@PathVariable String id) throws NotFoundException {
        final var userString = userUuidVarcharRepository.findById(id);
        if (userString.isPresent()) {
            return UserUuidResponse.builder()
                .id(userString.get().getId())
                .name(userString.get().getName())
                .build();
        } else {
            throw new NotFoundException("Not found");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/binary")
    public List<UserUuidResponse> getBinaryUuids() {
        final var userBinary = userUuidBinRepository.findAll();
        return userBinary.stream()
            .map(it -> UserUuidResponse.builder()
                .id(it.getId())
                .name(it.getName())
                .build())
            .collect(Collectors.toList());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/binary/{id}")
    public UserUuidResponse getBinaryUuid(@PathVariable String id) throws NotFoundException {
        final var userBinary = userUuidBinRepository.findById(UUID.fromString(id));
        if (userBinary.isPresent()) {
            return UserUuidResponse.builder()
                .id(userBinary.get().getId())
                .name(userBinary.get().getName())
                .build();
        } else {
            throw new NotFoundException("Not found");
        }
    }
}
