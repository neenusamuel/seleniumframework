package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "email")
	WebElement unm;

	@FindBy(name = "password")
	WebElement pwd;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginButton;

	@FindBy(xpath = "//div[@id='ui']/div//a[@href='https://api.cogmento.com/register']")
	WebElement signUpButton;

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pd) throws IOException {
		unm.sendKeys(un);
		pwd.sendKeys(pd);
		loginButton.click();
		return new HomePage();
	}
	public SignUpPage clickOnSignUpLink() throws IOException {
		signUpButton.click();
		return new SignUpPage();
	}
}
