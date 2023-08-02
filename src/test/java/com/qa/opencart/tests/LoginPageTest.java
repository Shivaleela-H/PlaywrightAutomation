package com.qa.opencart.tests;

import javax.security.auth.login.AppConfigurationEntry;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.constants.AppConstants;
import com.qa.pencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test(priority=1)
	public void loginPageTitleTest() {
		loginPage=homePage.navigateToLoginPage();
		String title = loginPage.getLoginPageTitle();
		Assert.assertEquals(title, AppConstants.LOGINPAGE_TITLE);
	}
	
	@Test(priority=2)
	public void doLogin() {
		String email = prop.getProperty("username");
		String pwd=prop.getProperty("password");
		loginPage.doSearch(email, pwd);
		Assert.assertEquals(loginPage.verifyLogin(), true);
		
	}

}
