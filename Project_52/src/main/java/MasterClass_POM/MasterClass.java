package MasterClass_POM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import TestCase05_LoginToLogout_Via_POM.AdminCategory;
import TestCase05_LoginToLogout_Via_POM.AllUsersTest;
import TestCase05_LoginToLogout_Via_POM.FailedTC_Screenshot;
import TestCase05_LoginToLogout_Via_POM.FindSpecificUsersTest;
import TestCase05_LoginToLogout_Via_POM.LogOutTest_Via_POM;
import TestCase05_LoginToLogout_Via_POM.LoginTest_Via_POM;

public class MasterClass {
	WebDriver driver = new ChromeDriver();

	@BeforeSuite
	// Launch Browser
	public void setup() throws InterruptedException {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority = 1)

	public void LoginTest() throws InterruptedException {

		LoginTest_Via_POM Login = new LoginTest_Via_POM(driver);
		Login.url();
		Login.enterUserName("Admin");
		Login.enterPassword("admin123");
		Login.ClickonLoginBtn();

		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void AdminCategory() throws InterruptedException {
		AdminCategory Admin = new AdminCategory(driver);
		Admin.ClickonAdmin();

		Thread.sleep(2000);

	}

	@Test(priority = 3)
	public void FindSpecificUserTest() throws InterruptedException {
		FindSpecificUsersTest fun = new FindSpecificUsersTest(driver);
		fun.FindUserName("Admin");
		fun.ClickSearchBTN();
	}

	@Test(priority = 4)
	public void SearchAllUsersTest() throws InterruptedException {

		AllUsersTest SrchAllUsers = new AllUsersTest(driver);

		SrchAllUsers.AllUserSearch();

	}

	@Test(priority = 5)
	public void LogOut() throws InterruptedException {
		LogOutTest_Via_POM Logout = new LogOutTest_Via_POM(driver);
		Logout.ClickonLogoutDD();
		Logout.ClickonSignOut();
		Thread.sleep(3000);
	}

	@Test(priority = 6)
	public void FailedTCScrnshot() throws InterruptedException, IOException {
		FailedTC_Screenshot FailedTCSrnshotTest = new FailedTC_Screenshot(driver);
		FailedTCSrnshotTest.url();
		FailedTCSrnshotTest.enterUserName("Admin1");
		FailedTCSrnshotTest.enterPassword("admin1");
		FailedTCSrnshotTest.ClickonLoginBtn();
		Thread.sleep(3000);
		FailedTCSrnshotTest.TakeScrnShot();
		Thread.sleep(3000);
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

}
