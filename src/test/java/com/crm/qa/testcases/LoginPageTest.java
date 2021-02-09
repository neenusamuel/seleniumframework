package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;



import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;
// adding comments in repository to check git pull functinality
public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	SignUpPage signUpPage;

	public LoginPageTest() throws IOException {
		super();
	}

	
	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1,description="hi")
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}

	@Test(priority = 2)
	public void loginTest() {
		try {
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void clickOnSignUpPageLinkTest(){
		try {
			signUpPage = loginPage.clickOnSignUpLink();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
