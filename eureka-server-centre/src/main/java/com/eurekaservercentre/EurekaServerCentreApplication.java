package com.eurekaservercentre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerCentreApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerCentreApplication.class, args);
    }

}
