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
		double pay = emHourlyRate*emHour*socialSecurityRate;
		return pay;
	}
	public double medicarePay()
	{
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
		double pay = emHourlyRate*emHour*stateRate;
		return pay;
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
