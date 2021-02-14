package com.worldmeme.worldmeme;

import com.worldmeme.worldmeme.repos.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorldMemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldMemeApplication.class, args);
	}
}
