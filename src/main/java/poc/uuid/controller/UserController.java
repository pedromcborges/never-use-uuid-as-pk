package poc.uuid.controller;

import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import poc.uuid.controller.response.AddressResponse;
import poc.uuid.controller.response.AddressUuidResponse;
import poc.uuid.controller.response.UserHybridResponse;
import poc.uuid.controller.response.UserResponse;
import poc.uuid.controller.response.UserUuidResponse;
import poc.uuid.domain.repository.UserBinRepository;
import poc.uuid.domain.repository.UserUuidBinRepository;
import poc.uuid.domain.repository.UserUuidVarcharRepository;
import poc.uuid.domain.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserBinRepository userBinRepository;
    private final UserUuidVarcharRepository userUuidVarcharRepository;
    private final UserUuidBinRepository userUuidBinRepository;

    public UserController(
        final UserRepository userRepository,
        final UserBinRepository userBinRepository,
        UserUuidVarcharRepository userUuidVarcharRepository,
        UserUuidBinRepository userUuidBinRepository) {
        this.userRepository = userRepository;
        this.userBinRepository = userBinRepository;
        this.userUuidVarcharRepository = userUuidVarcharRepository;
        this.userUuidBinRepository = userUuidBinRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public Page<UserResponse> getUser() {
        final var users = userRepository.findAll(PageRequest.of(0, 20));
        return users.map(user -> UserResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .addresses(user.getAddress().stream()
                .map(address -> AddressResponse.builder()
                    .id(address.getId())
                    .street(address.getStreet())
                    .neighborhood(address.getNeighborhood())
                    .city(address.getCity())
                    .country(address.getCountry())
                    .number(address.getNumber())
                    .build())
                .collect(Collectors.toList()))
            .build());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/binary")
    public Page<UserHybridResponse> getUserBin() {
        final var users = userBinRepository.findAll(PageRequest.of(0, 20));
        return users.map(user -> UserHybridResponse.builder()
            .id(user.getExternalId())
            .name(user.getName())
            .addresses(user.getAddress().stream()
                .map(address -> AddressResponse.builder()
                    .id(address.getId())
                    .street(address.getStreet())
                    .neighborhood(address.getNeighborhood())
                    .city(address.getCity())
                    .country(address.getCountry())
                    .number(address.getNumber())
                    .build())
                .collect(Collectors.toList()))
            .build());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/uuid-string")
    public Page<UserUuidResponse> getStringUuids() {
        final var users = userUuidVarcharRepository.findAll(PageRequest.of(0, 20));
        return users.map(user -> UserUuidResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .addresses(user.getAddress().stream()
                .map(address -> AddressUuidResponse.builder()
                    .id(address.getId())
                    .user_id(address.getUserId())
                    .street(address.getStreet())
                    .neighborhood(address.getNeighborhood())
                    .city(address.getCity())
                    .country(address.getCountry())
                    .number(address.getNumber())
                    .build())
                .collect(Collectors.toList()))
            .build());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/uuid-binary")
    public Page<UserUuidResponse> getBinaryUuids() {
        final var users = userUuidBinRepository.findAll(PageRequest.of(0, 20));
        return users.map(user -> UserUuidResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .addresses(user.getAddress().stream()
                .map(address -> AddressUuidResponse.builder()
                    .id(address.getId())
                    .user_id(address.getUserId())
                    .street(address.getStreet())
                    .neighborhood(address.getNeighborhood())
                    .city(address.getCity())
                    .country(address.getCountry())
                    .number(address.getNumber())
                    .build())
                .collect(Collectors.toList()))
            .build());
    }
}
