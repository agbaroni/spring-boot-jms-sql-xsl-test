package io.github.agbaroni.tests;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Bean
	@ConfigurationProperties("pippo")
	public DataSource pippo() {
		return DataSourceBuilder.create().build();
	}

	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}
}