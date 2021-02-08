package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.util.TestUtil;

public class NewContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	NewContactsPage newContactsPage;

	public NewContactsPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
		newContactsPage = contactsPage.clickOnNew();
	}
@DataProvider
public Object[][] getCrmTestData(){
	Object data[][] = TestUtil.getTestData("contacts");
	return data;
}


	@Test(priority = 1, dataProvider = "getCrmTestData")
	public void newContactCreationTest(String firstName, String lastName, String company) throws InterruptedException {
		newContactsPage.createNewContact(firstName,lastName, company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
