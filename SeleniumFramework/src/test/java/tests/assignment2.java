package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
	
		driver.findElement(By.name("name")).sendKeys("Kamani");
		driver.findElement(By.name("email")).sendKeys("Kamani@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("kamAni1");
		driver.findElement(By.id("exampleCheck1")).click();
		
		
		WebElement StaticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(StaticDropdown);
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("Female");
		
		driver.findElement(By.name("bday")).sendKeys("01/01/1990");
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		
		System.out.println(driver.findElement(By.xpath("(//div[@class='alert alert-success alert-dismissible'])")).getText());
		Assert.assertEquals(driver.findElement(By.className("alert alert-success alert-dismissible")).getText(), "Success! The Form has been submitted successfully!.");
		driver.close();
	}

}