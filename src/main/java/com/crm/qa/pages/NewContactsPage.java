package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class NewContactsPage extends TestBase {

	public NewContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='first_name']")
	WebElement firstName;
	@FindBy(xpath = "//input[@name = 'last_name']")
	WebElement lastName;
	@FindBy(xpath = "//input[@type = 'text']")
	WebElement comapanyName;
	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement saveButton;

	public void createNewContact(String ftName, String ltName, String compName) throws InterruptedException {
		Thread.sleep(5000);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		comapanyName.sendKeys(compName);
		saveButton.click();
	}
}
