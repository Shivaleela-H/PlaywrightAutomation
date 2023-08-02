package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	Playwright playwright;
	Browser browser;
	Page page;
	Properties prop;

	public Page initBrowser(Properties prop) {
		String browserName = prop.getProperty("browser").trim();
		String url = prop.getProperty("url").trim();
		System.out.println("Browser Name is : " + browserName);

		playwright = Playwright.create();
		switch (browserName.toLowerCase()) {
		case "chromium":
			browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "firefox":
			browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "chrome":
			browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			break;
		default:
			System.out.println("Pass correct Browser Name...");
			break;
		}

		BrowserContext bc = browser.newContext();
		page = bc.newPage();
		page.navigate(url);

		return page;

	}

	// Used to initialize the properties from config file
	public Properties init_prop() {
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return prop;
	}

}
