package Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StatusAndPriorityCreation {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public StatusAndPriorityCreation(WebDriver driver) {
		this.driver = driver;
	}

	// to click the + button
	By Create_Button = By.xpath("//button[@class='hf-mod-create']");

	// To select status name
	By Add_status_Title = By.xpath("//input[contains(@aria-label, 'Status Name')]");

	// ticket menu option locator
	By ticketmenu = By.xpath("//span[@title='Tickets']");

	// to select description
	By Status_description = By.xpath("//textarea[contains(@aria-label, 'Description')]");

	// to submit the status
	By Status_SubmitButton = By.xpath("//button[@data-test-id='add-status']");

	// Method to select status from the menu
	public void SelectStatus() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

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
		// selecting + button
		driver.findElement(Create_Button).click();
	}
	
	
	public void CreateStatus() throws InterruptedException {
		// adding status title

		driver.findElement(Add_status_Title).sendKeys("Issue created");

		// Validating the behavior that is displayed
		WebElement behavior = driver.findElement(By.xpath("//div[contains(@aria-label, 'Behavior')]"));
		String Behaviorvalue = behavior.getText();

		if (Behaviorvalue != "Pending") {
			behavior.sendKeys("Pending");
		}
		// adding description
		driver.findElement(Status_description).sendKeys("Status when a new ticket is created in HappyFox");

		driver.findElement(Status_SubmitButton).click();
		Thread.sleep(9000);

	}

	public void CreatePriority() {

		// Selecting the priority button
		By Priority_Button = By.xpath("//a[contains(text(),'Priorities')]");
		// To select add priority
		By Add_Priority_Title = By.xpath("//input[contains(@aria-label, 'Priority Name')]");
		// driver.findElement(By.xpath("//input[contains(@aria-label, 'Priority
		// Name')]")).sendKeys("Assistance required");

		// Entering priority description
		By Priority_description = By.xpath("//textarea[contains(@aria-label, 'Description')]");

//				driver.findElement(By.xpath("//textarea[contains(@aria-label, 'Description')]"))
//						.sendKeys("Priority of the newly created tickets");

		By Priority_SubmitButton = By.xpath("//button[@data-test-id='add-priority']");

		driver.findElement(Priority_Button).click();

		driver.findElement(Create_Button).click();
		driver.findElement(Add_Priority_Title).sendKeys("Assistance required");
		driver.findElement(Priority_description).sendKeys("Priority of the newly created tickets");
		driver.findElement(Priority_SubmitButton).click();

	}

	
	
	

}
