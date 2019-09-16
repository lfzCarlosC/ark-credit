package com.cryptal.ark.arkcreditmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.com.gome.page","com.cryptal.ark.arkcreditmanager"})
public class ArkCreditApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArkCreditApplication.class, args);
	}

}

