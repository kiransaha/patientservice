package com.patient.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PatientsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsServiceApplication.class, args);
	}
//	@Autowired
//	  private CacheManager cacheManager;

}
