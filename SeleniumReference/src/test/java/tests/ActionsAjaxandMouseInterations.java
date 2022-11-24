package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsAjaxandMouseInterations {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com/");
		Actions a = new Actions(driver);
		
		WebElement move = driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"));
		WebElement caps = driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
		/* Move the mouse over to an element */
		a.moveToElement(move).build().perform();
		
		/* Enter text in Caps */
		a.moveToElement(caps).clickAndHold().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		/* Enter in caps and select */
		a.moveToElement(caps).clickAndHold().keyDown(Keys.SHIFT).sendKeys("iphoneX").doubleClick().build().perform();
	}

}
