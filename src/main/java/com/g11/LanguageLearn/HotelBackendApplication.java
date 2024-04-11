package com.g11.LanguageLearn;

import com.g11.LanguageLearn.property.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class HotelBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(HotelBackendApplication.class, args);
  }

}
