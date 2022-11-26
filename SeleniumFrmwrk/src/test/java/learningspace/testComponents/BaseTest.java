package learningspace.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import learningspace.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver InitialiseBrowserDriver() throws IOException{
		
		Properties prop = new Properties();
		FileInputStream fls = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\learningspace\\resources\\GlobalData.properties");
		prop.load(fls);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			//firefox	
		}
		else if (browserName.equalsIgnoreCase("edge")){
			// edge
		}	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage LaunchApplication() throws IOException{
		driver = InitialiseBrowserDriver();
		landingPage = new LandingPage(driver);
		landingPage.GoTo();
		return landingPage;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void TearDown(){
		driver.close();
	}
}
