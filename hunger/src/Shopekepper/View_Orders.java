package Shopekepper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class View_Orders extends shope_details {
	
	public void view_orders() throws FileNotFoundException {
		/*
		 * 1) username is stored from current_user.txt
		 * 2) check for the presence of shopkepper in orders.txt:
		 * 		i)if present:
		 * 			show all the items present in it
		 * 		ii) if not:
		 * 			print No orders
		 * 3) Content of file(order.txt):
		 * 		shopkepper,customer,[item1;quantity1;price1]
		 * 		shopkepper,customer,[item2,quantity2,price2]
		 * 		shopkepper2,customer,[...]
		 * 		shopkepper3,customer3,[...]
		 * 		....
		 * 4) Data address of customer is taken from login_shop.txt
		 * 5) Content of file(login_shop):
		 * 		username,password,address(customer)
		 * 		...
		 */
		Scanner sc=new Scanner(new File("orders.txt"));
		Scanner st=new Scanner(new File("current_user.txt"));
		String current_user=st.nextLine();
		String read;
		String file_data="";
		String split[];
		String split2[];
		String adress="";
		int present=1,count=0;
		int[] find_line=new int[10];
		int k=0;
		String[] split1;
		String[] split4;
		while(sc.hasNextLine()) {
			read=sc.nextLine();
			file_data=file_data+read+"\n";
			split1=read.split("\\,");
			count=count+1;
			if(current_user.equals(split1[0])) {
				present=present*0;
				find_line[k++]=count-1;
			}
		}
		
		System.out.print("sr.no.");
		for(int j1=0;j1<14;j1++) {
			System.out.print(" ");
		}
		System.out.print("Items");
		for(int j1=0;j1<17;j1++) {
			System.out.print(" ");
		}
		System.out.print("Quantity");
		for(int j1=0;j1<20;j1++) {
			System.out.print(" ");
		}
		System.out.print("Price");
		for(int j1=0;j1<18;j1++) {
			System.out.print(" ");
		}
		System.out.print("Address\n\n");
		
		
		if(present==0) {
			count=1;//for sr.no.
			split1=file_data.split("\n");
			for(int j=0;j<(k);j++) {
				split4=split1[find_line[j]].split("\\,");
				Scanner sp=new Scanner(new File("login_cus.txt"));
				while(sp.hasNextLine()) {
					read=sp.nextLine();
					split2=read.split("\\,");
					if(split2[0].equals(split4[1])){
						adress=split2[2];
					}
				}	
				file_data=split4[2].substring(1,split4[2].length()-1);
				split=file_data.split("\\;");
				int space1=25-split[0].length();
				int space2=25-split[1].length();
				int space3=25-split[2].length();
				int space4=25-adress.length();
				System.out.print(count++);
				for(int j1=0;j1<space1;j1++) {
					System.out.print(" ");
				}
				System.out.print(split[0]);
				for(int j1=0;j1<space2;j1++) {
					System.out.print(" ");
				}
				System.out.print(split[1]);
				for(int j1=0;j1<space3;j1++) {
					System.out.print(" ");
				}
				System.out.print(split[2]);
				for(int j1=0;j1<space4;j1++) {
					System.out.print(" ");
				}
				System.out.println(adress);
			}
		}
		else {
			System.out.println("You don't have any orders!");
		}
		

	}

}
