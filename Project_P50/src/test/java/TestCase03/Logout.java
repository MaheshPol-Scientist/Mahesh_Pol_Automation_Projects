package TestCase03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Logout {
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
		return new Object[][] { { "Mahesh88@gmail.com", "Mahesh@123" } };
	}

	@Test(dataProvider = "dataSet")
	public void testlogin(String username, String password) throws InterruptedException {

		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("send2")).click();
	}
	
	@Test(priority=1)
	 
	public void signOutPage()
	{
		 	 WebElement click=driver.findElement(By.xpath("//button[@class='action switch']"));
		 	 click.click();

		 	 WebElement signout=driver.findElement(By.linkText("Sign Out"));
		 	 signout.click();		

	}
	 

	@AfterTest
	public void close()
	{
		 	 driver.close();
	}	 	 
	}