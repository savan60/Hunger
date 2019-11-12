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
			System.out.println("temp2[0] is"+temp2[0]+" temp2[1] is "+temp2[1]);
			System.out.println("username is "+username+" current user is "+current_user);
			if(username.equals(temp2[0]) && current_user.equals(temp2[1])) {
				present=present*0;
				f=d;						//f is position of line where we found user
			}
		}
		s="["+item+";"+quan+";"+price+"]";
		
		if(present==1) {
			FileWriter f2=new FileWriter(new File("orders.txt"),true);
			temp5="\n"+username;
		
			s=temp5+","+current_user+","+s;
			f2.write(s);
			f2.close();
		}
		else {
			temp2=temp3.split("\n");
			temp=temp2[f-1];
			e=temp.indexOf(']');			//index after which items will be added
			temp5=temp.substring(0,e+1);
			FileWriter f3=new FileWriter(new File("orders.txt"));
			s=temp5+","+s;
			temp2[f-1]=s;
			temp3="";
			for( String i : temp2){
				temp3=temp3+i+"\n";			//combining all the lines to one string
			}
			f3.write(temp3);
			f3.close();
			
		}
		
	}

}
