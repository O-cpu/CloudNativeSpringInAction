package com.example.catalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import java.util.Locale;

@SpringBootApplication
@ConfigurationPropertiesScan
public class CatalogServiceApplication {

	public static void main(String[] args) {

		Locale.setDefault(Locale.ENGLISH);
		System.out.println(Locale.getDefault());
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

}
