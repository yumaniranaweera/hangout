package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {

	WebDriver driver=null;
	
	By text_box_search = By.name("q");
	By seach_button = By.name("btnk");

	
	public GoogleSearchPage(WebDriver driver1) {
		this.driver = driver1;
	}
	
	public void setTextForSearch(String text) {
		driver.findElement(text_box_search).sendKeys(text);
	}
	
	public void clickSearchButton() {
		driver.findElement(seach_button).sendKeys(Keys.RETURN);
	}

}
