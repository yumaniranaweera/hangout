package learningspace.tests;

import java.io.IOException;
import java.util.List;
//import java.util.stream.Stream;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import learningspace.pageObjects.CartPage;
import learningspace.pageObjects.CheckoutPage;
import learningspace.pageObjects.ConfirmationPage;
import learningspace.pageObjects.OrderPage;
import learningspace.pageObjects.ProductCatalog;
import learningspace.testComponents.BaseTest;


public class SubmitOrderTest extends BaseTest{
	
	String productName = "ZARA COAT 3";

	@Test
	public void SubmitOrder() throws IOException{

		String countryName = "india";
		String productName = "ZARA COAT 3";

		ProductCatalog prdCatalog = landingPage.Login("testA1@gmail.com", "testA1@gmail.com");
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

	
	@Test(dependsOnMethods = {"SubmitOrder"})
	public void VerifyOrder() throws IOException{

		ProductCatalog prdCatalog = landingPage.Login("testA1@gmail.com", "testA1@gmail.com");
		OrderPage orderPg= prdCatalog.gotToOrder();
		Assert.assertTrue(orderPg.verifyCartProduct(productName));
		
	
	}
}
