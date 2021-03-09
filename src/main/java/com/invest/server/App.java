package com.invest.server;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class App {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
