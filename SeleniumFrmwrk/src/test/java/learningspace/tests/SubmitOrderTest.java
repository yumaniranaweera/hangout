package learningspace.tests;

import java.io.IOException;
import java.util.List;
//import java.util.stream.Stream;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import learningspace.pageObjects.CartPage;
import learningspace.pageObjects.CheckoutPage;
import learningspace.pageObjects.ConfirmationPage;
import learningspace.pageObjects.OrderPage;
import learningspace.pageObjects.ProductCatalog;
import learningspace.testComponents.BaseTest;


public class SubmitOrderTest extends BaseTest{
	
	//String productName = "ZARA COAT 3";

	@Test(dataProvider="getData", groups="PurchaseOrder")
	public void SubmitOrder(String email, String password, String productName) throws IOException{

		String countryName = "india";
		

		ProductCatalog prdCatalog = landingPage.Login(email, password);
		List<WebElement> prdList = prdCatalog.getProductList();
		prdCatalog.addToCart(productName);
		CartPage crtPage = prdCatalog.gotToCart();
		crtPage.DisplayCartProducts();
		
		Boolean prdMatched = crtPage.verifyCartProduct(productName);
		Assert.assertTrue(prdMatched);
		CheckoutPage chkoutpg = crtPage.goToCheckout();
		chkoutpg.selectCountry(countryName);
		ConfirmationPage cnfpg = chkoutpg.submit();
		String confirm = cnfpg.verifyConfirmationMessage();
		Assert.assertTrue(confirm.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}

	
	@Test(dependsOnMethods = {"SubmitOrder"}, dataProvider="getData")
	public void VerifyOrder(String email, String password, String productName) throws IOException{

		ProductCatalog prdCatalog = landingPage.Login(email, password);
		OrderPage orderPg= prdCatalog.gotToOrder();
		Assert.assertTrue(orderPg.verifyCartProduct(productName));
		
	
	}
	
	@DataProvider
	public Object[][] getData(){
		return new Object[][]{{"testA1@gmail.com","testA1@gmail.com","ZARA COAT 3"},{"testA2@gmail.com","testA2@gmail.com","ADIDAS ORIGINAL"}};
	}
}






