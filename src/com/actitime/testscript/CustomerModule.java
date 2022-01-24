package com.actitime.testscript;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actime.pom.EnterTimeTrackPage;
import com.actime.pom.TaskListPage;
import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass{

	@Test
	public void testCreateCustomer() throws  Throwable {
		Reporter.log("CreateCustomer",true);
		FileLib f=new FileLib();
		String custName = f.getExcelData("CreateCustomer", 1, 2);
		String custDescrpt = f.getExcelData("CreateCustomer", 1, 3);
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.clickTaskTab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustomerOption().click();
		t.getEnterCustNameTbx().sendKeys(custName);
		t.getEnterCustDescTbx().sendKeys(custDescrpt);
		t.getSelectCustDD().click();
		t.getOurCompanyOption().click();
		t.getCreateCustomerBtn().click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustCreated(), custName));
		String actualCustText = t.getActualCustCreated().getText();
		Assert.assertEquals(actualCustText, custName);
	}

}
