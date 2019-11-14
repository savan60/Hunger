package customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Food_items {

	public void food_items() throws IOException {
		Scanner sc=new Scanner(new File("login_shop.txt"));
		Scanner sp=new Scanner(new File("shop_add_items.txt"));
		Scanner st=new Scanner(System.in); 
		String temp,temp2[],temp3="";
		String temp4[];
		int i=0,j=0;
		while(sc.hasNextLine()) {
			temp=sc.nextLine();
			temp2=temp.split(",");
			temp3=temp3+temp2[0]+",";
			i++;
		}
		temp4=temp3.split("\\,");
		Show_items_cust select_all;
		select_all=new Show_items_cust(temp4);
		select_all.show_items();
		j++;	
	}
}
