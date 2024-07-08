package TestCase04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login_User_with_incorrect_email_password {
	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(2000);
		WebElement signin = driver.findElement(By.linkText("Sign In"));
		signin.click();
	}

	@DataProvider(name = "dataSet")
	public Object[][] givecredentials() {
		return new Object[][] { { "Mahesh@gmail.com", "Mahesh@13" } };
	}

	@Test(dataProvider = "dataSet")
	public void testlogin(String username, String password) throws InterruptedException {

		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("send2")).click();

	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

}