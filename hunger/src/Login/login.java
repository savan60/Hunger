package Login;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class login {

	String username;
	String password;
	
	public login(String username,String password){
		this.username=username;
		this.password=password;
	}
	
	public int check_login(String file) throws IOException{
		/*
		 * The username is stored in current_user.txt,so that it can be used later.
		 * The file variable is the name of file(login_cus or login_shop) acc. to user_type.
		 * 
		 * content in file is:
		 * 		1) username,password,address(customer)
		 * 		2) username,password,restaurant,address(shopkepper)
		 */
		boolean b=true;
		int c=-1;//for returning value to onCreate.java
		Scanner sc=new Scanner(new File(file));
		String s;			//to read each line in file
		String compare[];	//to store array of string after splitting with ","
		FileWriter f=new FileWriter(new File("current_user.txt"));
		while(sc.hasNextLine()) {
			s=sc.nextLine();
			compare=s.split(",");
			if(username.equals(compare[0]) && password.equals(compare[1])) {
				//sc.close();
				System.out.println("Login is successful");
				f.write(username);
				f.close();
				return 0;//for successful login
			}
			else if(username.equals(compare[0]) && !(password.equals(compare[1]))){
				System.out.println("Password is wrong!!");
				//sc.close();
				f.write(username);
				f.close();
				return 1;//for unsuccessful login
			}
		}
		f.write(username);
		f.close();
		System.out.println("User not found!!");	
		return c;//when user is not present
	}
}
