package hunger;

import Shopekepper.*;
import java.io.*;
import java.util.*; 
import Login.*;

public class Main {

	public static void main(String[] args) throws IOException{
		Scanner ste=new Scanner(System.in);
//		FileWriter f2=new FileWriter("login_shop.txt");
//		f2.write("savan 1234 radhika");
//		f2.close();
//		
//		FileWriter f=new FileWriter("login_cus.txt");
//		f.write("savan 1234 radhika residency");
//		f.close();
		System.out.println("Who are you??\n1.Shopkepper2.Coustomer");
		int prof_input=ste.nextInt();
		if(prof_input==1) {
			onCreate oncreate=new onCreate();
			oncreate.logup(1);
		}
		else if(prof_input==2) {
			onCreate oncreate=new onCreate();
			oncreate.logup(2);
		}
		ste.close();
		boolean b=true;
		String shopno="";
		String strings="";
		String[] stri=new String[5];
		while(b) {
		// TODO Auto-generated method stub
		System.out.println("name");
		//String name=sc.next();
		System.out.println("shopno");
		//shopno=st.next();
		for(int i=0;i<5;i++) {
			System.out.println("item"+i);
			//stri[i]=ste.next();
			strings=strings+" "+stri[i];
		}
		b=false;
		}
		//shope_details shope=new shope_details(name,shopno,stri);
		
		
//		FileWriter fw=new FileWriter("sagar.txt");
//		fw.write(shope.name+" "+shope.shop_no+strings);
//		fw.close();
	}

}
