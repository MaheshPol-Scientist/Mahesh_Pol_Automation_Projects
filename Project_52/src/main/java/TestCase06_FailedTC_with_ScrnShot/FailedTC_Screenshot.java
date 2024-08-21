package TestCase06_FailedTC_with_ScrnShot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class FailedTC_Screenshot {
	
	
	public static void main (String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
	

		driver.findElement(By.name("username")).sendKeys("Admin1");
		driver.findElement(By.name("password")).sendKeys("admin1");
		WebElement login = driver.findElement(
				By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
		login.click();
		
		Thread.sleep(2000);
	
		TakesScreenshot ts= (TakesScreenshot)driver;
		File scr=ts.getScreenshotAs(OutputType.FILE);
		File dest = new File ("G:\\ExcelR documentation\\Automation Project P52\\FailedTCscreenshot.jpeg");
		FileHandler.copy(scr, dest);
		
	}
	}

