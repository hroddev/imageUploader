package com.hroddev.imageUploader;

import com.hroddev.imageUploader.context.StorageProperties;
import com.hroddev.imageUploader.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ImageUploaderApplication {

	public static void main(String[] args) {

		SpringApplication.run(ImageUploaderApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService){
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
