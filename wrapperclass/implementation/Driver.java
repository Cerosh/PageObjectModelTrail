package com.wrapperclass.implementation;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver implements WebDriver {

	private WebDriver driver;
	private final String browserName;
	

	public Driver(String browserName) {
		this.browserName = browserName;
		this.driver = createDriver(browserName);
	}

	private WebDriver createDriver(String browserName) {
		WebDriver drv;
		switch (browserName.toUpperCase()) {
		case "FIREFOX":
			drv = new FirefoxDriver();
			break;
		case "CHROME":
			drv = new ChromeDriver();
			break;
		default:
			throw new IllegalArgumentException("invalid browser name");
		}
		return drv;
	}

	public WebDriver wrappedDriver() {
		return this.driver;
	}

	@Override
	public void close() {
		driver.close();
	}

	@Override
	public WebElement findElement(By locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
		return element;
	}

	@Override
	public void get(String url) {
		driver.get(url);
		
	}

	@Override
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

	@Override
	public String getTitle() {
		
		return driver.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPageSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void quit() {
		driver.quit();
		
	}

	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return null;
	}
}
