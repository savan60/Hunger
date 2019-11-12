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
		boolean b=true;
		int c=-1;
		Scanner sc=new Scanner(new File(file));
		String s;
		String compare[];
		FileWriter f=new FileWriter(new File("current_user.txt"));
		while(sc.hasNextLine()) {
			s=sc.nextLine();
			compare=s.split(",");
			if(username.equals(compare[0]) && password.equals(compare[1])) {
				//sc.close();
				System.out.println("Login is successful");
				f.write(username);
				f.close();
				return 0;
			}
			else if(username.equals(compare[0]) && !(password.equals(compare[1]))){
				System.out.println("Password is wrong!!");
				//sc.close();
				f.write(username);
				f.close();
				return 1;
			}
		}
		f.write(username);
		f.close();
		System.out.println("User not found!!");	
		return c;
	}
}
