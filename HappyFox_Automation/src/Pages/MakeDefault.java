package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class MakeDefault {
	
	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public MakeDefault(WebDriver driver) {
		this.driver = driver;
	}
	
		public void MakeStatusdefault() throws InterruptedException {

			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//div[@title='Issue created']"))).build().perform();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//a[contains(text(),'Make Default')])[4]")).click();
			Thread.sleep(5000);
			WebElement defaultstatus = driver.findElement(By.xpath("//div[@data-test-id='default-status']"));
			Assert.assertEquals(true, defaultstatus.isDisplayed());
			System.out.println("Status is default");

		}
		
		public void MakePriorityDefault() throws InterruptedException {
			
			Actions action1 = new Actions(driver);
			action1.moveToElement(driver.findElement(By.xpath("//span[@title='Priority of the newly created tickets']"))).build().perform();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//div[contains(text(),'Make Default')])[3]")).click();
			Thread.sleep(5000);
			WebElement defaultpriority = driver.findElement(By.xpath("//div[@data-test-id='default-priority']"));
			Assert.assertEquals(true, defaultpriority.isDisplayed());
			System.out.println("Priority is default");

		}
	

}
