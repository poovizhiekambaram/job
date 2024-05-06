package com.Actitime.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Actitime.generic.BaseClass;
import com.Actitime.generic.FileLib;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskListPage;

@Listeners(com.Actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass{

	@Test
public void testCreateCustomer() throws InterruptedException,EncryptedDocumentException, IOException, InvalidFormatException  {
	Reporter.log("CreateCustomer",true);
	FileLib f=new FileLib();
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
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
wait.until(ExpectedConditions.textToBePresentInElement(t.getVerifyCustomerName(),customerName));
String actualCustomer = t.getVerifyCustomerName().getText();
Assert.assertEquals(actualCustomer, customerName);
	}	
}
