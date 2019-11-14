package hunger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Login.Register_cust;
import Login.Register_shop;
import Login.login;

public class onCreate {
	
	int user_type;
	
	onCreate(int user_type){
		this.user_type=user_type;//means Shopekeeper or Customer
	}

	public void logup() throws IOException {
		/*
		 * In these we have asked user for login or register.
		 * 
		 * Taken input needed for login and register,
		 * and passed that input to login.java.
		 * 
		 * For registration there are two different class:
		 * 		1) Register_shop for shopekepper
		 * 		2) Register_cust for customer
		 */
		Scanner st=new Scanner(System.in);
		String file="";
		if(user_type==1) {
			file="login_shop.txt";
		}
		else {
			file="login_cus.txt";
		}
		int log_inp;
		boolean bol=true;
		int c;//c is used to store return value from login.
		//login and register
		System.out.println("Welcome to hungry\n1.Login 2.Register");
		log_inp=st.nextInt();
		if(log_inp==1) {
			while(bol) {
				String Username;
				System.out.println("Your Username");
				Username=st.next();
				System.out.println("Your Password");
				String password=st.next();
				login log_o=new login(Username,password);
				c=log_o.check_login(file);
				if(c==0) {
					bol=false;	//means login is successful
				}
				else if(c==1) {
					bol=true;	//means login is unsuccessful and while loop will exectute again
				}
				else if(c==-1) {
					System.out.println("1.Login 2.Register");//if username is not found, it ask for login or register
					int inp=st.nextInt();
					if(inp==1) {
						bol=true;
					}
					else if(inp==2) {
						log_inp=2;
						System.out.println("Please register first");
						bol=false;
					}
				}
			}
		}
		if(log_inp==2) {
			bol=true;
			while(bol) {
				System.out.println("Username");
				String username=st.next();
				System.out.println("Password");
				String password=st.next();
				System.out.println("Address");
				String extra=st.nextLine();
				String address=st.nextLine();
				if(user_type==1) {
					//user_type=1 is for shopekepper
					System.out.println("Restaurent");//info only for shopekepper
					String rest=st.nextLine();
					Register_shop regist=new Register_shop(username,password,rest,address);
					bol=regist.check_regis(file);
				}
				else {
					Register_cust register=new Register_cust(username,password,address);
					bol=register.check_regis(file);
				}
			}
		}
	}
}
