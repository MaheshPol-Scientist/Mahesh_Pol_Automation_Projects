package TestCase05_LoginToLogout_Via_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllUsersTest {
	WebDriver driver;

	public AllUsersTest(WebDriver idriver) {

		driver = idriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")
	WebElement ResetBTN;
	
	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
	WebElement RecordFound;

	public void AllUserSearch () throws InterruptedException {
		ResetBTN.click();
		if (RecordFound.isDisplayed())
			System.out.println("Specific Username Record is Found>>>-----" + RecordFound.getText());
		Thread.sleep(3000);
		

	}

}
