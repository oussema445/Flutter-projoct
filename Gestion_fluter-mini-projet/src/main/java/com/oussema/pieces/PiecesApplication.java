package com.oussema.pieces;

import com.oussema.pieces.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.oussema.pieces.entities.Pieces;

@SpringBootApplication
@EntityScan(basePackages = "com.oussema.pieces.entities")
public class PiecesApplication implements CommandLineRunner {


	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(PiecesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
      repositoryRestConfiguration.exposeIdsFor(Pieces.class);
	}

}
