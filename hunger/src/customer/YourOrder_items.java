package customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class YourOrder_items extends customer{

	
	public void yourorder_items() throws FileNotFoundException {
		Scanner sc=new Scanner(new File("orders.txt"));
		Scanner st=new Scanner(new File("current_user.txt"));
		String current_user=st.nextLine();
		String temp,temp3="";
		String temp6[];
		String temp7[];
		String rest="",adress="";
		int present=1,d=0,e;
		int[] f=new int[10];
		int k=0;
		String[] temp2;
		String[] temp5;
		while(sc.hasNextLine()) {
			temp=sc.nextLine();
			temp3=temp3+temp+"\n";
			temp2=temp.split("\\,");
			d=d+1;
			if(current_user.equals(temp2[1])) {
				present=present*0;
				f[k++]=d-1;
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
		for(int j1=0;j1<15;j1++) {
			System.out.print(" ");
		}
		System.out.print("Restaurent");
		for(int j1=0;j1<18;j1++) {
			System.out.print(" ");
		}
		System.out.print("Address\n\n");
		
		
		if(present==0) {
			int count=1;
			temp2=temp3.split("\n");

			for(int j=0;j<(k);j++) {
				temp5=temp2[f[j]].split("\\,");
			

				Scanner sp=new Scanner(new File("login_shop.txt"));
				while(sp.hasNextLine()) {
					temp=sp.nextLine();
					temp7=temp.split("\\,");
					if(temp7[0].equals(temp5[0])){
						rest=temp7[2];
						adress=temp7[3];
					}
				}	
				temp3=temp5[2].substring(1,temp5[2].length()-1);
				temp6=temp3.split("\\;");
				int space1=25-temp6[0].length();
				int space2=25-temp6[1].length();
				int space3=25-temp6[2].length();
				int space4=25-rest.length();
				int space5=25-adress.length();
				System.out.print(count++);
				for(int j1=0;j1<space1;j1++) {
					System.out.print(" ");
				}
				System.out.print(temp6[0]);
				for(int j1=0;j1<space2;j1++) {
					System.out.print(" ");
				}
				System.out.print(temp6[1]);
				for(int j1=0;j1<space3;j1++) {
					System.out.print(" ");
				}
				System.out.print(temp6[2]);
				for(int j1=0;j1<space4;j1++) {
					System.out.print(" ");
				}
				System.out.print(rest);
				for(int j1=0;j1<space5;j1++) {
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
