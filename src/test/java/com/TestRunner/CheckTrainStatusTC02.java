package com.TestRunner;

import java.util.Base64;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.checkingTrainStatus;
import com.base.BaseClass;
import com.utilities.ConstantVariables;

public class CheckTrainStatusTC02 extends BaseClass {
	
	@BeforeTest
	public void startTest() {
		ExtentReport();
	}
	
	@Test
	public void CheranTrainStatus() {
		checkingTrainStatus train = new checkingTrainStatus();
		train.enterTrainName(ConstantVariables.nameofthetrain);
		train.trainoptions();
		train.searchTrain();
		train.SelectDate();
		train.clickStatusButton();
		train.selectcoimbatoreJN();
	}

}
