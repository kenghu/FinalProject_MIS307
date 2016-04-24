/*
 * Author Keng Hu, Benjamin Turkett
 */
package TeamProject;

public class PayRollCalculation {
	private double emHourlyRate;
	private double emHour;
	private double healthCareRate = 0.0145;
	private double socialSecurityRate = 0.062;
	private String maritialStatus;
	private double stateRate = 0.0036;
	final double stateOne = 1539/52; //lowest state tax bracket
	final double stateTwo = 3078/52; //second state tax bracket
	final double stateThree = 6156/52;
	final double stateFour = 13851/52;
	final double stateFive = 23085/52;
	final double stateSix = 30780/52;
	final double stateSeven = 46170/52; //second highest state tax bracket
	final double stateEight = 69255/52; //highest state tax bracket
	
	/**
	 * initiate payroll calculation
	 * @param hourlyRate 
	 * @param hour
	 * @param federalRate_P
	 */
	public PayRollCalculation(double hourlyRate, double hour, String maritialStatus_P)
	{
		emHourlyRate = hourlyRate;
		emHour = hour;
		maritialStatus = maritialStatus_P;
	}
	/**
	 * 
	 * @return monthly gross pay
	 */
	public double GrossPay()
	{
		double gross = emHourlyRate * emHour;
		return gross;
		
	}
	/**
	 * 
	 * @return socialSecurity payment
	 */
	public double socialSecurityPay()
	{
		double pay = emHourlyRate*emHour*socialSecurityRate;
		return pay;
	}
	/**
	 * 
	 * @return medicare payment
	 */
	public double medicarePay()
	{
		double pay = emHourlyRate*emHour*healthCareRate;
		return pay;
	}
	/**
	 * 
	 * @return federal payment depends on the maritial status
	 */
	public double federalPay()
	{
		double gross = emHourlyRate * emHour *12;
		double rate = 0;
		if(maritialStatus.equalsIgnoreCase("Single"))
		{
			if(gross <= 9225 && gross> 0)
				rate =0.1;
			if(gross <= 37450 && gross > 9225)
				rate = 0.15;
			if(gross <= 90750 && gross > 37450)
				rate = 0.25;
			if(gross <= 189300&& gross > 90750)
				rate = 0.28;
			if(gross <= 411500 && gross > 189300)
				rate = 0.33;
			if(gross <=413200 && gross > 411500)
				rate = 0.35;
			if(gross>413200)
				rate = 0.396;
		}
		else if(maritialStatus.equalsIgnoreCase("Married"))
		{
			if(gross>= 1 && gross<= 18450)
				rate = 0.1;
			if(gross>= 18451 && gross<= 74900)
				rate = 0.15;
			if(gross>= 74901 && gross<= 151200)
				rate = 0.25;
			if(gross>= 151201 && gross<= 230450)
				rate = 0.28;
			if(gross>= 230451 && gross<= 411500)
				rate = 0.33;
			if(gross>= 411501&& gross<= 464850)
				rate = 0.35;
			if(gross> 464850)
				rate = 0.396;
		}
		double pay = emHourlyRate * emHour*rate;
		return pay;
	}
	/**
	 * 
	 * @return state payment in IOWA
	 */
	public double statePay()
	{
		double gross = emHourlyRate * emHour;
		double stateTax = 0;
		if(gross <= stateOne){
			stateTax = gross * stateRate;
		}
		else if (gross <= stateTwo)
		{
			double a = (stateOne * stateRate);
			stateRate = 0.0072;
			double b = (gross - stateOne) * stateRate;
			stateTax = a+b;
		}
		else if (gross <= stateThree){
			double a = (stateOne * stateRate);
			stateRate = 0.0072;
			double b = (stateTwo * stateRate);
			stateRate = 0.0243;
			double c = (gross-stateTwo) * stateRate;
			stateTax = a+b+c;
		}
		else if (gross <= stateFour){
			double a = (stateOne * stateRate);
			stateRate = 0.0072;
			double b = (stateTwo * stateRate);
			stateRate = 0.0243;
			double c = (stateThree * stateRate);
			stateRate = 0.045;
			double d = (gross - stateThree) * stateRate;
			stateTax = a+b+c+d;
		}
		else if (gross <= stateFive){
			double a = (stateOne * stateRate);
			stateRate = 0.0072;
			double b = (stateTwo * stateRate);
			stateRate = 0.0243;
			double c = (stateThree * stateRate);
			stateRate = 0.045;
			double d = (stateFour * stateRate);
			stateRate = 0.0612;
			double e = (gross-stateFour)*stateRate;
			stateTax =a+b+c+d+e;
		}
		else if (gross <= stateSix){
			double a = (stateOne * stateRate);
			stateRate = 0.0072;
			double b = (stateTwo * stateRate);
			stateRate = 0.0243;
			double c = (stateThree * stateRate);
			stateRate = 0.045;
			double d = (stateFour * stateRate);
			stateRate = 0.0612;
			double e = (stateFive * stateRate);
			stateRate = 0.0648;
			double f = (gross - stateFive)*stateRate;
			stateTax = a+b+c+d+e+f;
		}
		else if (gross <= stateSeven){
			double a = (stateOne * stateRate);
			stateRate = 0.0072;
			double b = (stateTwo * stateRate);
			stateRate = 0.0243;
			double c = (stateThree * stateRate);
			stateRate = 0.045;
			double d = (stateFour * stateRate);
			stateRate = 0.0612;
			double e = (stateFive * stateRate);
			stateRate = 0.0648;
			double f = (stateSix * stateRate);
			stateRate = 0.068;
			double g = (gross - stateSix)*stateRate;
			stateTax = a+b+c+d+e+f+g;
		}
		else if (gross <= stateEight){
			double a = (stateOne * stateRate);
			stateRate = 0.0072;
			double b = (stateTwo * stateRate);
			stateRate = 0.0243;
			double c = (stateThree * stateRate);
			stateRate = 0.045;
			double d = (stateFour * stateRate);
			stateRate = 0.0612;
			double e = (stateFive * stateRate);
			stateRate = 0.0648;
			double f = (stateSix * stateRate);
			stateRate = 0.068;
			double g = (stateSeven * stateRate);
			stateRate = 0.0792;
			double h = (gross-stateSeven)*stateRate;
			stateTax = a+b+c+d+e+f+g+h;
		}
		else {
			double a = (stateOne * stateRate);
			stateRate = 0.0072;
			double b = (stateTwo * stateRate);
			stateRate = 0.0243;
			double c = (stateThree * stateRate);
			stateRate = 0.045;
			double d = (stateFour * stateRate);
			stateRate = 0.0612;
			double e = (stateFive * stateRate);
			stateRate = 0.0648;
			double f = (stateSix * stateRate);
			stateRate = 0.068;
			double g = (stateSeven * stateRate);
			stateRate = 0.0792;
			double h = (stateEight*stateRate);
			stateRate = 0.0898;
			double i = (gross-stateEight)*stateRate;
			stateTax = a+b+c+d+e+f+g+h+i;
		}
		return stateTax;
	}
	/**
	 * 
	 * @return the amount this employee is going to get
	 */
	public double netPay()
	{
		double pay = emHourlyRate * emHour - socialSecurityPay()-medicarePay()-federalPay()-statePay();
		return pay;
	}
	/**
	 * type all the information out
	 */
	public String toString()
	{
		return " Hours worked: " + emHour +" Hourly rate: "+ emHourlyRate+" Gross pay: "+GrossPay()+" Net pay: "+netPay();
	}
	public void report(String name)
	{
		System.out.println("Employee Name: "+name);
		System.out.println(emHourlyRate * emHour);
		System.out.println("Social Security Payment: " + socialSecurityPay());
		System.out.println("Health care Payment: " + medicarePay());
		System.out.println("Federal Payment: " + federalPay());
		System.out.println("State Tax Payment: "+ statePay());
		System.out.println("Gross Payment: " + GrossPay());
		System.out.println("Net Payment: " +netPay());
	}

}
