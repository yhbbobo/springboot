package com.ecoman.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.ecoman.jpa.Receipt;
import com.ecoman.jpa.ReceiptLine;

@Configuration
public class MyRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration {
    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        super.configureRepositoryRestConfiguration(config);
        config.setBasePath("/admin");
        config.exposeIdsFor(Receipt.class);
        config.exposeIdsFor(ReceiptLine.class);
    }
}
