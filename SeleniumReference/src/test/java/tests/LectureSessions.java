package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LectureSessions {

	public static void main(String[] args) throws Exception {
		// chromedriver.exe->Chrome browser
		System.setProperty("webdriver.chrome.driver", "D:/Yumani/Installers/seleniumDrivers/chromedriver.exe");
		
		//webdriver.chrome.driver instance
		WebDriver driver = new ChromeDriver();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		/* launch the url */
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		
		/* Login */
		
		//id locator 
		driver.findElement(By.id("inputUsername")).sendKeys("yumani@gmail.com");
		// name locator
		driver.findElement(By.name("inputPassword")).sendKeys("Tintin");
		//classname locator By.classname("classname")
		driver.findElement(By.className("signInBtn")).click();
		//css locator By.cssSelector(Tagname.classname)
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		/* forgot password */
		
		/*
		 * <form action="#" xpath="1"> 
		 * 	<h2>Forgot password</h2> 
		 * 	<input type="text" placeholder="Name"> 
		 * 	<input type="text" placeholder="Email"> 
		 * 	<input type="text" placeholder="Phone Number"> 
		 * 	<br> 
		 * 	<div class="forgot-pwd-btn-conainer"> 
		 * 		<button class="go-to-login-btn">Go to Login</button> 
		 * 		<button class="reset-pwd-btn">Reset Login</button> 
		 * 	</div>
		 * </form>
		 */

		
		//linkText locator linkText("link Text") -- clicked from the prev form
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		//xpath locator //tagname[@attribute='value']
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("waruna");
		//cssSelector locator tagname[attribute='value']
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("yumani1@gmail.com");
		//xpath locator by index of the attribute. Used when your attribute and the value are same for multiple elements
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		//Css locator by index tagname[attribute='value']:nth-child(index)
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("yumani@gmail.com");
		//xpath locator using tagnames //parenttag/childtag[index]. Use index if there many instances of child tag and you have to locate one of them.
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567891");
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		//css locator using parent-child tags parenttag<space>childtag
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		//css locator with id #elementID
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		//xpath locator by parent to child tag
		driver.findElement(By.xpath(" //div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		//String password = getPassword(driver);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("waruna");
		//css locator with regular expression. tagname[attribute*='partial value']
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne"));
		//xpath locator with regular expression //tagname[@class='value'] -> //tagname[contains(@class,'a part of the value')]
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		/* Verify the success message */
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals((driver.findElement(By.tagName("p")).getText()),"You are successfully logged in.");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		driver.close();
		driver.quit();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String passwordText =(driver.findElement(By.cssSelector("form p")).getText());
		//Please use temporary password 'rahulshettyacademy' to Login.
		// [0] th index - Please use temporary password
		// [1] st index - rahulshettyacademy' to Login.
		String[] passwordTextArray = passwordText.split("'");
		String[] passwordTextArray2= passwordTextArray[1].split("'");
		String actualPassword = passwordTextArray2[0];
		driver.close();
		return actualPassword; 
	}
}