package com.qa.opencart.tests;

import javax.security.auth.login.AppConfigurationEntry;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.constants.AppConstants;
import com.qa.pencart.base.BaseTest;

public class HomePageTest extends BaseTest {

	@Test
	public void homePageTitleTest() {
		String title = homePage.getHomePageTitle();
		Assert.assertEquals(title, AppConstants.HOMEPAGE_TITLE);
	}
	@Test
	public void homePageUrlTest() {
		String url = homePage.getHomePageURL();
		Assert.assertEquals(url, prop.getProperty("url"));
	}

	@Test(dataProvider = "getProductData")

	public void searchTest(String prod) {
		// String prod="Macbook";
		String heading = homePage.doSearch(prod);
		Assert.assertEquals(heading, "Search - " + prod);
	}

	@DataProvider
	public Object[][] getProductData() {
		Object data[][] = { { "MAC" }, { "iphone" }, { "ipad" } };
		return data;
	}

}
