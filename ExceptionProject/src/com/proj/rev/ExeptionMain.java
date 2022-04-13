package com.proj.rev;

import java.util.Scanner;

public class ExeptionMain{
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NewException newException = new NewException();
		
		Scanner pets = new Scanner(System.in);
		System.out.println("Enter the number of pets you have: ");
		
		int numOfPets = pets.nextInt();
		
		newException.checkPetNum(numOfPets);
		
		try {
			int numAllowed = newException.pets;
			if(numAllowed <= numOfPets);
			System.out.println("Within the allowed number of pets");
		} 
		catch(Exception e) {
			System.out.println("Not within the allowed number of pets");
		}
		finally {
			System.out.println("Finally runs");
		}

	}

}
