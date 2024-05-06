package com.Actitime.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.Actitime.pom.HomePage;
import com.Actitime.pom.LoginPage;

public class BaseClass {
public static	WebDriver driver;
	@BeforeTest
	public void openBrowser() {
	Reporter.log("openBrowser",true);	
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	}	
	@AfterTest
	public void closeBrowser() {
	Reporter.log("closeBrowser",true);
	driver.close();
	}	
	@BeforeMethod
	public void login() throws IOException {
	Reporter.log("login",true);
	FileLib f=new FileLib();
	String url = f.getPropertyData("url");
	String un = f.getPropertyData("username");
	String pw = f.getPropertyData("password");
	driver.get(url);
	LoginPage l=new LoginPage(driver);
	l.setLogin(un,pw);
	}	
	@AfterMethod
	public void logout() {
	Reporter.log("logout",true);
	HomePage h=new HomePage(driver);
	h.setLogout();
	}
}
