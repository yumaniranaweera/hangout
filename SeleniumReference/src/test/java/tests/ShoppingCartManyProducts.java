package tests;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShoppingCartManyProducts {

	public static void main(String[] args) throws InterruptedException {

			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/seleniumPractise/");
			Thread.sleep(2000);
			
			String[] productList = {"Cucumber", "Carrot", "Brocolli"};
			int j;
			
			List<WebElement> products= driver.findElements(By.xpath("//h4[@class='product-name']"));
			
			
			for (int i=0;i<products.size();i++)
				
			{
				String[] productName = products.get(i).getText().split("-");
				String formattedName = productName[0].trim();
				
				//Check whether the name you extracted is present in array-productList
				//To do this easily, check convert the array to Array List
				List neededList = Arrays.asList(productList);
				
				j =0;
				if (neededList.contains(formattedName))
					{
					//If name contains cucumber add to cart
					//driver.findElements(By.xpath("//button[@type=\"button\"]")).get(i).click();
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					
					
					j++;
					if (j == productList.length) // notes: we use 'size' for arralyLists
					{
						break;
				   }
			}

		}
	}


	}
