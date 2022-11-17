package tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment4 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		Set<String> wins = driver.getWindowHandles();
		Iterator<String> iterate = wins.iterator();
		String parent = iterate.next();
		driver.switchTo().window(parent).findElement(By.xpath("//a[@href='/windows']")).click();
		Thread.sleep(2000);
		String child = iterate.next();
		String subchild = iterate.next();
		

		
		driver.switchTo().window(child).findElement(By.xpath("//a[@href='/windows/new']")).click();
		Thread.sleep(2000);
		System.out.println(driver.switchTo().window(subchild).findElement(By.tagName("h3")).getText());
		System.out.println(driver.switchTo().window(child).findElement(By.tagName("h3")).getText());

	}

}
