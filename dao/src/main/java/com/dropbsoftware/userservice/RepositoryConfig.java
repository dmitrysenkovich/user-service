package com.dropbsoftware.userservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.dropbsoftware.userservice")
public class RepositoryConfig {
}
