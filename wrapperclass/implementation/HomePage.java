package com.wrapperclass.implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

	protected final String URL = "http://www.vpl.ca";
	private final String TITLE = "Vancouver Public Library";
	private final By SEARCH_BOX_LOCATOR = By.id("edit-search");
	private final By SEARCH_BUTTON_LOCATOR = By.id("edit-submit");
	private final Driver driver;

	public HomePage(Driver driver) {
		this.driver = driver;
	}

	public void open() {
		this.driver.get(URL);
		String pageTitle = this.driver.getTitle().toLowerCase();
		if (pageTitle.contains(TITLE.toLowerCase()) == false)
			throw new RuntimeException("Home Page is not displayed!");
	}

	public ResultsPage searchFor(String keyword) {
		WebElement searchBox = driver.findElement(SEARCH_BOX_LOCATOR);
		searchBox.click();
		searchBox.sendKeys(keyword);
		WebElement searchButton = driver.findElement(SEARCH_BUTTON_LOCATOR);
		searchButton.click();
		return new ResultsPage(this.driver);
	}

}
