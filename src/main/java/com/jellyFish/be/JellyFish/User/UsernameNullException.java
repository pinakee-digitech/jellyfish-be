package com.jellyFish.be.JellyFish.User;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UsernameNullException extends RuntimeException {
	public UsernameNullException(String message) {
		super(message);
	}

}
