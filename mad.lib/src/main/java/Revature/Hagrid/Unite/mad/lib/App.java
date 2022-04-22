package Revature.Hagrid.Unite.mad.lib;

import java.util.Scanner;

import com.madlib.dao.MadLibDAO;
import com.madlib.dao.MadLibDAOImpl;
import com.madlib.dao.MadLibModel;
import com.madlib.dao.UserDAO;
import com.madlib.dao.UserDAOImpl;
import com.madlib.dao.UserModel;

/**
 * Hello world!
 *
 */
public class App 
{
	static UserDAO ud = new UserDAOImpl();
	static MadLibDAO md = new MadLibDAOImpl();
	static UserModel u;
	static String user;
	static String pass;
	
    public static void main( String[] args )
    {
    	//User Sign in or register
    	Scanner sc = new Scanner(System.in);
    
    	System.out.println("Please select an option");
    	System.out.println("1. Log In");
    	System.out.println("2. Sign Up");
    	int option = sc.nextInt();
    	
    	switch (option) {
    	case 1: u = logIn();
    	break;
    	case 2: u = signUp();
    	break;
    	default:
    	
    	}
    	

    	System.out.println(u);
    	System.out.println("Please select an option");
    	System.out.println("1. Create a mad lib");
    	System.out.println("2. load a previously saved madlib");
    	
    	option = sc.nextInt();
    	switch (option) {
    	case 1: createMadLib(u);
    	break;
    	case 2: loadMadLib(u);
    	break;
    	default:
    	}
    }
    
    public static UserModel logIn() {
    		
    		Scanner sc = new Scanner(System.in);
    		
    	    System.out.println("Login");
    		System.out.print("Enter username: ");
    		user = sc.next();
    		System.out.println();
    		System.out.print("Enter password: ");
    		pass = sc.next();
    		UserModel u = ud.getUser(user, pass);
    		while (u == null){
    			System.out.println("Invalid username or password."); 
    			System.out.println("Please try again.");
    			System.out.print("Enter username: ");
    	    	user = sc.next();
    	    	System.out.println();
    	    	System.out.print("Enter password: ");
    	    	pass = sc.next();
    			u = ud.getUser(user, pass);
    			}
    		System.out.println("Success! You are now logged in!");
    		return u;
    }
    
    public static UserModel signUp() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Please enter username and password to sign up");
		System.out.println("Enter username: ");
		user = sc.next();
		System.out.println();
		System.out.println("Enter password: ");
		pass = sc.next();
		UserModel u = new UserModel(0, user, pass);
		ud.createUser(u);
		
		return u;
    	
    }
    
    public static void createMadLib(UserModel u) {
    	//create empty madlib model
    	Scanner sc = new Scanner(System.in);
    	MadLibModel ml = new MadLibModel();
    	//prompt user for madlib model properties
    	System.out.println("Enter a noun: ");
		ml.noun = sc.next();
		System.out.println("Enter an adverb: ");
		ml.adverb = sc.next();
		System.out.println("Enter a verb: ");
		ml.verb = sc.next();
		System.out.println("Enter an adjective: ");
		ml.adjective = sc.next();
		
		String madLib = "One day, a " + ml.noun +
						" went to the market to " + ml.verb +
						". Noticing the day was " + ml.adjective +
						", though, the market closed " + ml.adverb;
		System.out.println(madLib);
		System.out.println("Would you like to save your mad lib? Y/N");
		String options = sc.next();
		options = options.toUpperCase();
		
		switch (options) {
    	case "Y": System.out.println("What would you like to name your Mad Lib?");
    			  ml.storyName = sc.next();
    			  md.createMadlib(u, ml);
    		break;
    	default:
		}
    	//after each prompt scan in responses
    	
    	//create madlib string and include spaces for the madlib elements
    	
    	//output the madluib string to user
    	
    	//ask user if they want to save
    	
    	//if yes call saveMadlib()
    	
    	//if no their loss
    	
    }
    
    public static void loadMadLib(UserModel u) {
    	
    }
    
    public static void saveMadLib(UserModel u, String s) {
    	//push madlib model to database
    }
    
   
}
