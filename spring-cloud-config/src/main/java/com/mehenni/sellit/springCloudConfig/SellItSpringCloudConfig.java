package com.mehenni.sellit.springCloudConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SellItSpringCloudConfig {

	public static void main(String[] args) {
		SpringApplication.run(SellItSpringCloudConfig.class, args);

	}

}
