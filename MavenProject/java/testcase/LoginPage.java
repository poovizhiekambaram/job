package testcase;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPage {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.get("http://localhost/login.do");
		driver.close();
	}

}
