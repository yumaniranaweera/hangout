package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment5 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		//1.Get the row count
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr"));
		int totalrows = rows.size();
		System.out.println("# of rows = " + totalrows);
		
		//2. Get the clumns count
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr[2]/td"));
		int totalcols = cols.size();
		System.out.println("# of columns = " + totalcols);

		//3. Get the values of the second row
		WebElement table = driver.findElement(By.xpath("//table[@class='table-display']"));
		List<WebElement> secondrow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());

	}

}