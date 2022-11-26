package learningspace.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import learningspace.abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{

		WebDriver driver;		
		
		public LandingPage(WebDriver driver){
			super(driver);
			this.driver = driver;	
			PageFactory.initElements(driver, this);
		}
		
	/*	PageObjects mode*/
		@FindBy(id="userEmail")
		WebElement useremail;
		
		@FindBy(id="userPassword")
		WebElement userpass;
		
		@FindBy (id="login")
		WebElement login;
		
		//ng-tns-c4-21 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error
		@FindBy (css = "[class*='flyInOut']")
		WebElement errorMsg;
		
		
		public ProductCatalog Login(String email, String pass){
			useremail.sendKeys(email);
			userpass.sendKeys(pass);
			login.click();
			ProductCatalog prdCatalog = new ProductCatalog(driver);
			return prdCatalog;
		}
		
		public void GoTo(){
			driver.get("https://rahulshettyacademy.com/client");
		}
		
		public String IncorrectLoginError(){
			waitWebElementExplicity(errorMsg);
			return errorMsg.getText();
		
		}

}
