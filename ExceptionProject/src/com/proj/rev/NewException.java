package com.proj.rev;

public class NewException extends Exception{
	
	int pets;
	
	public NewException() {
		pets = 2;
	}
	
	static void checkPetNum(int petNum) {
		//this is a method that throws a custom exception if the party size is greater than 6
		if (petNum > 2) {
			throw new ArithmeticException("You are not allowed more than 2 pets");
		} else {
			System.out.println("You do not exceed the amount of allowed pets");
			
		}
	}
	
	

}
