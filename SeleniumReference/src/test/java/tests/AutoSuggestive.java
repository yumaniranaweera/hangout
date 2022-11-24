package tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/Yumani/Installers/seleniumDrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		
		//Get the auto suggesting list of words to a list. Traverse through the list using s 'for loop' and select it when your string matches.
		//We have taken the xpath of the auto-suggestive list
		List <WebElement> options =  driver.findElements(By.xpath("//li[@class=\"ui-menu-item\"] /a"));
		for(WebElement option : options) 
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
			
		}
		
		driver.close();
	}

}
