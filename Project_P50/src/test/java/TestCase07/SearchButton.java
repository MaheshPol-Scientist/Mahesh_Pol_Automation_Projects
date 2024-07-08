package TestCase07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SearchButton {
	WebDriver driver;

	@BeforeSuite

	public void setup() throws InterruptedException

	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(2000);
	}

	@Test

	public void searchButton() {
		// Find the search button element
		WebElement searchButton = driver.findElement(By.xpath("//input[@id='search']"));

		// Type in the search button
		searchButton.sendKeys("Fitness equipment");

		// Submit the search
		searchButton.submit();

		WebElement search = driver
				.findElement(By.xpath("//div[@class='page-wrapper']/child::main/child::div/child::h1/child::span"));
		String search1 = search.getText();
		System.out.println(search1);

		String s1 = "Search results for: 'Fitness equipment'";
		Assert.assertEquals(search1, s1);
	}

	@AfterTest
	public void close() {
		driver.close();

	}

}