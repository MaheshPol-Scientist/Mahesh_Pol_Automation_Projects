package TestCase05_LoginToLogout_Via_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutTest_Via_POM {
	WebDriver driver;

	public LogOutTest_Via_POM(WebDriver idriver) {

		driver = idriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='oxd-userdropdown']")
	WebElement LogOutdropdown;
	@FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/child::li[4]/child::a")
	WebElement SignOut;

	public void ClickonLogoutDD() {

		LogOutdropdown.click();
	}

	public void ClickonSignOut() {

		SignOut.click();
	}

}
