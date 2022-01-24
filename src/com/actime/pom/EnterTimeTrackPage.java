package com.actime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BaseClass;

public class EnterTimeTrackPage extends BaseClass {
	@FindBy(id="logoutLink")
	private WebElement lgout;

	@FindBy(xpath="//div[text()='Tasks']")
	private WebElement taskTab;

	public EnterTimeTrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickLogout(){
		lgout.click();
	}
	public void clickTaskTab() {
		taskTab.click();
	}
}
