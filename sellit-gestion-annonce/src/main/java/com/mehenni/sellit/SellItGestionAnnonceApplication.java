package com.mehenni.sellit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableDiscoveryClient
@SpringBootApplication
public class SellItGestionAnnonceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellItGestionAnnonceApplication.class, args);
	}
}
