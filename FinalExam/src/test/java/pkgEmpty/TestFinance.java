package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

import org.apache.poi.ss.formula.functions.*;
public class TestFinance {

	double PV = -1454485.5484009797;
	double PMT = 554.1291237405718;
	
	@Test 
	public void TestAmounts()
	{
		double dMonthsToWork = 40 * 12;
		double rAnnualReturnWorking = 0.07 / 12;
		double dMonthsRetired = 20 * 12;
		double rAnnaulReturnRetired = 0.02 / 12;
		double dRequiredIncome = 10000;
		double dMonthlySSI = 2642;
		double pv = FinanceLib.pv(rAnnaulReturnRetired, dMonthsRetired, dRequiredIncome - dMonthlySSI, 0, false);
		
		double pmt = FinanceLib.pmt(rAnnualReturnWorking, dMonthsToWork, 0, pv, false);
		
		System.out.println(pv);
		System.out.println(pmt);
		
		assertEquals(pv, PV, 0.001);
		assertEquals(pmt, PMT, 0.001);
	}
	
	
	@Test
	public void TestPV()
	{
		double r = 0.025 / 12;
		double n = 20 * 12;
		double y = 10000-2642;
		double f = 0;
		boolean t = false;
		double pv = FinanceLib.pv(r, n, y, f, t);
		
		//System.out.println(pv);
		
	}
	
	
	@Test
	public void TestPMT() {
		double r = 0.042 / 12;
		double n = 60;
		double p = 30000;
		double f = 0;
		boolean t = false;
		
		double d = FinanceLib.pmt(r, n, p, f, t);
		
		//System.out.println(d);
		
		
		
	}
	
	@Test
	public void TestRetirement() {
		Retirement r = new Retirement(40, 0.07, 20, 0.02, 10000.00, 2642.00);
		assertEquals(r.TotalAmountSaved(), PV, 0.001);
		assertEquals(r.AmountToSave(), PMT, 0.001);
	}

}
