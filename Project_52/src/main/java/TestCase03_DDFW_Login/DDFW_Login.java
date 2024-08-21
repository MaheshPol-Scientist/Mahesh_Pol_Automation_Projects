package TestCase03_DDFW_Login;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DDFW_Login {

	WebDriver driver;

	@BeforeSuite

	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void Login() throws IOException, InterruptedException {

		String filepath = "G:\\ExcelR documentation\\Automation Project P52\\TestCase03_DDFW_Login.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("LoginData");

		int rows = sheet.getLastRowNum();
		System.out.println("Total No of Rows" + rows);

		for (int r = 1; r <= rows; r++) {
			XSSFRow row = sheet.getRow(r);
			XSSFCell username = row.getCell(1);
			XSSFCell password = row.getCell(2);

			System.out.println("UserID>>>>>>>>>>" + username + "Password>>>>>>>>>>>" + password);
			driver.findElement(By.name("username")).sendKeys(username.toString());
			driver.findElement(By.name("password")).sendKeys(password.toString());
			WebElement login = driver.findElement(By
					.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
			login.click();
			fis.close();
			workbook.close();
		}

	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

}
