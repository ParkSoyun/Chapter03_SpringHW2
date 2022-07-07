package com.sparta.springhw1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringHw1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringHw1Application.class, args);
    }

}
