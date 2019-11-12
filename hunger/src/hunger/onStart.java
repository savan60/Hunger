package hunger;

import java.io.IOException;
import java.util.Scanner;

import Shopekepper.Add_items;
import Shopekepper.Show_items;
import Shopekepper.shope_details;

public class onStart extends onCreate {
	
	String Username;

	onStart(int user_type,String username) {
		super(user_type);
		Username=username;
	}
	
	public void shop_methods() throws IOException {
		Scanner sc=new Scanner(System.in);
		shope_details sd;
		boolean b = true;
		while(b) {
		//System.out.println(Username);
		System.out.println("1.Add items 2.show all items 3.see orders 4.exit");
		int a=sc.nextInt();
		switch(a) {
			case 1:
				sd = new Add_items(Username);
				sd.add_items();
				break;
			case 2:
				sd=new Show_items(Username);
				sd.show_items();
				break;
			}
			
		}
	}
	
	public void cust_methods() {
		
	}

}
