package Shopekepper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Show_items extends shope_details {
	
	
	public Show_items() {
	}
	
	public void show_items() throws FileNotFoundException {
		/*
		 * 1) username is stored from current_user.txt
		 * 2) check for the presence of user in shop_add_items:
		 * 		i)if present:
		 * 			will read the line of user and print all the items
		 * 		ii) if not:
		 * 			print no item to show
		 * 3) Content of file(shop_add_items):
		 * 		username1[item1,price1 details1:item2,price2,detail2:]
		 * 		username2[..]
		 * 		....
		 */
		
		Scanner st=new Scanner(new File("shop_add_items.txt"));//scanning the file
		
		String read;		//reading lines from file
		String file_data="";//for storing all the lines of file
		String split[];		//to store string array by using split
		String item_data;	//for the item_data
		String split2[];	//to store string array by using split
		
		int present=1;		//to check whether it is present
		int count=0;		//count number of lines and spaces(two uses)
		int find=1;			//to find the line which contains user data
		int start,end;		//for start index and end index of "[" and  "]"
		
		String username;
		
		Scanner su=new Scanner(new File("current_user.txt"));//scanning cureent user from the file
		username=su.nextLine();
		
		//temping line one by one and checking for the usename
		while(st.hasNextLine()) {
			read=st.nextLine();
			file_data=file_data+read+"\n";		//storing details of whole file in file_data
			split=read.split("\\[");			//splitting to take username from line
			count=count+1;
			if(username.equals(split[0])) {
				present=present*0;
				find=count;						//find is position of line where we found user
			}
		}
		if(present==0) {
			//user is present
			int coun=1;
			split=file_data.split("\n");
			read=split[find-1];//store the line which is required in read.
			start=read.indexOf("[");
			end=read.indexOf("]");
			item_data=read.substring(start+1,end);
			split=item_data.split("\\:");
			System.out.println("sr.no.                   items                    price                    details\n");
			for(String i : split) {
				split2=i.split("\\,");
				find=25-split2[0].length();//to have equal spacing, we leave 25 spaces
				count=25-split2[1].length();
				System.out.print((coun++)+"                         "+split2[0]);
				for(int j=0;j<find;j++) {
					System.out.print(" ");
				}
				System.out.print(split2[1]);
				for(int j=0;j<count;j++) {
					System.out.print(" ");
				}
				System.out.print(split2[2]+"\n");
			}
			
		}
		else {
			System.out.println("No items are present, please add some");
		}
		
	}

}
