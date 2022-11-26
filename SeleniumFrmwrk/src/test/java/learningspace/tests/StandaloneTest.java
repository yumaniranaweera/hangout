package learningspace.tests;

import java.time.Duration;
import java.util.List;
//import java.util.stream.Stream;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StandaloneTest {

	public static void main(String[] args) {

		String productName = "ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("testA1@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("testA1@gmail.com");
		driver.findElement(By.id("login")).click();

		
		//explicit wait until the products load
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".mb-3")));//by class

		//get products to a list and find the product with given name
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));	
		WebElement prod =	products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();
		
		//wait until the product is added to cart
		//1. wait until the toast-container appear
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));//by id
		
		//2. wait until the animator disappears
		/*wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));//by classname 
		 * Above method incurs delay. Therefore we use invisibility of with friver.findelement
		 */		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));		
		Boolean match = 	cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();



		
		
	}

}
