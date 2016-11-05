package org.eagle.spring.db.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DBConfig.class,RepositoryConfig.class})
public class Config {

}
