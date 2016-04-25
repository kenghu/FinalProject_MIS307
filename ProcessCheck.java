package FinalProjectMIS307;
import java.util.*;
public class ProcessCheck {
	private String firstName;
	private String lastName;
	private double payment;
	private String paymentString;
	private String date;
	public ProcessCheck (String firstName_P, String lastName_P, double payment_P, String paymentString_P, String date_P)
	{
		firstName = firstName_P;
		lastName = lastName_P;
		payment = payment_P;
		paymentString = paymentString_P;
		date = date_P;
	}
	public void printCheck()
	{
	int border=50;
	for(int i =0;i<=border;i++){
		System.out.print("* ");
	}
	System.out.println();
	System.out.print("*");
	for(int i = 1;i< 100;i++)
		System.out.print(" ");
	System.out.println("*");
	
	System.out.println();
	System.out.print("*  MIS SUPERMAN Company");
	for(int i =22;i<99;i++)
		System.out.print(" ");
	System.out.println("*");
	String a1 = "*  Gerdin";
	String b1 ="";
	for (int i = 0; i < 100-a1.length();i++)
		b1 = b1+" ";
	System.out.println(a1+b1+"*");
	String a = "*  IOWA STATE UNIVERSITY";
	String b = "DATE: ";
	String c="";
	String d = "";
	for(int i = 0; i <= 60-a.length();i++)
		c = c+" ";
	for(int i = 0; i< 40-b.length()-date.length()-1;i++)
		d = d+" ";
	System.out.println(a + c +b + date + d +"*");
	String a2="*  PAY TO THE ORDER OF: ";
	String b2 = firstName + " " + lastName;
	String c2 = "$ "+ payment;
	String d2 = "";
	for(int i = 0; i <= 60 - a2.length() - b2.length();i++)
		d2 = d2+" ";
	String e2 = "";
	for(int i = 0; i < 40 - c2.length()-1;i++)
		e2 = e2+" ";
	System.out.println(a2+b2+d2+c2+e2+"*");
	String a3 = "";
	for (int i =0 ; i < 99 ;i ++)
		a3 = a3+" ";
	System.out.println("*"+a3+"*");
	String a4 = "*  "+paymentString;
	String b4 = "Dollars";
	String c4 = "";
	for(int i =0;i<= 80-a4.length();i++)
		c4 = c4+" ";
	String c5 = "";
	for(int i = 0; i < 20-b4.length()-1;i++)
		c5 = c5+" ";
	System.out.println(a4+c4+b4+c5+"*");
	System.out.println("*"+a3+"*");
	System.out.println("*"+a3+"*");
	String a6 = "*  MEMO: Monthly Salary";
	String b6 = "";
	for(int i = 0; i <= 60 - a6.length();i++)
		b6 = b6+" ";
	String c6 = "Signature_____________";
	String d6 = "";
	for(int i = 0; i < 40 - c6.length()-1;i++)
		d6 = d6+" ";
	System.out.println(a6+b6+c6+d6+"*");
	
	for(int i=0;i<=border;i++){
		System.out.print("* ");
	}
}
	
	}