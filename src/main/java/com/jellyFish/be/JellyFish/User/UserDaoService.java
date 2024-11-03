package com.jellyFish.be.JellyFish.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User("Harsha", "vharsha50@gmail.com"));
		users.add(new User("Harsha2", "harsha.vrx@gmail.com"));
	}

	public List<User> findAll() {
		return users;
	}

	public User addUser(User user) {
		users.add(user);
		return user;
	}

}
