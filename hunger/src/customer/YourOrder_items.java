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
				f[k++]=d;
			}
		}
		if(present==0) {
			temp2=temp3.split("\n");
			for(int j=0;j<(k-1);j++) {
				temp5=temp2[f[j]].split("\\,");
				System.out.println(temp5[2]);
			}
		}
		else {
			System.out.println("You don't have any orders!");
		}
		
	}
}
