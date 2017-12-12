package pkgCore;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Retirement {

	private int iYearsToWork;
	private double dAnnualReturnWorking;
	private int iYearsRetired;
	private double dAnnualReturnRetired;
	private double dRequiredIncome;
	private double dMonthlySSI;
	
	/**
	 * @param iYearsToWork
	 * @param dAnnualReturnWorking
	 * @param iYearsRetired
	 * @param dAnnualReturnRetired
	 * @param dRequiredIncome
	 * @param dMonthlySSI
	 */
	public Retirement(int iYearsToWork, double dAnnualReturnWorking, int iYearsRetired, double dAnnualReturnRetired,
			double dRequiredIncome, double dMonthlySSI) {
		this.iYearsToWork = iYearsToWork;
		this.dAnnualReturnWorking = dAnnualReturnWorking;
		this.iYearsRetired = iYearsRetired;
		this.dAnnualReturnRetired = dAnnualReturnRetired;
		this.dRequiredIncome = dRequiredIncome;
		this.dMonthlySSI = dMonthlySSI;
	}
	
	/**
	 * @return the iYearsToWork
	 */
	public int getiYearsToWork() {
		return iYearsToWork;
	}

	/**
	 * @param iYearsToWork the iYearsToWork to set
	 */
	public void setiYearsToWork(int iYearsToWork) {
		this.iYearsToWork = iYearsToWork;
	}

	/**
	 * @return the dAnnualReturnWorking
	 */
	public double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}

	/**
	 * @param dAnnualReturnWorking the dAnnualReturnWorking to set
	 */
	public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
		this.dAnnualReturnWorking = dAnnualReturnWorking;
	}

	/**
	 * @return the iYearsRetired
	 */
	public int getiYearsRetired() {
		return iYearsRetired;
	}

	/**
	 * @param iYearsRetired the iYearsRetired to set
	 */
	public void setiYearsRetired(int iYearsRetired) {
		this.iYearsRetired = iYearsRetired;
	}

	/**
	 * @return the dAnnualReturnRetired
	 */
	public double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}

	/**
	 * @param dAnnualReturnRetired the dAnnualReturnRetired to set
	 */
	public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
		this.dAnnualReturnRetired = dAnnualReturnRetired;
	}

	/**
	 * @return the dRequiredIncome
	 */
	public double getdRequiredIncome() {
		return dRequiredIncome;
	}

	/**
	 * @param dRequiredIncome the dRequiredIncome to set
	 */
	public void setdRequiredIncome(double dRequiredIncome) {
		this.dRequiredIncome = dRequiredIncome;
	}

	/**
	 * @return the dMonthlySSI
	 */
	public double getdMonthlySSI() {
		return dMonthlySSI;
	}

	/**
	 * @param dMonthlySSI the dMonthlySSI to set
	 */
	public void setdMonthlySSI(double dMonthlySSI) {
		this.dMonthlySSI = dMonthlySSI;
	}

	public double AmountToSave()
	{
		//Determine the amount to save each month based on TotalAmountSaved, YearsToWork
		//		and Annual return while working
		
		double dMonthsToWork = this.iYearsToWork * 12;
		double rAnnualReturnWorking = this.dAnnualReturnWorking / 12;
		double pmt = FinanceLib.pmt(rAnnualReturnWorking, dMonthsToWork, 0, TotalAmountSaved(), false);	
		return pmt;
	}
	
	public double TotalAmountSaved()
	{
		//	Determine amount to be saved based on Monthly SSI, Required Income, Annual return during retirement
		//		and number of years retired.
		//
		double dMonthsRetired = this.iYearsRetired * 12;
		double rAnnaulReturnRetired =this.dAnnualReturnRetired / 12;
		double dRequiredIncome = this.dRequiredIncome;
		double dMonthlySSI = this.dMonthlySSI;
        double pv = FinanceLib.pv(rAnnaulReturnRetired, dMonthsRetired, dRequiredIncome - dMonthlySSI, 0, false);
        return pv;
	}
}
