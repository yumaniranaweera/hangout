package learningspace.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import learningspace.testComponents.BaseTest;


public class ErrorValidationTests extends BaseTest{

	@Test(groups = {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException{

		landingPage.Login("testA1q@gmail.com", "testA1@gmail.com");
		assertEquals("Incorrect email or password.", landingPage.IncorrectLoginError());
		
	}

}
