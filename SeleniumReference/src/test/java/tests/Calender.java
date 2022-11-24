package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();

		while (!driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText().contains("May")) {
			//// div[@class='flatpickr-month']/div[@class='flatpickr-current-month']
			driver.findElement(By.className("flatpickr-next-month")).click();
		}

		List<WebElement> days = driver.findElements(By.className("flatpickr-day "));
		// int count = driver.findElements(By.className("flatpickr-day ")).size();
		int count = days.size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("flatpickr-day ")).get(i).getText();
			if (text.equalsIgnoreCase("20")) {
				driver.findElements(By.className("flatpickr-day ")).get(i).click();
				break;
			}
		}

	}

}
