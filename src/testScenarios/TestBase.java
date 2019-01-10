package testScenarios;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import utility.Constants;

public class TestBase {

	public static WebDriver driver;
	
	@BeforeSuite
	public void setSysProperties() {
		String OS = System.getProperty("os.name");
		if (OS.contains("Windows")) {
			System.out.println("Operating System: " + OS);
			System.setProperty("webdriver.gecko.driver",
					(System.getProperty("user.dir") + "//Drivers//geckodriver.exe"));
			System.setProperty("webdriver.chrome.driver",
					(System.getProperty("user.dir") + "//Drivers//chromedriver.exe"));
			}
	}
	@Parameters({ "browser" })
	@BeforeMethod
	public void setup(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setPreference("browser.tabs.remote.autostart", false);
			firefoxProfile.setPreference("browser.tabs.remote.autostart.1", false);
			firefoxProfile.setPreference("browser.tabs.remote.autostart.2", false);

			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setHeadless(false).setProfile(firefoxProfile);
			this.driver = new FirefoxDriver(firefoxOptions);
		}
		else {  
				this.driver = new ChromeDriver();
			 
		}
		driver.get(Constants.URL);
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void teardown() {
		this.driver.quit();
	}
}
