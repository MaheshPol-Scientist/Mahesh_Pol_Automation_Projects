package TestCase08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SortBy {
	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(2000);
	}

	@Test(priority = 1)

	public void womendropdown() throws InterruptedException {
		WebElement women = driver.findElement(By.xpath("//a[@id='ui-id-4']/child::span[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(women).build().perform();

		WebElement tops = driver.findElement(By.linkText("Tops"));
		Actions top = new Actions(driver);
		top.moveToElement(tops).build().perform();

		WebElement jackets = driver.findElement(By.linkText("Jackets"));
		jackets.click();
		Thread.sleep(2000);
	}

	@Test(priority = 2)

	public void sortByProductName() {
		WebElement sort = driver.findElement(By.id("sorter"));
		// sort.click();
		Select sc = new Select(sort);
		sc.selectByVisibleText("Product Name");
	}

	@Test(priority = 3)

	public void backTohomePage() {
		WebElement backTohomePage = driver.findElement(By.xpath("//a[@class='logo']"));
		backTohomePage.click();
	}

	@AfterTest
	public void close() {
		driver.close();
	}
}