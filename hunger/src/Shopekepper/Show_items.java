package Shopekepper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Show_items extends shope_details {
	
	
	public Show_items() {
	}
	
	public void show_items() throws FileNotFoundException {
		
		Scanner st=new Scanner(new File("shop_add_items.txt"));//scanning the file
		
		String temp,temp3="",temp2[],temp4,temp5[];
		
		int present=1,d=0,f=1,start,end;
		
		String username;
		
		Scanner su=new Scanner(new File("current_user.txt"));//scanning cureent user from the file
		username=su.nextLine();
		
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
		if(present==0) {
			temp2=temp3.split("\n");
			temp=temp2[f-1];
			System.out.println("temp is "+temp);
			start=temp.indexOf("[");
			end=temp.indexOf("]");
			temp4=temp.substring(start+1,end);
			System.out.println("temp4 is "+temp4);
			temp2=temp4.split("\\:");
			System.out.println("                         items                    price                    details");
			for(String i : temp2) {
				temp5=i.split("\\,");
				f=25-temp5[0].length();//to have equal spacing, we leave 25 spaces
				d=25-temp5[1].length();
				System.out.print("                         "+temp5[0]);
				for(int j=0;j<f;j++) {
					System.out.print(" ");
				}
				System.out.print(temp5[1]);
				for(int j=0;j<d;j++) {
					System.out.print(" ");
				}
				System.out.print(temp5[2]+"\n");
			}
			
		}
		else {
			System.out.println("No items are present, please add some");
		}
		
	}

}
