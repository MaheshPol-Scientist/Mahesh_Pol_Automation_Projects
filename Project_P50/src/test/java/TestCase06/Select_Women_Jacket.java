package TestCase06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Select_Women_Jacket {
	WebDriver driver;

	@BeforeSuite
	public void setup() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(2000);
	}

	@Test(priority=1)
		 

	public void womendropdown() throws InterruptedException
	{
		 	 WebElement women =driver.findElement(By.xpath("//a[@id='ui-id-4']/child::span[1]"));
		 	 Actions act=new Actions(driver);
		 	 act.moveToElement(women).build().perform();
			

		 	 WebElement tops=driver.findElement(By.linkText("Tops"));
		 	 Actions top=new Actions(driver);
		 	 top.moveToElement(tops).build().perform();
		
		 	 WebElement jackets=driver.findElement(By.linkText("Jackets"));
		 	 jackets.click();
		 	 Thread.sleep(2000);
			

		 	 WebElement result=driver.findElement(By.xpath("//div[@class='page-wrapper']/child::main/child::div/child::h1/child::span"));
		 	 String aresult=result.getText();
		 	 String expected="Jackets";
		 	 Assert.assertEquals(aresult,expected);	

	}

	@Test(priority=2)
		 

	public void selectColor() throws InterruptedException
	{

		 	 WebElement color=driver.findElement(By.xpath("//div[@class='block filter']/child::div[2]/child::div/child::div[4]/child::div"));
		 	 color.click();
		 	 Thread.sleep(2000);
		 	 WebElement black=driver.findElement(By.xpath("//div[@class='block filter']/child::div[2]/child::div/child::div[4]/child::div/child::div/child::div/child::a[2]/child::div"));
		 	 black.click();
	}

	@Test(priority=3)
		 

	public void selectJacket() throws InterruptedException
	{

		 	 WebElement jacket=driver.findElement(By.xpath("//div[@class='product-item-info']/child::a/child::span/child::span/child::img"));
		 	 jacket.click();
		 	 Thread.sleep(2000);
	}

	@Test(priority=4)
	public void selectSize() throws InterruptedException
	{

	WebElement size=driver.findElement(By.xpath("//div[@id='product-options-wrapper']/child::div/child::div/child::div/child::div/child::div[2]"));
		size.click();
		Thread.sleep(2000);
	WebElement selectColour=driver.findElement(By.xpath("//div[@id='option-label-color-93-item-49']"));
	selectColour.click();
	
	
	Thread.sleep(2000);
	}

	
	@Test(priority = 5)
	public void addTocart() throws InterruptedException {

		WebElement cart = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
		cart.click();
		Thread.sleep(2000);
	}

	@Test(priority=6)
	public void viewTocart() throws InterruptedException
	{
		 
	WebElement viewcart=driver.findElement(By.xpath("//div[@class='header content']/child::div/child::a"));
	viewcart.click();
	Thread.sleep(2000);
	}

	@AfterTest
	public void close() {
		driver.close();
	}
}