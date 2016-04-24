/**
	Author: Xiaoxian Si && Keng Hu
	Implementation Date: 4-17-2016
	Description of Class: The class is main class of this payroll program.
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
		System.out.println("Welcome to the payroll system");
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
				System.out.println("A)dd Employee  D)elete Employee  S)earch Employee  Q)uit");
				String input = in.nextLine().toUpperCase();
				if (input.equals("A"))
				{
					int eSSN = promptForInt(in, "Enter new employee SSN: ");
					if (newAccounts.find(eSSN) != null)
					{
						System.out.printf("Error: account %d already exists.\n", eSSN);
					}
					else
					{
						System.out.println("Enter employee last name: ");
						String eLastName = in.nextLine();
						System.out.println("Enter employee first name: ");
						String eFirstName = in.nextLine();
						System.out.println("Enter employee address: ");
						String eAddress = in.nextLine();
						System.out.println("Enter employee martial status: ");
						String eMaritalStatus = in.nextLine();
						System.out.println("Enter employee hourly rate: ");
						double eHourlyRate = in.nextDouble();
						System.out.println("Enter employee hours: ");
						double eHours = in.nextDouble();
						employeeAccount newAccount = new employeeAccount(eLastName, eFirstName, eSSN, eAddress, eMaritalStatus, eHourlyRate, eHours);
						newAccounts.addAccount(newAccount);
						newAccounts.writeAccount(filename);
					}
				}
				else if (input.equals("D"))
				{
					int eSSN = promptForInt(in, "Enter employee SSN for delete: ");
					employeeAccount account = newAccounts.find(eSSN);
					if (account == null)
					{
						System.out.printf("Error: account %d does not exist.\n", eSSN);
					}
					else
					{
						System.out.println("Sure want to remove the employee below?");
						System.out.println(account.toString());
						System.out.println("Enter 'YES' to remove");
						String answer1 = in.nextLine();
						if (answer1.equalsIgnoreCase("YES")){
							newAccounts.removeAccount(account);
							System.out.println("Employee removed");
						}
					}
					newAccounts.writeAccount(filename);
				}
				else if (input.equals("S"))
				{
					int eSSN = promptForInt(in, "Enter employee SSN for search: ");
					employeeAccount account = newAccounts.find(eSSN);
					if (account == null)
					{
						System.out.printf("Error: account %d does not exist.\n", eSSN);
					}
					else
					{
						System.out.println("Found Employee");
						System.out.println();
						System.out.println(account.toString());
						System.out.println();
						System.out.println("Enter 'YES' to start payroll calculation");
						String answer2 = in.nextLine();
						if (answer2.equalsIgnoreCase("YES")){
							System.out.println("Enter employee hourly rate: ");
							double hourlyRate = in.nextDouble();
							System.out.println("Enter employee worked hours: ");
							double hourWorked = in.nextDouble();
							System.out.println("Enter employee healthcare rate: ");
							double healthRate = in.nextDouble();
							System.out.println("Enter State rate: ");
							double stateRate = in.nextDouble();
							System.out.println("Enter employee marital status (Single/Married): ");
							String maritalAnswer = in.next();
							
							if (maritalAnswer.equalsIgnoreCase("Single")){
								
								
							}
							else if (maritalAnswer.equalsIgnoreCase("Married")){
								
							}
							
						}
						//calculation part from here
					}
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
	
	
	public static int promptForInt(Scanner in, String prompt)
	{
		int result = 0;
		boolean done = false;
		while (!done)
		{
			System.out.print(prompt);
			String inputStr = in.nextLine().trim();
			try
			{
				result = Integer.parseInt(inputStr);
				done = true;
			}
			catch (NumberFormatException e)
			{
				System.out.printf("Error: '%s' was not recognized as an integer. Please try again.\n", inputStr);
			}
		}
		return result;
	}

	
	/**
	 * Ask the user for a double precision number. Repeat until successful.
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
