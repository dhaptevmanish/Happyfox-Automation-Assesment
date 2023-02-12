package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketVerification_And_Closure {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public TicketVerification_And_Closure(WebDriver driver) {
		this.driver = driver;
	}

	// reply button locator
	By replybutton = By.xpath("//a[@data-test-id='reply-link']");

	// Canned action locator
	By CannedactionButton = By.xpath("//span[@data-test-id='canned-action-trigger']");

	// apply button
	By applybutton = By.xpath("//button[@data-test-id='hf-add-canned-action']");

	public void Ticketaction() throws InterruptedException {

		driver.get("https://interview3.supporthive.com/staff/login");
	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement Tickettitle = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='First-Service - Royal Enfield']")));
		Tickettitle.click();
		Thread.sleep(3000);

		// confirming the priority

		WebElement priority_value = driver
				.findElement(By.xpath("//div[@data-test-id='ticket-action_change-priority_trigger']"));
		String TicketPriority = priority_value.getText();
		System.out.println("Ticket priority is " + TicketPriority);

		// ticket-box_status
		WebElement status = driver.findElement(By.xpath("//div[@data-test-id='ticket-box_status']"));
		String Ticketstatus = status.getText();
		System.out.println("Ticket status is " + Ticketstatus);

		driver.findElement(replybutton).click();
		driver.findElement(CannedactionButton).click();

		// selecting an canned action from the list
		List<WebElement> CannedactionList = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		for (WebElement webElement1 : CannedactionList) {

			if (webElement1.getText().equals("Reply to Customer Query")) {
				webElement1.click();
			}
		}

		driver.findElement(applybutton).click();
		
		Thread.sleep(6000);

		// add reply button

		WebElement AddReply = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//button[@data-test-id='add-update-reply-button']")));
		AddReply.click();
		
		Thread.sleep(6000);
	}

}
