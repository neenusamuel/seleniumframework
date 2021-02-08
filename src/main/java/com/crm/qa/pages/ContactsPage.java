package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	public ContactsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	@FindBy(xpath = "//button[contains(text(),'New')]")
	WebElement newLabel;
//	@FindBy(xpath = "//div[@name= 'status']")
//	WebElement status;

	public void selectContactsName(String name) {
		driver.findElement(By.xpath("//td[contains(text(),'" + name + "')]")).click();
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public NewContactsPage clickOnNew() throws IOException {
		newLabel.click();
		return new NewContactsPage();
	}

//public void clickOnContactsName() throws InterruptedException {
////	Thread.sleep(2000);
//	contactName.click();
////	return contactName.isEnabled();
}
