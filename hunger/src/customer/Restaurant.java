package customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Shopekepper.Add_items;
import Shopekepper.Show_items;

public class Restaurant {
	
	public void main_rest() throws FileNotFoundException {
		Scanner sc=new Scanner(new File("login_shop.txt"));
		Scanner st=new Scanner(System.in); 
		String temp,temp2[],temp3="";
		String[] username=new String[1];
		String temp4[];
		int i=0,j=0;
		while(sc.hasNextLine()) {
			temp=sc.nextLine();
			temp2=temp.split(",");
			temp3=temp3+temp2[0]+",";
			System.out.println((i+1)+". "+temp2[2]);
			i++;
		}
		temp4=temp3.split("\\,");
		boolean b = true;
		int inpu;
		while(b) {
		//System.out.println(Username);
		System.out.println("1.Select Rest 2.exit");
		int a=st.nextInt();
		switch(a) {
			case 1:
				System.out.println("Give the input according to sr.no.");
				inpu=st.nextInt();
				temp=temp4[inpu-1];
				username[0]=temp; 
				Show_items_cust select=new Show_items_cust(username);
			try {
				select.show_items();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			case 2:
				b=false;
				break;
			}
			
		}
	}

}
