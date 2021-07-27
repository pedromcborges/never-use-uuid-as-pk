package poc.uuid.controller;

import java.util.UUID;
import java.util.stream.Collectors;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import poc.uuid.controller.response.AddressResponse;
import poc.uuid.controller.response.AddressUuidResponse;
import poc.uuid.controller.response.UserHybridResponse;
import poc.uuid.controller.response.UserResponse;
import poc.uuid.controller.response.UserUuidResponse;
import poc.uuid.domain.repository.UserHybridRepository;
import poc.uuid.domain.repository.UserRepository;
import poc.uuid.domain.repository.UserUuidBinRepository;
import poc.uuid.domain.repository.UserUuidVarcharRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserHybridRepository userHybridRepository;
    private final UserUuidVarcharRepository userUuidVarcharRepository;
    private final UserUuidBinRepository userUuidBinRepository;

    public UserController(
        final UserRepository userRepository,
        final UserHybridRepository userHybridRepository,
        final UserUuidVarcharRepository userUuidVarcharRepository,
        final UserUuidBinRepository userUuidBinRepository) {
        this.userRepository = userRepository;
        this.userHybridRepository = userHybridRepository;
        this.userUuidVarcharRepository = userUuidVarcharRepository;
        this.userUuidBinRepository = userUuidBinRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable final Long id) throws NotFoundException {
        final var user = userRepository.findById(id).orElseThrow(() ->
            new NotFoundException("User not found"));
        return UserResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .addresses(user.getAddresses().stream()
                .map(address -> AddressResponse.builder()
                    .street(address.getStreet())
                    .neighborhood(address.getNeighborhood())
                    .city(address.getCity())
                    .country(address.getCountry())
                    .number(address.getNumber())
                    .build())
                .collect(Collectors.toList()))
            .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/hybrid/{id}")
    public UserHybridResponse getUserHybrid(@PathVariable final UUID id) throws NotFoundException {
        final var user = userHybridRepository.findByExternalId(id).orElseThrow(() ->
            new NotFoundException("User not found"));
        return UserHybridResponse.builder()
            .id(user.getExternalId())
            .name(user.getName())
            .addresses(user.getAddresses().stream()
                .map(address -> AddressResponse.builder()
                    .street(address.getStreet())
                    .neighborhood(address.getNeighborhood())
                    .city(address.getCity())
                    .country(address.getCountry())
                    .number(address.getNumber())
                    .build())
                .collect(Collectors.toList()))
            .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/uuid-string/{id}")
    public UserUuidResponse getStringUuids(@PathVariable final UUID id) throws NotFoundException {
        final var user = userUuidVarcharRepository.findById(id).orElseThrow(() ->
            new NotFoundException("User not found"));
        return UserUuidResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .addresses(user.getAddresses().stream()
                .map(address -> AddressUuidResponse.builder()
                    .street(address.getStreet())
                    .neighborhood(address.getNeighborhood())
                    .city(address.getCity())
                    .country(address.getCountry())
                    .number(address.getNumber())
                    .build())
                .collect(Collectors.toList()))
            .build();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/uuid-binary/{id}")
    public UserUuidResponse getBinaryUuids(@PathVariable final UUID id)
        throws NotFoundException {
        final var user = userUuidBinRepository.findById(id).orElseThrow(() ->
            new NotFoundException("User not found"));
        return UserUuidResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .addresses(user.getAddresses().stream()
                .map(address -> AddressUuidResponse.builder()
                    .street(address.getStreet())
                    .neighborhood(address.getNeighborhood())
                    .city(address.getCity())
                    .country(address.getCountry())
                    .number(address.getNumber())
                    .build())
                .collect(Collectors.toList()))
            .build();
    }
}
