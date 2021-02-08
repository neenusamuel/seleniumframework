package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "user-display")
	WebElement displayedName;

	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath = "//span[text()='Deals']")
	WebElement dealsLink;

	@FindBy(xpath = "//span[text()='Tasks']")
	WebElement tasksLink;

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContactsLink() throws IOException {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() throws IOException {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}

	public boolean verifyDisplayedName() {
		return displayedName.isDisplayed();

	}

}
