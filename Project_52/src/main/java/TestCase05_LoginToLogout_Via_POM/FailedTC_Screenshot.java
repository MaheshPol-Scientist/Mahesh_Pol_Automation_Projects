package TestCase05_LoginToLogout_Via_POM;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FailedTC_Screenshot {

	WebDriver driver;

	public FailedTC_Screenshot(WebDriver idriver) {

		driver = idriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement usernm;
	@FindBy(name = "password")
	WebElement passwd;
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
	WebElement loginBtn;

	public void url() {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public void enterUserName(String invalidnm) {

		usernm.sendKeys(invalidnm);
	}

	public void enterPassword(String invalidpw) {

		passwd.sendKeys(invalidpw);
	}

	public void ClickonLoginBtn() {

		loginBtn.click();
	}

	public void TakeScrnShot() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("G:\\ExcelR documentation\\Automation Project P52\\FailedTCscreenshot.jpeg");
		FileHandler.copy(scr, dest);
	}

}
