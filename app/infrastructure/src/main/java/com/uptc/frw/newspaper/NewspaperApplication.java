package com.uptc.frw.newspaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class NewspaperApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewspaperApplication.class, args);
    }

}
