package TestCase02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogoutFunctionality_byDataProvider {

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
		Thread.sleep(3000);
	}

	@Test(priority = 1)

	public void signOutPage() throws InterruptedException {
		WebElement LOdropdown = driver.findElement(By.xpath("//li[@class='oxd-userdropdown']"));
		LOdropdown.click();
		Thread.sleep(3000);

		WebElement signout = driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/child::li[4]/child::a"));
		signout.click();
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

}
