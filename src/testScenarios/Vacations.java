package testScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.PageElements;

public class Vacations extends TestBase{
  @Test
  public void Test001() {
	 new PageElements(driver).clickonVacationsLink();
	 new PageElements(driver).selectAllTabs();
	 new PageElements(driver).enterTextInFlyFrom("SFO");
	 new PageElements(driver).selectDropDownOption();
	 new PageElements(driver).enterTextInFlyTo("LAX");
	 new PageElements(driver).selectDropDownOption();
	 new PageElements(driver). selectDepartingDate();
	 new PageElements(driver).selectDepartingTime("Evening");
	 new PageElements(driver). selectReturningDate();
	 new PageElements(driver).selectReturningTime("Morning");
	 new PageElements(driver).clickonfindADeal();
	 int noResultFound=new PageElements(driver). getNoOfHotelsSearched();
	 Assert.assertFalse(noResultFound<0,"No result found for the hotel search");
	 
	
  }
}
