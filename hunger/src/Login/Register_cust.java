package Login;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register_cust {

	String username;
	String password;
	String address;
	
	public Register_cust(String username,String password,String address){
		this.username=username;
		this.password=password;
		this.address=address;
	}
	
	public boolean check_regis(String file) throws IOException{
		/*
		 * file(login_shop) is readed and checked username:
		 * 		1) if not found:
		 * 				registration successful
		 * 		2) if found:
		 * 				input taken again 
		 */
		int is_user_present=1;//to check whether user exists already
		Scanner sc=new Scanner(new File(file));
		String s;//to read lines of file
		String splitter[];
		
		FileWriter f2=new FileWriter(new File("current_user.txt"));
		while(sc.hasNextLine()) {
			s=sc.nextLine();
			splitter=s.split(",");
			if(username.equals(splitter[0])){
				is_user_present=is_user_present*0;
			}
			else {
				is_user_present=is_user_present*1;
			}
		}
		if(is_user_present==1) {
			FileWriter f=new FileWriter(new File(file),true);
			f.write("\n"+username+","+password+","+address);
			f.close();
			
			f2.write(username);
			f2.close();
		
			System.out.println("Registered Succesfully!!");
			return false;
			
		}
		else {
			System.out.println("Username already exist..");
			return true;
		}
		
	}
}