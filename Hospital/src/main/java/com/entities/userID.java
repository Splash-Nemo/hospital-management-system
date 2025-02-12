package com.entities;

import java.util.Random;

public class userID {

	public static int userIDGenerator() {
		Random randomGenerator = new Random();

		int randomNumber = randomGenerator.nextInt(900000) + 100000;
		
		return randomNumber;
	}
}
