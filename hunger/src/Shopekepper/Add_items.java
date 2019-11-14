package Shopekepper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Add_items extends shope_details {
	
	public Add_items(){
		
	}
	
	public void add_items() throws IOException {
		/*In these method we will be adding items in the file shop_add_items.txt,
		 * the detials will be added in format "username[item1,price1,detai1:item2,price2,detail2:]"
		 * for each username there is a different line
		 * The two cases are taken: 
		 * 		1) when user is adding item for first time,
		 * 		2) when user have already added some items; 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String s="";						//used for storing items
		String item;						//name of item
		String price;						//price of item
		String detail;						//detail of item
		String username;
		
		Scanner su=new Scanner(new File("current_user.txt"));
		username=su.nextLine();
		boolean b = true;
		int present=1,d=0,e,f=1;			//is element present in file?
		
		String temp;
		String temp2[];
		String temp4;
		String temp3="";
		Scanner st=new Scanner(new File("shop_add_items.txt"));//scanning the file
		
		//Reading line one by one and checking for the usename
		while(st.hasNextLine()) {
			temp=st.nextLine();
			temp3=temp3+temp+"\n";			//storing details of whole file in temp3
			temp2=temp.split("\\[");		//splitting to take username from line
			d=d+1;
			if(username.equals(temp2[0])) {
				present=present*0;
				f=d;						//f is position of line where we found user
			}
		}
		
		//Taking input for items to be added and storing in s
		while(b) {
			System.out.println("1.Add_item or 2.exit");
			int c = sc.nextInt();
			switch(c) {
			case 1:
				System.out.println("Enter the item you wanted to add:");
				item = sc.next();
				System.out.println("Price of item");
				price=sc.next();
				System.out.println("Detail");
				detail=sc.nextLine();
				detail=sc.nextLine();
				s=s+item+","+price+","+detail+":";
				break;
			case 2:
				b=false;
				break;
			}
		}
		
		
		if(present==1) {
			temp4=username+"[";//as user is not present in file
			FileWriter f1=new FileWriter("shop_add_items.txt",true);
			s=temp4+s;
			s=s+"]\n";
			f1.write(s);
			f1.close();
		}
		else {

			temp2=temp3.split("\n");		//temp2 is array of string of lines present in file
			
			temp=temp2[f-1];				//initialising temp to the line where items are going to add
			e=temp.indexOf(']');			//index after which items will be added
			temp4=temp.substring(0,e);
			
			FileWriter f1=new FileWriter("shop_add_items.txt");
			s=temp4+s+"]";
			temp2[f-1]=s;					//updated string is replaced
			temp3="";
			for( String i : temp2){
				temp3=temp3+i+"\n";			//combining all the lines to one string
			}
			f1.write(temp3);
			f1.close();
		}
	}
}
