package com.wrapperclass.implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResultsPage {

	private final By ITEMS_COUNT_LOCATOR =
			By.xpath("//span[@class='items_showing_count']");

	private final By RESULT_TITLE_LOCATOR = By.xpath("//a[@testid = 'bib_link']");
	private final String URL = "vpl.bibliocommons.com";
	private final Driver driver;

	public ResultsPage(Driver d) {
		this.driver = d;
		if (this.driver.getCurrentUrl().contains(URL) == false)
			throw new RuntimeException("Results page is not displayed!");

	}

	public String itemsCountText() {
		WebElement itemsCount = driver.findElement(ITEMS_COUNT_LOCATOR);
		return itemsCount.getText();
	}

	public String titleText() {
		WebElement resultTitle = driver.findElement(RESULT_TITLE_LOCATOR);
		return resultTitle.getText();
	}

}
