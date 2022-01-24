package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actime.pom.EnterTimeTrackPage;
import com.actime.pom.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	
	}

	public	static WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		Reporter.log("open Browser",true);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void login() throws Throwable {
		Reporter.log("login",true);

		FileLib f=new FileLib();
		String url = f.getProertyData("url");
		String un = f.getProertyData("username");
		String pw = f.getProertyData("password");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setLogin(un, pw);
	}

	@AfterMethod
	public void logout() {
		Reporter.log("logout",true);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.clickLogout();
	}

	@AfterTest
	public void closeBrowser() {
		Reporter.log("close Browser",true);
		driver.close();
	}
}
