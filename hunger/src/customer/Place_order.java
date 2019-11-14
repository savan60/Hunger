package customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Shopekepper.Show_items;

public class Place_order {
	
	String username,item;
	int quan;
	int price;
	
	public Place_order(String username,String item,int qaun,int price){
		this.username=username;
		this.item=item;
		this.quan=qaun;
		this.price=price;
	}

	public void place_order() throws IOException {
		String s;
		String temp,temp5;
		String temp2[];
		int present=1,d=0,e,f=1;
		String temp3="";
		Scanner st=new Scanner(new File("current_user.txt"));
		String current_user=st.nextLine();
		Scanner sc=new Scanner(new File("orders.txt"));
		while(sc.hasNextLine()) {
			temp=sc.nextLine();
			temp3=temp3+temp+"\n";			//storing details of whole file in temp3
			temp2=temp.split("\\,");
			d=d+1;
		}
		s="["+item+";"+quan+";"+price+"]";
		
		if(present==1) {
			FileWriter f2=new FileWriter(new File("orders.txt"),true);
			temp5="\n"+username;
		
			s=temp5+","+current_user+","+s;
			f2.write(s);
			f2.close();
		}
		
	}

}
