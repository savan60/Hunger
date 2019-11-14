package hunger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Login.Register;
import Login.Register_shop;
import Login.login;

public class onCreate {
	
	int user_type;
	
	onCreate(int user_type){
		this.user_type=user_type;
	}

	public void logup() throws IOException {
		
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
		int c;
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
					bol=false;
				}
				else if(c==1) {
					bol=true;
				}
				else if(c==-1) {
					System.out.println("1.Login 2.Register");
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
					System.out.println("Restaurent");
					String rest=st.nextLine();
					Register_shop regist=new Register_shop(username,password,rest,address);
					bol=regist.check_regis(file);
				}
				else {
					Register register=new Register(username,password,address);
					bol=register.check_regis(file);
				}
			}
		}
	}
	
	
	
}
