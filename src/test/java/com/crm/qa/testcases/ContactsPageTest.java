package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public ContactsPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();

	}

	@Test(priority = 1)
	public void contactsLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}

	@Test(priority = 2)
	public void singleContactsNameTest() throws IOException, InterruptedException {
		contactsPage = homePage.clickOnContactsLink();
		Thread.sleep(10000);
		contactsPage.selectContactsName("a k");
	}

	@Test(priority = 3)
	public void multipleContactsNameTest() throws IOException, InterruptedException {
		contactsPage = homePage.clickOnContactsLink();
		Thread.sleep(10000);
		contactsPage.selectContactsName("neenu samuel");
		contactsPage.selectContactsName("n s");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
