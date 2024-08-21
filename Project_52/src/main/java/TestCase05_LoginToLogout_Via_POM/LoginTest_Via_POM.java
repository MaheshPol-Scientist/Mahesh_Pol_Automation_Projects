package TestCase05_LoginToLogout_Via_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTest_Via_POM {
	WebDriver driver;

	public LoginTest_Via_POM(WebDriver idriver) {

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

	public void enterUserName(String nm) {

		usernm.sendKeys(nm);
	}

	public void enterPassword(String pw) {

		passwd.sendKeys(pw);
	}

	public void ClickonLoginBtn() {

		loginBtn.click();
	}

}
