import java.util.*;
public class ProcessCheck {
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Please enter employee first name: ");
	String firstName=in.next();
	System.out.println("Please enter employee last name: ");
	String lastName =in.next();
	System.out.print("Please enter payment amount: ");
	Double payment = in.nextDouble();
	System.out.println("Please enter amount in words: ");
	String paymentString=in.next();
	System.out.println("Please enter today's date: ");
	String date = in.next();
	System.out.println("Please print your name here: ");
	String signature=in.next();
	int border=50;
	for(int i=0;i<=border;i++){
		System.out.print("* ");
	}
	System.out.println();
	System.out.println("*                                                       DATE:" + date + "                                *");
	System.out.println("*  PAY TO THE ORDER OF: " + firstName + " " + lastName +"                                      $ " + payment + "                      *");
	System.out.println();
	System.out.println("* " + paymentString + "                                                                DOLLARS"+ "                        *");
	System.out.println();
	System.out.println("* MEMO: Paycheck                                                     " + signature + "                           *");
	
	for(int i=0;i<=border;i++){
		System.out.print("* ");
	}
	}
}
