package com.ecoman.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.ecoman.springboot","com.ecoman.rest","com.ecoman.async","com.ecoman.neo4j","com.ecoman.license"})
@EntityScan({"com.ecoman.jpa"})
@EnableJpaRepositories({"com.ecoman.jpa"})
@ImportResource("classpath:beans.xml")
public class MicroServiceApp {
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApp.class, args);
	}
	@Bean
	public FilterRegistrationBean authFilter() {
		System.out.println("create authFilter...");
		FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
		filterRegBean.setFilter(new SecurityFilter());
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		filterRegBean.setUrlPatterns(urlPatterns);
		return filterRegBean;
	}
	
}

