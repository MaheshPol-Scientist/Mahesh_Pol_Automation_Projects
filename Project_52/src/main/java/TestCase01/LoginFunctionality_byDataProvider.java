package TestCase01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginFunctionality_byDataProvider {
	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);

	}

	@DataProvider(name = "dataSet")
	public Object[][] givecredentials() {
		return new Object[][] { { "Admin", "admin123" } };
	}

	@Test(dataProvider = "dataSet")
	public void testlogin(String username, String password) throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		WebElement login = driver.findElement(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
		login.click();

	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}
