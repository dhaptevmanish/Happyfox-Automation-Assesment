package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TicketCreation {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public TicketCreation(WebDriver driver) {
		this.driver = driver;
	}

	// locating the subject of ticket
	By subject = By.xpath("//input[@id='id_subject']");

// locating the description text box

	By Message = By.xpath("//div[@role='textbox']");

	// locating the Email text box
	By Email = By.xpath("//input[@id='id_email']");

	// Locating the submit button
	By SubmitButton = By.xpath("//button[@id='submit']");

	public void CreatingTicket() throws InterruptedException {
		driver.get("https://interview3.supporthive.com/new/");
		Thread.sleep(3000);
		
		// Again using this as workaround to resolve the create ticket not working issue
		driver.get("https://interview3.supporthive.com/new/");

	
		Thread.sleep(3000);
		driver.findElement(subject).click();
		driver.findElement(subject).sendKeys("First-Service - Royal Enfield");
		driver.findElement(Message).click();
		driver.findElement(Message).sendKeys("First service for royal enfield bike");

		WebElement Name = driver.findElement(By.xpath("//input[@id='id_name']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Name);
		Thread.sleep(5000); 
		Name.click();
		Name.sendKeys("Thor ragnarok");
		
//		driver.findElement((By) Name).click();
//		driver.findElement((By) Name).sendKeys("Thor ragnarok");

		driver.findElement(Email).click();
		driver.findElement(Email).sendKeys("Thorragnarok@gmail.com");

		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		Thread.sleep(6000);

		if (driver.getPageSource().contains("Your ticket has been created and you have been emailed instructions "
				+ "to activate your account with which you can track your ticket status")) {
			System.out.println("Ticket created successfully");
		}

		else {
			System.out.println("Ticket not created");
		}

	}

}
