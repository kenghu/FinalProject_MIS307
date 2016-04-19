package FinalProjectMIS307;

public class PayRollCalculation {
	private String name;
	private double emHourlyRate;
	private double emHour;
	private double healthCareRate;
	private double taxRate;
	private double socialSecurityRate;
	private double federalRate;
	private double stateRate;
	final double stateOne = 1539/52; //lowest state tax bracket
	final double stateTwo = 3078/52; //second state tax bracket
	final double stateThree = 6156/52;
	final double stateFour = 13851/52;
	final double stateFive = 23085/52;
	final double stateSix = 30780/52;
	final double stateSeven = 46170/52; //second highest state tax bracket
	final double stateEight = 69255/52; //highest state tax bracket
	
	
	public PayRollCalculation(String name_P, double hourlyRate, double hour, double healthCare_P, double taxRate_P,double socialSecurityRate_P, double federalRate_P,double stateRate_P)
	{
		name = name_P;
		emHourlyRate = hourlyRate;
		emHour = hour;
		healthCareRate = healthCare_P;
		taxRate = taxRate_P;
		socialSecurityRate = socialSecurityRate_P;
		stateRate = stateRate_P;
	}
	public double GrossPay()
	{
		double gross = emHourlyRate * emHour;
		return gross;
		
	}
	public double socialSecurityPay()
	{
		socialSecurityRate = 0.062;
		double pay = emHourlyRate*emHour*socialSecurityRate;
		return pay;
	}
	public double medicarePay()
	{
		dealthCareRate = 0.0145;
		double pay = emHourlyRate*emHour*healthCareRate;
		return pay;
	}
	public double federalPay()
	{
		double pay = emHourlyRate*emHour*federalRate;
		return pay;
	}
	public double statePay()
	{
		double gross = emHourlyRate * emHour;
		stateRate = 0.0036;
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
	public double netPay()
	{
		double pay = emHourlyRate * emHour*(1-stateRate-federalRate-healthCareRate-socialSecurityRate);
		return pay;
	}
	public String toString()
	{
		return "Name: " +name + " Hours worked: " + emHour +" Hourly rate: "+ emHourlyRate+" Gross pay: "+GrossPay()+" Net pay: "+netPay();
	}

}
