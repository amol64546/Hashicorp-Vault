package com.hashicorp.vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class VaultApplication {

  public static void main(String[] args) {
    SpringApplication.run(VaultApplication.class, args);
  }

}
