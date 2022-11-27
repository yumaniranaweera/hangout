package learningspace.tests;

import java.io.IOException;
import java.util.HashMap;
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
	public void SubmitOrder(HashMap<String,String> input) throws IOException{

		String countryName = "india";
		

		ProductCatalog prdCatalog = landingPage.Login(input.get("email"), input.get("password"));
		List<WebElement> prdList = prdCatalog.getProductList();
		prdCatalog.addToCart(input.get("productName"));
		CartPage crtPage = prdCatalog.gotToCart();
		crtPage.DisplayCartProducts();
		
		Boolean prdMatched = crtPage.verifyCartProduct(input.get("productName"));
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

	/*DataProvider with array
	@DataProvider
	public Object[][] getData(){
		return new Object[][]{{"testA1@gmail.com","testA1@gmail.com","ZARA COAT 3"},{"testA2@gmail.com","testA2@gmail.com","ADIDAS ORIGINAL"}};
	}*/

	
	
	//DataProvider with Hashmap
	@DataProvider
	public Object[][] getData(){
	
		HashMap<String,String> map = new HashMap <String, String>();
		map.put("email","testA1@gmail.com");
		map.put("password","testA1@gmail.com");
		map.put("productName","ZARA COAT 3");
		
		HashMap<String,String> map1 = new HashMap <String, String>();
		map1.put("email","testA2@gmail.com");
		map1.put("password","testA2@gmail.com");
		map1.put("productName","ADIDAS ORIGINAL");
		
		
		return new Object[][]{{map},{map1}};
	}

}






