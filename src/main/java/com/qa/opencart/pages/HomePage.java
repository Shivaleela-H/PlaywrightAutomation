package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {
	Page page;
	// 1 Locators
	private String searchBox = "//input[@name='search']";
	private String searchButton = "//button[@class='btn btn-default btn-lg']";
	private String searchHeading = "//div[@id='content']/h1";
	private String myAcctLink="//a[@title='My Account']";
	private String loginLink="//a[text()='Login']";

	// 2 Constructor
	public HomePage(Page page) {
		this.page = page;
	}

	// 3 action methods

	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("Title : " + title);
		return title;

	}

	public String getHomePageURL() {
		String url = page.url();
		System.out.println("URL : " + url);
		return url;

	}

	public String doSearch(String productName) {

		page.fill(searchBox, productName);
		page.click(searchButton);
		String heading = page.textContent(searchHeading);
		return heading;
	}
	public LoginPage navigateToLoginPage() {

		
		page.click(myAcctLink);
		page.click(loginLink);
		return new LoginPage(page);
	}
	

}
