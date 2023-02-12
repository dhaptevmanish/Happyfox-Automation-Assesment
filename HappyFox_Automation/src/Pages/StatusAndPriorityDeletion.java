package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StatusAndPriorityDeletion {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public StatusAndPriorityDeletion(WebDriver driver) {
		this.driver = driver;
	}

	// Selecting the summary using the title
	By SummaryTitle = By.xpath("//div[@title='Issue created']");

	// Selecting the delete status button
	By DeleteSummary = By.xpath("//a[@data-test-id='status-delete-trigger']");

	// Selecting the priority using the title

	By Prioritytitle = By.xpath("//span[@title='Assistance required']");

	// Selecting the delete priority button
	By DeletePriority = By.xpath("//a[@data-test-id='priority-delete-trigger']");

	// Pressing the Final delete button

	By Finaldelete = By.xpath("//button[@data-test-id='delete-dependants-primary-action']");
	// driver.findElement(By.xpath("//a[@data-test-id='status-delete-trigger']")).click();

	// Status delete button
	By statusdelete = By.xpath("//a[@data-test-id='status-delete-trigger']");

	// Priority delete button
	By prioritydelete = By.xpath("//a[@data-test-id='priority-delete-trigger']");

	// Priorities display page button
	By Priority_Button = By.xpath("//a[contains(text(),'Priorities')]");

	// The final delete button to delete the status / priority

	public void DeletingnoDefaultStatus() throws InterruptedException {
		driver.findElement(SummaryTitle).click();
		driver.findElement(DeleteSummary).click();
		driver.findElement(Finaldelete).click();

		Thread.sleep(3000);

	}

	public void DeletingnoDefaultPriority() throws InterruptedException {
		driver.findElement(Prioritytitle).click();
		driver.findElement(DeletePriority).click();
		driver.findElement(Finaldelete).click();

		Thread.sleep(5000);
	}

	public void DeletingDefaultStatus() throws InterruptedException {

		Thread.sleep(6000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement Ticketmenu = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@title='Tickets']")));
		Ticketmenu.click();

		Thread.sleep(3000);

		List<WebElement> options = driver.findElements(By.className("ember-view"));

		try {
			for (WebElement webElement : options) {
				if (webElement.getText().equals("Statuses")) {
					webElement.click();
				}
			}
		} catch (StaleElementReferenceException e) {
		}

		driver.findElement(By.xpath("//div[@title='Issue created']")).click();
		Thread.sleep(3000);
		driver.findElement(statusdelete).click();

		driver.findElement(By.xpath("//*[contains(text(),'Choose Status')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='ember-power-select-search-input']")).sendKeys("Closed");

		List<WebElement> StatusOptionsList = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

		for (WebElement webElement1 : StatusOptionsList) {
			if (webElement1.getText().equals("Closed")) {
				webElement1.click();
			} else {
				System.out.println("Closed not found");
			}
			break;
		}
//		//	Final delete button

		driver.findElement(Finaldelete).click();

		Thread.sleep(10000);

	}

	public void DeletingDefaultPriority() throws InterruptedException {
		Thread.sleep(3000);
		// Selecting the priority button
		driver.findElement(Priority_Button).click();
		Thread.sleep(3000);
		driver.findElement(Prioritytitle).click();
		Thread.sleep(3000);
		driver.findElement(prioritydelete).click();

		driver.findElement(By.xpath("//*[contains(text(),'Choose Priority')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@class='ember-power-select-search-input']")).sendKeys("Low");

		List<WebElement> StatusOptionsList = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

		for (WebElement webElement1 : StatusOptionsList) {
			if (webElement1.getText().equals("Low")) {
				webElement1.click();
			} else {
				System.out.println("Low not found");
			}
			break;

		}

//		Final delete button

		driver.findElement(Finaldelete).click();

		Thread.sleep(10000);

	}
}
