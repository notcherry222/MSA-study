package com.playdata.springcloudgatewaystudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudGatewayStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayStudyApplication.class, args);
	}

}
