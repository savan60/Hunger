package Login;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register_shop {

	String username;
	String password;
	String address;
	String rest;
	
	public Register_shop(String username,String password,String address,String rest){
		this.username=username;
		this.password=password;
		this.address=address;
		this.rest=rest;
	}
	
	public boolean check_regis(String file) throws IOException{
		int is_user_present=1;
		Scanner sc=new Scanner(new File(file));
		String s;
		String splitter[];
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
			f.write("\n"+username+","+password+","+address+","+rest);
			f.close();
		
			System.out.println("Registered Succesfully!!");
			return false;
			
		}
		else {
			System.out.println("Username already exist..");
			return true;
		}
		
	}
}