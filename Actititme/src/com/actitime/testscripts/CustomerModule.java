package com.actitime.testscripts;

import java.io.IOException;

import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.Baseclass;
import com.actitime.generic.Filelib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.Listenerimplementation.class)
public class CustomerModule extends Baseclass{

	@Test
public void testCreateCustomer() throws InterruptedException,EncryptedDocumentException, IOException  {
	Reporter.log("CreateCustomer",true);
	Filelib f=new Filelib();
	String customerName = f.getExcelData("CreateCustomer", 1, 3);
	String customerDescription = f.getExcelData("CreateCustomer", 1, 4);
	HomePage h=new HomePage(driver);
	h.setTaskTab();
	TaskListPage t=new TaskListPage(driver);
	t.getAddNewBtn().click();
	t.getNewCustomerOption().click();
	t.getEnterCustomerNameTbx().sendKeys(customerName);
	t.getCustomerDescriptionTbx().sendKeys(customerDescription);
	t.getSelectDD().click();
	t.getOurCompanyOption().click();
	t.getCreateCustomerBtn().click();
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.textToBePresentInElement(t.getVerifyCustomerName(),customerName));
String actualCustomer = t.getVerifyCustomerName().getText();
Assert.assertEquals(actualCustomer, customerName);
	}	
}
