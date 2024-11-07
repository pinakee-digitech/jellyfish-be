package com.jellyFish.be.JellyFish.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User("Harsha", "vharsha50@gmail.com", "abcd"));
		users.add(new User("Harsha2", "harsha.vrx@gmail.com", "abcd2"));
	}

	public List<User> findAll() {
		return users;
	}

	public User addUser(User user) {
		users.add(user);
		return user;
	}

	public User findOne(String name) {
		// TODO Auto-generated method stub
		Predicate<? super User> predicate = user -> user.getName().equals(name);
		return users.stream().filter(predicate).findFirst().orElse(null);
	}

}
