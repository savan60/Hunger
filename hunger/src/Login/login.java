package Login;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class login {

	String username;
	String password;
	
	public login(String username,String password){
		this.username=username;
		this.password=password;
	}
	
	public boolean check_login(String file) throws IOException{
		boolean b=true;
		Scanner sc=new Scanner(new File(file));
		String s;
		String compare[];
		while(sc.hasNextLine()) {
			s=sc.nextLine();
			compare=s.split(" ");
			if(username.equals(compare[0]) && password.equals(compare[1])) {
				sc.close();
				System.out.println("Login is successful");
				return false;
			}
			else if(username.equals(compare[0]) && !(password.equals(compare[1]))){
				System.out.println("Password is wrong!!");
				sc.close();
				return true;
			}
		}
		sc.close();
		System.out.println("User not found!!");
		return b;
	}

	
	
}
