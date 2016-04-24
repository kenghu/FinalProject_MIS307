/**
	Author: Xiaoxian Si
	Implementation Date: 4-17-2016
	Description of Class: The purpose of this class is to create a employeeAccount
 */



package TeamProject;

public class employeeAccount {
	private String empLastName;
	private String empFirstName;
	private String empSSN;
	private String address;
	private String maritalStatus;
	private double empHourlyRate;
	private double empHour = 0;
	
	/**
	 * Constructs an employeeAccount with empName, healthcare type, empNumber, basic monthly salary, current balance, empSale, empHourlyRate and employee worked hours.
	 */
	public employeeAccount(String _empLastName, String _empFirstName, String _empSSN, String _address, String _maritalStatus, double _empHourlyRate){  
	      empLastName = _empLastName;
	      empFirstName = _empFirstName;
	      empSSN = _empSSN;
	      address = _address;
	      maritalStatus = _maritalStatus;
	      empHourlyRate = _empHourlyRate;
	}
	public void addHour(double a )
	{
		empHour= empHour +a ;
		System.out.println("Hours have been added, the total employee hour for this employee is " + empHour);
	}
	
	/**
	 * Get the employee last name
	 * @return the last name of the employee
	 */
	public String getEmployeeLastName(){
		return empLastName;
	}
	
	/**
	 * Get the employee First name
	 * @return the first name of the employee
	 */
	public String getEmployeeFirstName(){
		return empFirstName;
	}
	
	/**
	 * Get the employee's SSN
	 * @return the SSN of employee
	 */
	public String getEmployeeSSN(){
		return empSSN;
	}
	
	/**
	 * Get the employee's address
	 * @return the address of employee
	 */
	public String getEmployeeAddress(){
		return address;
	}
	
	/**
	 * Get the employee's monthly sale amount
	 * @return the sale amount of the employee
	 */
	public String getMaritalStatus(){
		return maritalStatus;
	}
	
	/**
	 * Get the employee's hourly rate
	 * @return the hourly rate of the employee
	 */
	public double getEmployeeHourlyRate(){
		return empHourlyRate;
	}
	
	/**
	 * Get the employee worked hour
	 * @return the worked hour 
	 */
	public double getEmployeeHour(){
		return empHour;
	}
	
	/**
	 * Change employee last name
	 * @param _empLastName
	 * @return the changed employee last name
	 */
	public String employeeLastNameChange(String _empLastName){
		empLastName = _empLastName;
		return empLastName;
	}
	
	/**
	 * Change employee first name
	 * @param _empFirstName
	 * @return the changed employee first name
	 */
	public String employeeFirstNameChange(String _empFirstName){
		empFirstName = _empFirstName;
		return empFirstName;
	}
	
	/**
	 * Change employee worked hours
	 * @param _empHour
	 * @return Changed worked hours
	 */
	public double employeeHourChange(double _empHour){
		empHour = _empHour;
		return empHour;
	}
	
	/**
	 * Describe the employeeAccount
	 */
	public String toString()
	   {
		   return "Employee Name(LastFirst): " + empLastName +" " + empFirstName + " Employee SSN: " + empSSN + " Address: " + address + " Marital Status: " + maritalStatus + " Employee Hourly Rate: " + empHourlyRate + " Employee cumulative Worked Hours: " + empHour;
	   }
}
