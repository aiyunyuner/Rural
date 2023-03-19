package com.TypeDelta;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class RuralEmploymentConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RuralEmploymentConsumerApplication.class, args);
    }
}