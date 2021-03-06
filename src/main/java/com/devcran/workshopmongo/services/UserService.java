package com.devcran.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcran.workshopmongo.domain.User;
import com.devcran.workshopmongo.dtos.UserDTO;
import com.devcran.workshopmongo.repositories.UserRepository;
import com.devcran.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();

	}

	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User user) {
		return userRepository.insert(user);

	}

	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());

	}

	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}

	public User update(User obj) {
		User newUser = findById(obj.getId());
		updateData(newUser, obj);
		return userRepository.save(newUser);
	}

	private void updateData(User newUser, User user) {
		// TODO Auto-generated method stub
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		

	}
}
















