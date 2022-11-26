package learningspace.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import learningspace.abstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {

	WebDriver driver;

	@FindBy(xpath = ("//tbody/tr/td[2]"))
	List<WebElement> OrderedProducts;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/* Action methods */
	public List<WebElement> DisplayOrderedtProducts() {
		return OrderedProducts;
	}

	public Boolean verifyCartProduct(String productString) {
		Boolean matchOrder = OrderedProducts.stream()
				.anyMatch(orderedProduct -> orderedProduct.getText().equalsIgnoreCase(productString));
		return matchOrder;

	}
}
