package tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllLinks {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String nextTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		
		/* Count of all the links within the page */
		int count = driver.findElements(By.tagName("a")).size();
		System.out.println("all links :" +count);
		
		/* Count of all the links within the footer section */
		// reduce the scope of the driver to footer section and find the links
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		int footercount = footerdriver.findElements(By.tagName("a")).size();
		System.out.println("footer links :" +footercount);
		
		/* Test the links in the footer column1 are working */
		//This is a dynamic test where you get the number of available links and loop though them by clicking each
		//Not only that you open each link in a seperate browser tab.
		//Get the title of each tab
		
		//create a driver scope to the footer column and get the total number of links
		WebElement columnDriver= footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int columnLinkCount = columnDriver.findElements(By.tagName("a")).size();
		System.out.println("footer column links :" +columnLinkCount);
		
		//Iterate through links where max count is ccolumnLinkCount
		for(int j=1;j<columnLinkCount;j++) {
			columnDriver.findElements(By.tagName("a")).get(j).sendKeys(nextTab);
			Thread.sleep(5000L);
		}
		
		//Get all the windows to the iterator
			Set<String> winHandles = driver.getWindowHandles();
			Iterator<String> ite = winHandles.iterator();
	
		
		//Iterate through each tab and get the title
			int a=1;
			while (ite.hasNext()) {
				driver.switchTo().window(ite.next());
				System.out.println("title of link "+ a + " is " +driver.getTitle());
				a++;
			}
	
		}
	}
