package com.devcran.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devcran.workshopmongo.domain.Post;
import com.devcran.workshopmongo.domain.User;
import com.devcran.workshopmongo.dtos.AuthorDTO;
import com.devcran.workshopmongo.dtos.CommentDTO;
import com.devcran.workshopmongo.repositories.PostRepository;
import com.devcran.workshopmongo.repositories.UserRepository;

@Configuration
public class Instanciation implements CommandLineRunner {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PostRepository postRepo;

	@Override
	public void run(String... args) throws Exception {

		userRepo.deleteAll();
		postRepo.deleteAll();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepo.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem!", "Vou viajar para SP, abraços!",
				new AuthorDTO(maria));

		Post post2 = new Post(null, sdf.parse("22/03/18"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		CommentDTO com1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO com2 = new CommentDTO("Aproveite", sdf.parse("21/03/2018"), new AuthorDTO(bob));
		CommentDTO com3 = new CommentDTO("Tenha um otimo dia", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		
		post1.getCommments().addAll(Arrays.asList(com1, com2));
		post2.getCommments().addAll(Arrays.asList(com3));
		
		postRepo.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));

		userRepo.saveAll(Arrays.asList(maria, alex, bob));
	}

}
