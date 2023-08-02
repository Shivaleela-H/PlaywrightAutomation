package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	Page page;
	// 1 Locators
	private String email = "//input[@name='email']";
	private String password = "//input[@name='password']";
	private String logoutLink = "//div[@class='list-group']//a[text()='Logout']";
	private String loginButton = "//*[@value='Login']";

	// 2 Constructor
	public LoginPage(Page page) {
		this.page = page;
	}

	public String getLoginPageTitle() {
		String title = page.title();
		System.out.println("Title : " + title);
		return title;

	}

	public void doSearch(String emailStr, String passwordStr) {

		page.fill(email, emailStr);
		page.fill(password, passwordStr);
		page.click(loginButton);

	}

	public boolean verifyLogin() {

		return page.isVisible(logoutLink);

	}
}
