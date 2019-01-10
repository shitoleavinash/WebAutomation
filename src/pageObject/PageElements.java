package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

import utility.DateUtility;

public class PageElements extends PageObjectBase {
	public int TimeoutValue = 10;

	public PageElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TimeoutValue), this);
	}

	// Vacations Link
	@FindBy(how = How.XPATH, using = "//*[@class='nav nav-pills']/li[4]/a")
	private WebElement VacationsLink;

	// Vacations tabs
	@FindBy(how = How.XPATH, using = "//*[@class='hw-btn-check-group hw-default-margin-top']/button")
	private List<WebElement> VacationsTabs;

	// Fly from
	@FindBy(how = How.ID, using = "farefinder-package-origin-location-input")
	private WebElement flyFrom;

	// Fly to
	@FindBy(how = How.ID, using = "farefinder-package-destination-location-input")
	private WebElement flyTo;

	// Departing Date
	@FindBy(how = How.ID, using = "farefinder-package-startdate-input")
	private WebElement departingDate;
	
	//Returning
	@FindBy(how = How.ID, using = "farefinder-package-enddate-input")
	private WebElement returningDate;
	
	//dropdown-menu
	@FindBy(how = How.XPATH, using = "//li[@class='uib-typeahead-match active']")
	private WebElement dropdownMenu;
	
	@FindBy(how = How.ID, using = "farefinder-package-pickuptime-input")
	private WebElement pickUpTime;
	
	@FindBy(how = How.ID, using = "farefinder-package-dropofftime-input")
	private WebElement dropOffTime;
	
	//Find a deal
	@FindBy(how = How.ID, using = "farefinder-package-search-button")
	private WebElement findADeal;
		
	//hotelResultTitle
	@FindBy(how = How.ID, using = "hotelResultTitle")
	private WebElement hotelResultTitle;
	
	//resultsContainer
	@FindBy(how = How.ID, using = "resultsContainer")
	private WebElement resultsContainer;
	
	// hotelsSearch
	@FindBy(how = How.XPATH, using = "//*[@id='resultsContainer']/section/article")
	private List<WebElement> hotelsSearch;
	
		
	public int getNoOfHotelsSearched() {
		waitForElementToBeVisible(hotelResultTitle, 30);
		waitForElementToBeVisible(resultsContainer, 30);
		if(exists(waitForElementToBeVisible(hotelsSearch.get(0), 30))) {
			return hotelsSearch.size();
		}
		return 0;
	}
	
	public void clickonVacationsLink() {
		waitForElementToBeClickable(VacationsLink,10).click();
	}
	
	public void selectAllTabs() {
		
		for (WebElement webElement : VacationsTabs) {
			waitForElementToBeClickable(webElement,10).click();
		} 
		
	}
	public void enterTextInFlyFrom(String text) {
		waitForElementToBeVisible(flyFrom,10).sendKeys(text);
	}
	
	public void enterTextInFlyTo(String text) {
		waitForElementToBeVisible(flyTo,10).sendKeys(text);
	}
	
	public void selectDropDownOption() {
		waitForElementToBeVisible(dropdownMenu,10);
		waitForElementToBeClickable(dropdownMenu,10).click();
	}
		
	
	public void selectDepartingDate() {
		String date=DateUtility.getDate("MM/dd/yyyy", 1);
		WebElement element=waitForElementToBeVisible(departingDate,10);
		element.clear();
		element.sendKeys(date);
	}
	public void selectReturningDate() {
		String date=DateUtility.getDate("MM/dd/yyyy", 21);
		WebElement element=waitForElementToBeVisible(returningDate,10);
		element.clear();
		element.sendKeys(date);
	}
	
	public void selectDepartingTime(String text) {
		Select select = new Select(waitForElementToBeVisible(pickUpTime, 10));
		select.selectByVisibleText(text);
	}
	public void selectReturningTime(String text) {
		Select select = new Select(waitForElementToBeVisible(dropOffTime, 10));
		select.selectByVisibleText(text);
	}
	
	public void clickonfindADeal() {
		waitForElementToBeClickable(findADeal,10).click();
	}
	
}
