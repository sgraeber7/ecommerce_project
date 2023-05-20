package com.educative.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {
  @Bean
  public OpenAPI EcommerceOpenAPI() {
    return new OpenAPI()
        .info(getApiInfo());
  }

  private Info getApiInfo() {
    return (new Info()
        .title("Ecommerce API")
        .description("Documentation Ecommerce api")
        .version("v0.0.1")
        .license(new License()
            .name("Apache 2.0")
            .url("http://springdoc.org")));
  }

}