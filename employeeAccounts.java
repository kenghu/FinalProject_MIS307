/**
	Author: Xiaoxian Si && Keng Hu
	Implementation Date: 4-17-2016
	Description of Class: The class manages a collection of employee accounts.
 */


package TeamProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class employeeAccounts {
	private ArrayList<employeeAccount> accounts;
	
	/**
	 * Constructs a company with no employee accounts.
	 */
	public employeeAccounts(){
		accounts = new ArrayList<employeeAccount>();
	}
	
	/**
	 * Adds an account to this company.
	 * @param a the account to add
	 */
	public void addAccount(employeeAccount a){
		accounts.add(a);
	}
	
	/**
	 * Removes an account from the company.
	 * @param a the account to remove
	 */
	public void removeAccount(employeeAccount a){
		accounts.remove(a);
	}
	public void writeAccount(String fileName) throws FileNotFoundException
	{
		ArrayList<String> empLastName = new ArrayList<String>();
		ArrayList<String> empFirstName = new ArrayList<String>();
		ArrayList<String> empSSN = new ArrayList<String>();
		ArrayList<String> address = new ArrayList<String>();
		ArrayList<String> maritalStatus = new ArrayList<String>();
		ArrayList<Double> empHourlyRate = new ArrayList<Double>();
		ArrayList<Double> empHours = new ArrayList<Double>();
		for(employeeAccount b : accounts)
		{
			empLastName.add( b.getEmployeeLastName());
			empFirstName.add(b.getEmployeeFirstName());
			empSSN.add(b.getEmployeeSSN());
			address.add(b.getEmployeeAddress());
			maritalStatus.add(b.getMaritalStatus());
			empHourlyRate.add(b.getEmployeeHourlyRate());
			empHours.add(b.getEmployeeHour());
		}
		PrintWriter out = new PrintWriter(fileName);
		for(int i = 0; i< empLastName.size()&&i< empFirstName.size() &&i< empSSN.size()&& i< address.size() &&i< maritalStatus.size() &&i< empHourlyRate.size() &&i< empHours.size();i++)
		{
			out.print(empLastName.get(i)+",");
			out.print(empFirstName.get(i)+",");
			out.print(empSSN.get(i)+",");
			out.print(address.get(i)+",");
			out.print(maritalStatus.get(i)+",");
			out.print(empHourlyRate.get(i)+",");
			out.print(empHours.get(i)+",");
		}
		out.close();
	}


	
	/**
	 * Finds a employee account with a given number.
	 * @param empNumber the number to find
	 * @return the account with the given number, or null if there
	 * is no such account
	 */
	public employeeAccount find(String empSSN)
	{
		for (employeeAccount a : accounts)
		{
			if (a.getEmployeeSSN().equals(empSSN))
				return a;
		} 
		return null;
	}
	
	/**
	 * Load the accounts from the given file.
	 * @param in - Scanner from which to read account information
	 */
	public void readEmployeeAccounts(Scanner in){
		in.useDelimiter(",");
		int counter = 1;
		ArrayList<String> empLastName = new ArrayList<String>();
		ArrayList<String> empFirstName = new ArrayList<String>();
		ArrayList<String> empSSN = new ArrayList<String>();
		ArrayList<String> address = new ArrayList<String>();
		ArrayList<String> maritalStatus = new ArrayList<String>();
		ArrayList<Double> empHourlyRate = new ArrayList<Double>();
		ArrayList<Double> empHours = new ArrayList<Double>();
		while (in.hasNext()){
			if (counter%7==1){
				String employeeLastName = in.next();
				empLastName.add(employeeLastName.trim());
			}
			if (counter%7==2){
				String employeeFirstName = in.next();
				empFirstName.add(employeeFirstName.trim());
			}
			if (counter%7==3){
				String employeeSSN = in.next();
				empSSN.add(employeeSSN);
			}
			if (counter%7==4){
				String empAddress = in.next();
				address.add(empAddress.trim());
			}
			if (counter%7==5){
				String status = in.next();
				maritalStatus.add(status.trim());
			}
			if (counter%7==6){
				double rate = in.nextDouble();
				empHourlyRate.add(rate);
			}
			if (counter%7==0){
				double hours = in.nextDouble();
				empHours.add(hours);
			}
			counter++;
		}
		for(int i = 0; i < empLastName.size() && i < empFirstName.size() && i < empSSN.size() && i < address.size() && i < maritalStatus.size() && i < empHourlyRate.size() && i < empHours.size();i++){
			String employeeLastName = empLastName.get(i);
			String employeeFirstName = empFirstName.get(i);
			String employeeSSN = empSSN.get(i);
			String empAddress = address.get(i);
			String empStatus = maritalStatus.get(i);
			double rate = empHourlyRate.get(i);
			employeeAccount newAccount = new employeeAccount(employeeLastName, employeeFirstName, employeeSSN, empAddress, empStatus, rate);
			addAccount(newAccount);
		}
	}

}
