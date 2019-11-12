package hunger;

import Shopekepper.*;
import java.io.*;
import java.util.*; 
import Login.*;

public class Main {

	public static void main(String[] args) throws IOException {
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
		
		//when the project is started it requests for login and password in onCreate.java
		onCreate oncreate=new onCreate(prof_input);
		try {
			oncreate.logup();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		onStart onstart=new onStart(prof_input,oncreate.Username);
		System.out.println("Welcome "+oncreate.Username);
		
		
//		onStart onstart=new onStart();
		if(prof_input==1) {
			onstart.shop_methods();
		}
		else if(prof_input==2) {
			onstart.cust_methods();
		}
		boolean b=true;
		String name="";
		String shopno="";
		String[] stri=new String[5];
		while(b) {
		System.out.println("name");
		//name=ste.nextLine();
		System.out.println("shopno");
		//shopno=ste.nextLine();
		for(int i=0;i<5;i++) {
			System.out.println("item"+i);
			//stri[i]=ste.next();
			//strings=strings+" "+stri[i];
		}
		b=false;
		}
		//shope_details shope=new shope_details(name,shopno,stri);
		
		
//		FileWriter fw=new FileWriter("sagar.txt");
//		fw.write(shope.name+" "+shope.shop_no+strings);
//		fw.close();
	}

}
