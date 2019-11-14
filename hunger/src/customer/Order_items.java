package customer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Order_items extends customer{
	
	 
	public void order_items() {
		Scanner sc=new Scanner(System.in);
		customer cd;
		boolean b = true;
		while(b) {
		//System.out.println(Username);
		System.out.println("1.Restaurant 2.food_items 3.exit");
		int a=sc.nextInt();
		switch(a) {
			case 1:
				Restaurant rest=new Restaurant();
			try {
				rest.main_rest();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case 2:
				Food_items all_items=new Food_items();
			try {
				all_items.food_items();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case 3:
				b=false;
				break;
			}
			
		}
		
	}

}
