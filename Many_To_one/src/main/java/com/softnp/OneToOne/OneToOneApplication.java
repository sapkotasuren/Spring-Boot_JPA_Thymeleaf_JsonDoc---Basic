package com.softnp.OneToOne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.softnp.OneToOne")
public class OneToOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneToOneApplication.class, args);
    }
}
