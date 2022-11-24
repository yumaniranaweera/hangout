package tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShoppingCartOneItem {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(2000);
		
		List<WebElement> products= driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		for (int i=0;i<products.size();i++)
		{
			String productName = products.get(i).getText();
			/*String formattedName = productName[0].trim();*/
			
			if (productName.contains("Cucumber")) 
				{
				//If name contains cucumber add to cart
				driver.findElements(By.xpath("//button[@type=\"button\"]")).get(i).click();
				break;
			}
		}

	}
}
