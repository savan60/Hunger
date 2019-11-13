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
		if(present==0) {
			temp2=temp3.split("\n");
//			for(String i:temp2) {
//				System.out.println(i);
//			}
			for(int j=0;j<(k);j++) {
				temp5=temp2[f[j]].split("\\,");
			
//				for(String i:temp5) {
//					System.out.println(i);
//				}
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
				System.out.println(temp6[0]+"   "+temp6[1]+"   "+temp6[2]+"   "+rest+"   "+adress);
			}
		}
		else {
			System.out.println("You don't have any orders!");
		}
		
	}
}
