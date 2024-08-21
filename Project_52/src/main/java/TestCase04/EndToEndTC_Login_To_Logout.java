package TestCase04;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EndToEndTC_Login_To_Logout {
	WebDriver driver;

	@BeforeSuite
	// Launch Browser
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@DataProvider(name = "dataSet")
	public Object[][] givecredentials() {
		return new Object[][] { { "Admin", "admin123" } };
	}

	@Test(dataProvider = "dataSet")
	// Passing valid credentials to login
	public void testlogin(String username, String password) throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		WebElement login = driver.findElement(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
		login.click();

		// Dashboard module display validation
		WebElement ValidateDashboard = driver
				.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		ValidateDashboard.isDisplayed();
		System.out.println("Dashboard module is displayed >>>-----" + ValidateDashboard.getText());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority = 1)
	// Passing username in System Users field
	public void Admin() throws InterruptedException {
		WebElement admin = driver.findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper'][1]/child::a[1]"));
		admin.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Admin module display validation
		WebElement ValidateAdmin = driver
				.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
		ValidateAdmin.isDisplayed();
		System.out.println("Admin module is displayed >>>-----" + ValidateAdmin.getText());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority = 2)
	// Test Passing specific username in System Users fields
	public void SpecificUsersTest() throws InterruptedException {

		WebElement UN = driver.findElement(
				By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']/child::div[1]/child::div[2]/input"));
		UN.sendKeys("Admin");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement ClickSearchButton = driver.findElement(By
				.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
		ClickSearchButton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement RecordFound = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']"));

		if (RecordFound.isDisplayed())
			System.out.println("Specific Username Record is Found>>>-----" + RecordFound.getText());
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	// Test to fetch all available usernames from User Management
	public void AllUsersTest() throws InterruptedException {

		WebElement Reset = driver
				.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']"));
		Reset.click();
		WebElement RecordFound = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']"));

		if (RecordFound.isDisplayed())
			System.out.println("All Username Records are Found>>>-----" + RecordFound.getText());
	}

	@Test(priority = 4)
	// Test for Logout Functionality
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
