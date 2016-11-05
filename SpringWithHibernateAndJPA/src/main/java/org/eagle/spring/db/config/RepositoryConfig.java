package org.eagle.spring.db.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="org.eagle.spring.db.repository")
public class RepositoryConfig {

}
