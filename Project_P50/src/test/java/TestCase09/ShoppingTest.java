package TestCase09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ShoppingTest {
	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(2000);
	}

	@Test(priority=1)

	public void SignUppageTest() throws InterruptedException {

		WebElement signin = driver.findElement(By.linkText("Sign In"));
		signin.click();
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("Mahesh88@gmail.com");
		Thread.sleep(2000);

		WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
		pass.sendKeys("Mahesh@123");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='send2']")).submit();

	}

	@Test(priority=2)

	public void shopToday() throws InterruptedException {
		WebElement pants = driver.findElement(
				By.xpath("//div[@class='columns']/child::div/child::div[2]/child::div/child::div/child::a"));
		pants.click();
		Thread.sleep(2000);
	}

	@Test(priority=3)

	public void climateFilter() throws InterruptedException {
		WebElement climate = driver.findElement(By.xpath(
				"//div[@class='columns']/child::div[2]/child::div/child::div[2]/child::div/child::div[3]/child::div"));
		climate.click();
		Thread.sleep(2000);

	}

	@Test(priority=4)

	public void coolClimate() throws InterruptedException {
		WebElement cool = driver.findElement(By.xpath(
				"//div[@class='columns']/child::div[2]/child::div/child::div[2]/child::div/child::div[3]/child::div/child::ol/child::li[3]/child::a"));
		cool.click();
		Thread.sleep(2000);
	}

	@Test(priority=6)

	public void selectItem() throws InterruptedException {
		WebElement item = driver
				.findElement(By.xpath("//div[@class='columns']/child::div/child::div[3]/child::ol/child::li[2]"));
		item.click();
		Thread.sleep(2000);
	}

	@Test(priority=7)
	public void selectSize() throws InterruptedException {

		WebElement size = driver.findElement(By.xpath("//div[@id='option-label-size-143-item-171']"));
		size.click();
		Thread.sleep(2000);
		WebElement selectColour = driver.findElement(By.xpath("//div[@id='option-label-color-93-item-50']"));
		selectColour.click();

		Thread.sleep(2000);
	}

	@Test(priority=8)

	public void AddToWishList() throws InterruptedException {
		WebElement wishList = driver.findElement(By.xpath("//button[@class='action primary tocart']/child::span"));
		wishList.click();
		Thread.sleep(2000);

	}

	@Test(priority=9)

	public void ViewWishList() throws InterruptedException {
		WebElement viewList = driver.findElement(By.xpath("//a[@class='action showcart']/child::span[2]"));
		viewList.click();

		WebElement ProceedToCheckout = driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']"));
		ProceedToCheckout.click();
		Thread.sleep(2000);
	}

	@Test(priority=10)

	public void ShippingAddress() throws InterruptedException {

		WebElement NextButton = driver
				.findElement(By.xpath("//button[@class='button action continue primary']/child::span"));
		NextButton.click();

		Thread.sleep(3000);

		WebElement PlaceOrder = driver.findElement(By.xpath("//button[@class='action primary checkout']/child::span"));
		PlaceOrder.click();

		Thread.sleep(5000);

		WebElement OrderNumber = driver
				.findElement(By.xpath("//div[@class='checkout-success']/child::p/child::a/child::Strong"));

		if (OrderNumber.isDisplayed())
			System.out.println(
					"Your order number is: XXXXXXXX.We'll email you an order confirmation with details and tracking info.");

		else {
			System.out.println("Order is Not Successful ");
		}
	}

	@Test(priority=11)

	public void signOutPage() {
		WebElement click = driver.findElement(By.xpath("//button[@class='action switch']"));
		click.click();

		WebElement signout = driver.findElement(By.linkText("Sign Out"));
		signout.click();

	}

	@AfterTest
	public void close() {
		driver.close();

	}

}
