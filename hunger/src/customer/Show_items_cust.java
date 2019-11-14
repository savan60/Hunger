package customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Show_items_cust  {
	
	String username[];
	
	public Show_items_cust(String username[]) {
		this.username=username;
	}
	
	public void show_items() throws IOException {
		String temp,temp3="",temp2[],temp4,temp5[];
		
		int k=0,l=1,w=0,q=0,u=0;
		String items[]=new String[10];
		String price[]=new String[10];
		String users[]=new String[10];
		System.out.println("sr.no.                     items                    price                    details\n");
		while(k!=(username.length)) {
			int present=1,d=0,f=1,start,end;
			Scanner st=new Scanner(new File("shop_add_items.txt"));//scanning the file
		//Reading line one by one and checking for the usename
		while(st.hasNextLine()) {
			temp=st.nextLine();
			temp3=temp3+temp+"\n";			//storing details of whole file in temp3
			temp2=temp.split("\\[");		//splitting to take username from line
			d=d+1;
			if((username[k]).equals(temp2[0])) {
				present=present*0;
				f=d;						//f is position of line where we found user
			}
		}
		if(present==0) {
			temp2=temp3.split("\n");
			temp=temp2[f-1];
			start=temp.indexOf("[");
			end=temp.indexOf("]");
			temp4=temp.substring(start+1,end);
			temp2=temp4.split("\\:");
			
			for(String i : temp2) {
				temp5=i.split("\\,");
				f=25-temp5[0].length();
				d=25-temp5[1].length();
				System.out.print(l+"                         "+temp5[0]);
				for(int j=0;j<f;j++) {
					System.out.print(" ");
				}
				System.out.print(temp5[1]);
				for(int j=0;j<d;j++) {
					System.out.print(" ");
				}
				System.out.print(temp5[2]+"\n");
				l++;
				
				items[w++]=temp5[0];
				price[u++]=temp5[1];
				users[q++]=username[k];
			}
			
		}
		k++;
		}
		boolean b=true;
		while(b) {
			Scanner sc=new Scanner(System.in);
			//System.out.println(Username);
			System.out.println("1.Select item to place order 2.exit");
			int a=sc.nextInt();
			int inp;
			switch(a) {
				case 1:
					System.out.println("Give input according to sr.no.");
					inp=sc.nextInt();
					System.out.println("Quantity");
					int quan=sc.nextInt();
					int prize=quan*Integer.parseInt(price[inp-1]);
					System.out.println("Toatal price is "+quan+"*"+price[inp-1]+"="+prize);
					System.out.println("1.Confirm 2.cancel");
					int inpu=sc.nextInt();
					if(inpu==1) {
						Place_order rest=new Place_order(users[inp-1],items[inp-1],quan,prize);
						rest.place_order();
						break;
					}
					else {
						break;
					}
				case 2:
					b=false;
					break;
				}
				
			}
	}

}
