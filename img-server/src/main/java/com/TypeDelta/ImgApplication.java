package com.TypeDelta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ImgApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImgApplication.class, args);
    }
}