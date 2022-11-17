package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("checkBoxOption1")).click();	
		String optionName = driver.findElement(By.xpath("//label[1][contains(.,'Option1')]")).getText();	//another xpath //*[@id='checkbox-example']/fieldset/label[2]	
		System.out.println(optionName);
		
		WebElement StaticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(StaticDropdown);
		dropdown.selectByVisibleText(optionName);
		//System.out.println(dropdown.getFirstSelectedOption().getText());
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(optionName);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		String altMsg = driver.switchTo().alert().getText();
		
		//Hello option1, share this practice page and share your knowledge
		String[] parted1 = altMsg.split(",");
		String parted2 = parted1[0].split(" ")[1];
		//System.out.println(parted2);
		Assert.assertEquals(parted2, optionName);
		driver.switchTo().alert().accept();
		
		

	}

}
