package learningspace.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import learningspace.abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* PageObjects model */

	// driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	@FindBy(css = "[routerlink*='cart']")
	WebElement routerLink;

	// driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(css = (".cartSection h3"))
	List<WebElement> cartProducts;

	// driver.findElement(By.cssSelector(".totalRow button")).click();
	@FindBy(css = (".totalRow button"))
	WebElement chkout;

	
	/*Action methods*/

	// List <WebElement> cartProducts =
	// driver.findElements(By.cssSelector(".cartSection h3"));
	public List<WebElement> DisplayCartProducts() {
		return cartProducts;
	}

	// Boolean match = cartProducts.stream().anyMatch(cartProduct->
	// cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
	// Assert.assertTrue(match);
	public Boolean verifyCartProduct(String productString) {
		Boolean match = cartProducts.stream().anyMatch(cartProduct -> 
		cartProduct.getText().equalsIgnoreCase(productString));
		return match;
	}

	// driver.findElement(By.cssSelector(".totalRow button")).click();
	public CheckoutPage goToCheckout() {
		chkout.click();
		CheckoutPage chkoutPg = new CheckoutPage(driver);
		return chkoutPg;
	}

}
