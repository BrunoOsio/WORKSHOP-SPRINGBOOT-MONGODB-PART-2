package com.devcran.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devcran.workshopmongo.domain.User;
import com.devcran.workshopmongo.dtos.UserDTO;
import com.devcran.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET) // getMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // getMapping
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);

		return ResponseEntity.ok().body(new UserDTO(obj));

	}

	@RequestMapping(method = RequestMethod.POST) // getMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO userDto) {
		User obj = service.fromDTO(userDto);
		obj = service.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) // getMapping
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);

		return ResponseEntity.noContent().build();

	}

}
