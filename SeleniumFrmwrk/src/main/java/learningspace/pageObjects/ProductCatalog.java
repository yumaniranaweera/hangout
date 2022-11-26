package learningspace.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import learningspace.abstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));	
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
// driver.findElement(By.cssSelector(".ng-animating"))
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	//WebElements defined under By type to be used in WebElement context. You can use POs only in driver context
	By productBy = By.cssSelector(".mb-3");
	By addtoCartBtn = By.xpath("//div[@class='card-body']/button[2]");
	By toastContainer = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList(){
		waitExplicity(productBy);//You cannot use Page objects when you are using a WebElement context
		return products;
	}
	

	//get products to a list and find the product with given name
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));	
	//WebElement prod =	products.stream().filter(product->
	//product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	
	public WebElement getProductByName(String productName){
		WebElement prod =getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	//prod.findElement(By.xpath("//div[@class='card-body']/button[2]")).click();*/
	public void addToCart(String productName){
		WebElement chosenProduct = getProductByName(productName);
		chosenProduct.findElement(addtoCartBtn).click(); //You cannot use Page objects when you are using a WebElement context
		waitExplicity(toastContainer);//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#toast-container")));//by id
		waitForElementToDissapear(spinner); //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
	}
}
