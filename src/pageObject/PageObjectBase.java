package pageObject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObjectBase {
	public static WebDriver driver;

	public PageObjectBase(WebDriver driver) {
		PageObjectBase.driver = driver;
	}
	

	public WebElement waitForElementToBeVisible(WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		return element = wait.until(ExpectedConditions.visibilityOf(element));
	}
	

	public boolean exists(WebElement element){
		try{
			return element.isDisplayed();
		}catch (NoSuchElementException e){
			return false;
		}
	}

	public WebElement waitForElementToBeClickable(WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		return	element = wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
}