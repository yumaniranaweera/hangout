package learningspace.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import learningspace.abstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	/* PageObjects model */

	//findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	
	//driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	//@FindBy(css = ".ta-item:last-of-type")	
	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement selectCountry;
	
	//driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(css = ".action__submit")
	WebElement submit;
	
	By waitcountryDrpDwn =  (By.cssSelector(".ta-results"));
	
	//Actions a = new Actions(driver);
	//a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	//	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

	public void selectCountry(String countryName){
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitExplicity(waitcountryDrpDwn);
		selectCountry.click();
	}

	//	driver.findElement(By.cssSelector(".action__submit")).click();
	public ConfirmationPage submit(){
		submit.click();
		ConfirmationPage cmfrmPg = new ConfirmationPage(driver);
		return cmfrmPg;
	}
	
	
	
	
}
