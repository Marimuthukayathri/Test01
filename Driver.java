package application;
import org.testng.annotations.Test;

import frameworkCore.*;
public class Driver {
	@Test
	public void initiateTestExecution() throws Throwable {
		InitiateExecution objExecute = new InitiateExecution();
		objExecute.executeBusinessFlow();
	}
}