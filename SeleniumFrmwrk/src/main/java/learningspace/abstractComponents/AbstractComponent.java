package learningspace.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import learningspace.pageObjects.CartPage;
import learningspace.pageObjects.OrderPage;

public class AbstractComponent {

	WebDriver driver;
	
	// driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;

	public CartPage gotToCart() {
		cartHeader.click();
		CartPage crtPage = new CartPage(driver);
		return crtPage;
	}
	
	public OrderPage gotToOrder() {
		orderHeader.click();
		OrderPage ordPage = new OrderPage(driver);
		return ordPage;
	}
	
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitExplicity(By findBy) {
		// explicit wait until the products load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));																									
	}
	
	public void waitWebElementExplicity(WebElement findBy) {
		// explicit wait until the products load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));																									
	}
	
	
	//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	public void waitForElementToDissapear(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
}
