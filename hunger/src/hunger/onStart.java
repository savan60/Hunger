package hunger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Shopekepper.Add_items;
import Shopekepper.Show_items;
import Shopekepper.shope_details;
import customer.Order_items;
import customer.YourOrder_items;
import customer.customer;

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
	
	public void cust_methods() throws FileNotFoundException {
		Scanner sc=new Scanner(System.in);
		customer cd;
		boolean b = true;
		while(b)
			try {
				{
				//System.out.println(Username);
				System.out.println("1.Are you hungry? 2.Your Orders 3.Confirmed Orders 4.exit");
				int a=sc.nextInt();
				switch(a) {
					case 1:
						cd = new Order_items();
						cd.order_items();
						break;
					case 2:
						cd=new YourOrder_items();
						cd.yourorder_items();
						break;
					}
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
