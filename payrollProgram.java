/**
	Authors: Xiaoxian Si && Keng Hu
	Developers: Benjamin Turkett, Omar Farris, Amin Raouf Ghali 
	Implementation Date: 4-17-2016
	Description of Class: This class is the main class of this Iowa payroll program.
 */


package TeamProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class payrollProgram {
	public static void main(String args[]) throws FileNotFoundException, IOException{
		System.out.println("Welcome to The Iowa Payroll System");
		Scanner in = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String filename = in.nextLine();
		File f = new File(filename);
		Scanner fileReader = new Scanner(f);
		employeeAccounts newAccounts = new employeeAccounts();
		newAccounts.readEmployeeAccounts(fileReader);
		boolean done = false;
		while (!done)
		{
			try
			{
				System.out.println();
				System.out.println("A)dd Employee  E)dit Employee  D)elete Employee  S)earch Employee  Q)uit");
				String input = in.nextLine().toUpperCase();
				
				/*
				 * Add employee with user's inputs
				 */
				
				if (input.equals("A"))
				{
					String eSSN = promptForString(in, "Enter new employee's SSN: ");
					if (newAccounts.find(eSSN) != null)
					{
						System.out.printf("Error: account %s already exists.\n", eSSN);
						System.out.println("Hit 'Enter' to go back to the main menu.");
					}
					else
					{
						System.out.println("Enter employee's last name: ");
						String eLastName = in.nextLine();
						System.out.println("Enter employee's first name: ");
						String eFirstName = in.nextLine();
						System.out.println("Enter employee's address: ");
						String eAddress = in.nextLine();
						System.out.println("Enter employee's marital status (Single/Married): ");
						String eMaritalStatus = in.nextLine();
						System.out.println("Enter employee's hourly rate: ");
						double eHourlyRate = in.nextDouble();
						employeeAccount newAccount = new employeeAccount(eLastName, eFirstName, eSSN, eAddress, eMaritalStatus, eHourlyRate);
						newAccounts.addAccount(newAccount);
						newAccounts.writeAccount(filename);
						System.out.println("Employee Information Added");
					
					}
					in.nextLine();
				}
				
				/*
				 * Edit employee information with user's inputs
				 */
				
				else if(input.equals("E")){
					String eSSN = promptForString(in, "Enter employee's SSN to edit: ");
					employeeAccount account = newAccounts.find(eSSN);
					if (account == null)
					{
						System.out.printf("Error: account %s does not exist.\n", eSSN);
						System.out.println("Hit 'Enter' to go back to the main menu.");
					}
					else
					{
						System.out.println("Employee Found");
						System.out.println(account.toString());
						System.out.println("Enter employee's new last name: ");
						String newLastName = in.nextLine();
						account.employeeLastNameChange(newLastName);
						System.out.println("Enter employee's new first name: ");
						String newFirstName = in.nextLine();
						account.employeeFirstNameChange(newFirstName);
						String empSSN = account.getEmployeeSSN();
						System.out.println("Enter employee's new address: ");
						String newAddress = in.nextLine();
						account.employeeAddressChange(newAddress);
						System.out.println("Enter employee's new marital status (Single/Married): ");
						String newStatus = in.nextLine();
						account.employeeMaritialStatusChange(newStatus);
						System.out.println("Enter employee's new hourly rate: ");
						double newHourlyRate = in.nextDouble();
						account.employeeHourlyRateChange(newHourlyRate);
						employeeAccount newAccount = new employeeAccount(newLastName, newFirstName, eSSN, newAddress, newStatus, newHourlyRate);
						newAccounts.addAccount(newAccount);
						newAccounts.writeAccount(filename);
						System.out.println("Employee Information Changed");
						
					}
					in.nextLine();
				}
				
				/*
				 * Delete employee by user's input
				 */
				
				else if (input.equals("D"))
				{
					String eSSN = promptForString(in, "Enter employee's SSN to delete: ");
					employeeAccount account = newAccounts.find(eSSN);
					if (account == null)
					{
						System.out.printf("Error: account %s does not exist.\n", eSSN);
						System.out.println("Hit 'Enter' to go back to the main menu.");
					}
					else
					{
						System.out.println("Are you sure you want to remove the employee below?");
						System.out.println(account.toString());
						System.out.println("Enter 'YES' to remove");
						String answer1 = in.nextLine();
						if (answer1.equalsIgnoreCase("YES")){
							newAccounts.removeAccount(account);
							System.out.println("Employee Information Removed");
						}
						else System.out.println("Account deletion aborted");
						
					}
					newAccounts.writeAccount(filename);
				}
			
				/*
				 * Search employee by user's input
				 */
				
				else if (input.equals("S"))
				{
					String eSSN = promptForString(in, "Enter employee's SSN for search: ");
					employeeAccount account = newAccounts.find(eSSN);
					if (account==null)
					{
						System.out.printf("Error: account %s does not exist.\n", eSSN);
						System.out.println("Hit 'Enter' to go back to the main menu.");
					}
					else
					{
						System.out.println("Employee Found");
						System.out.println(account.toString());
					
						/*
						 * Compute the payroll 
						 */
						
						System.out.println("Enter 'YES' to start payroll calculation");
						String answer2 = in.nextLine();
						if (answer2.equalsIgnoreCase("YES")){
							System.out.println("Enter employee's work hours for this pay period: ");
							double hourWorked = in.nextDouble();
							account.addHour(hourWorked);
							newAccounts.writeAccount(filename);
							double empHourlyRate = account.getEmployeeHourlyRate();
							String status = account.getMaritalStatus();
							
							PayRollCalculation calculation = new PayRollCalculation(empHourlyRate, hourWorked, status);
							calculation.GrossPay();
							calculation.medicarePay();
							calculation.socialSecurityPay();
							calculation.federalPay();
							calculation.netPay();
							System.out.println();
							System.out.println("***************PAYROLL REPORT***************");
							String name = account.getEmployeeFirstName()  +" "+ account.getEmployeeLastName();
							calculation.report(name);
							System.out.println("********************************************");
							System.out.println();
							
							/*
							 * Get the check after calculation
							 */
							
							System.out.println("Do you want to take a look on the check? Enter Yes if you want to do it");
							String answer3 = in.next();
							if(answer3.equalsIgnoreCase("YES"))
							{
								in.nextLine();
								System.out.print("Please enter the payment in words Payment: ");
								System.out.printf("%.2f",calculation.netPay());
								System.out.println();
								String paymentString = in.nextLine();
								System.out.println("Enter the date");
								String date = in.nextLine();
								ProcessCheck check = new ProcessCheck(account.getEmployeeFirstName(),account.getEmployeeLastName(),calculation.netPay(),paymentString,date);
								check.printCheck();
								System.out.println();
								System.out.println();
								System.out.println("Hit 'Enter' to go back to the main menu.");
									
										}
							}
							else {System.out.println("Payroll calculation aborted.");
						System.out.println("Hit 'Enter' to back to the main menu.");}
						
					}
					in.nextLine();
					}
				else if (input.equals("Q"))
				{
					done = true;
				}
			}
			finally{
				fileReader.close();
			}
		}
	}
	
	
	/**
	 * Ask the user for a String. Repeat until successful.
	 * @param in Scanner for reading input
	 * @param prompt String to show to user
	 * @return value entered by user
	 */
	public static String promptForString(Scanner in, String prompt)
	{
		String result = " ";
		boolean done = false;
		while (!done)
		{
			System.out.print(prompt);
			String inputStr = in.nextLine().trim();
			try
			{
				result = inputStr;
				done = true;
			}
			catch (NumberFormatException e)
			{
				System.out.printf("Error: '%s' was not recognized as a double. Please try again.\n", inputStr);
			}
		}
		return result;
	}
}
