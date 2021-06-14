package poc.uuid.domain.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "poc.uuid.domain.repository")
@EntityScan(basePackages = "poc.uuid.domain")
public class RepositoriesConfig {
}
