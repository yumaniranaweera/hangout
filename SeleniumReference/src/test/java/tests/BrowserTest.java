package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	public static void main(String[] args) {
		//String projectpath = System.getProperty("user.dir");
		//System.out.println("projectpath" + projectpath);
		//System.setProperty("webdriver.gecko.driver", projectpath+"\\drivers\\gekodriver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com");
		
		if(driver!=null)
			driver.close();
			driver.quit();
	}
	
	
}
