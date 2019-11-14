package hunger;

import Shopekepper.*;
import java.io.*;
import java.util.*; 
import Login.*;

public class Main {

	public static void main(String[] args) throws IOException {
		/*Hello, Welcome to Hunger!
		 * In these Main class,we just take input for type of user,
		 * and go to onCreate for login/signup
		 * then we call onStart
		 */
		Scanner ste=new Scanner(System.in);
		
		System.out.println("Who are you??\n1.Shopkepper2.Coustomer");
		int prof_input=ste.nextInt();
		
		//when the project is started it requests for login and password in onCreate.java
		onCreate oncreate=new onCreate(prof_input);
		try {
			oncreate.logup();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//All the types of features of Hunger is present in onStart,which is called after onCreate
		onStart onstart=new onStart(prof_input);
		
		String username;
		Scanner su=new Scanner(new File("current_user.txt"));
		username=su.nextLine();
		System.out.println("Welcome "+username);
		
		if(prof_input==1) {
			onstart.shop_methods();//shopkepper's feature
		}
		else if(prof_input==2) {
			onstart.cust_methods();//customer's feature
		}	
	}
}
