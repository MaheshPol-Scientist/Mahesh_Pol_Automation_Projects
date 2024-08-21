package TestCase05_LoginToLogout_Via_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindSpecificUsersTest {
	WebDriver driver;

	public FindSpecificUsersTest(WebDriver idriver) {

		driver = idriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']/child::div[1]/child::div[2]/input")
	WebElement FindUserName;
	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	WebElement ClickSearchBTN;
	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span']")
	WebElement FindRecord;

	public void FindUserName(String fun) {
		FindUserName.sendKeys(fun);

	}

	public void ClickSearchBTN() throws InterruptedException {

		ClickSearchBTN.click();
		if (FindRecord.isDisplayed())
			System.out.println("Specific Username Record is Found>>>-----" + FindRecord.getText());
		Thread.sleep(3000);

	}

}
