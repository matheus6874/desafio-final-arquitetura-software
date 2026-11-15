package com.exemplo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

@SpringBootApplication
public class ApiApplication {
    public static void main(String[] args) throws IOException {
        Files.createDirectories(Path.of("data"));
        SpringApplication.run(ApiApplication.class, args);
    }
}
