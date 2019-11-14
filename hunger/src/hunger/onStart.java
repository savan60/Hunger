package hunger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Shopekepper.Add_items;
import Shopekepper.Show_items;
import Shopekepper.View_Orders;
import Shopekepper.shope_details;
import customer.Order_items;
import customer.YourOrder_items;
import customer.customer;

public class onStart {
	
	int user_type;

	public onStart(int user_type) {
		this.user_type=user_type;
	}
	
	public void shop_methods() throws IOException {
		/*
		 * All the features for shopekepper
		 * ->object of shope_details is made		
		 * 		1)All the other class(in package Shopekepper) are child of shope_details.
		 * 		2)according to input given by user,object is assigned.
		 */
		
		Scanner sc=new Scanner(System.in);
		
		shope_details sd;
		boolean b = true;
		while(b) {
		//System.out.println(Username);
		System.out.println("1.Add items 2.show all items 3.View orders 4.logout");
		int a=sc.nextInt();
		switch(a) {
			case 1:
				sd = new Add_items();
				sd.add_items();
				break;
			case 2:
				sd=new Show_items();
				sd.show_items();
				break;
			case 3:
				sd=new View_Orders();
				sd.view_orders();
				break;
			case 4:
				onCreate oncreate=new onCreate(user_type);
				try {
					oncreate.logup();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public void cust_methods() throws FileNotFoundException {
		/*
		 * All the features for Customer
		 * ->object of customer is made		
		 * 		1)All the other class(in package Customer) are child of customer.
		 * 		2)according to input given by user,object is assigned.
		 */
		Scanner sc=new Scanner(System.in);
		customer cd;
		boolean b = true;
		while(b) {
			try {
				{
				//System.out.println(Username);
				System.out.println("1.Are you hungry? 2.Your Orders  3.logout");
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
					case 3:
						onCreate oncreate=new onCreate(user_type);
						try {
							oncreate.logup();
						} catch (IOException e) {
							e.printStackTrace();
						}	
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
