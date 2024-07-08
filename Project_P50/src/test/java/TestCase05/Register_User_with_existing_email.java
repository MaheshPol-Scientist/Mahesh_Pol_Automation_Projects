package TestCase05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Register_User_with_existing_email {
	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	// verify URL
	public void verifyURL() {
		String expectedURL = "https://magento.softwaretestingboard.com/";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
	}

	@Test(priority = 2)
	// Verifying elements on create account page
	public void createAccountPageTest() throws InterruptedException {

		driver.findElement(By.linkText("Create an Account")).click();
		Thread.sleep(2000);

		WebElement firstname = driver.findElement(By.xpath("//input[@id='firstname']"));
		if (firstname.isDisplayed()) {
			firstname.sendKeys("Mahesh");

		}

		WebElement lastname = driver.findElement(By.xpath("//input[@id='lastname']"));
		if (lastname.isDisplayed()) {
			lastname.sendKeys("Pol");
		}

		WebElement emailid = driver.findElement(By.xpath("//input[@id='email_address']"));
		if (emailid.isDisplayed()) {
			emailid.sendKeys("Mahesh88@gmail.com");
		}

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		if (password.isDisplayed()) {
			password.sendKeys("Mahesh@123");
		}

		WebElement confirmpass = driver.findElement(By.xpath("//input[@id='password-confirmation']"));
		if (confirmpass.isDisplayed()) {
			confirmpass.sendKeys("Mahesh@123");
		}

		WebElement createAcct = driver.findElement(By.xpath("//button[@title='Create an Account']"));
		if (createAcct.isDisplayed()) {
			createAcct.submit();
			Thread.sleep(4000);

			try {

				WebElement error_message_element = driver.findElement(
						By.xpath("//div[@class='page messages']/child::div/child::div/child::div/child::div"));

				if (error_message_element.isDisplayed())
					System.out.println("Error message is visible: There is already an account with this email address."
							+ " If you are sure that it is your email address, click here to get your password and access your account. ");

				else {
					System.out.println("Error message is Not visible: ");
				}

			}

			finally

			{
				driver.quit();

			}
		}
	}
}
