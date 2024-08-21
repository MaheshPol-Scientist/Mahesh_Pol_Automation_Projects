package TestCase05_LoginToLogout_Via_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminCategory {
	WebDriver driver;

	public AdminCategory (WebDriver idriver) {
		
		driver = idriver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath = "//li[@class='oxd-main-menu-item-wrapper'][1]/child::a[1]")
	WebElement AdminCategory;
	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
	WebElement ValidateAdmin;


	public void ClickonAdmin() {

		AdminCategory.click();
		ValidateAdmin.isDisplayed();
		System.out.println("Admin module is displayed >>>-----" + ValidateAdmin.getText());
	}


}