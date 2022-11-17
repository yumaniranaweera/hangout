package tests;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;

public class GoogleSearchPageTest {

	public static void main(String[] args) {
		GoogleSearchTest();
	}

	public static void GoogleSearchTest() {
		//WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		GoogleSearchPage searchObj = new GoogleSearchPage(driver);
		driver.get("https://google.com");
		//driver.find_element(By.id("L2AGLb").click();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		searchObj.setTextForSearch("ABC");
		//searchObj.clickSearchButton();
		
		if(driver!=null)
			driver.close();
			driver.quit();
	}
}
