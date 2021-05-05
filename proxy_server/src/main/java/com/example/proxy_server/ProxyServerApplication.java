package com.example.proxy_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableZuulServer
@EnableEurekaClient
public class ProxyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyServerApplication.class, args);
	}

}
