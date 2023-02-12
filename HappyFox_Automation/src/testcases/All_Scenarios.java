package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginLogout;
import Pages.MakeDefault;
import Pages.StatusAndPriorityCreation;
import Pages.StatusAndPriorityDeletion;
import Pages.TicketCreation;
import Pages.TicketVerification_And_Closure;
import io.github.bonigarcia.wdm.WebDriverManager;

public class All_Scenarios {

	WebDriver driver;

	@BeforeTest
	public void driverlaunch() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://interview3.supporthive.com/staff");

		driver.manage().window().maximize();
	}

	@Test

	public void AllScenarios() throws InterruptedException, IOException {
		// Creating object of Login page
		LoginLogout login = new LoginLogout(driver);
		LoginLogout logout = new LoginLogout(driver);

		login.login();

		// Enter username & password

		StatusAndPriorityCreation creation = new StatusAndPriorityCreation(driver);
		StatusAndPriorityDeletion deletion = new StatusAndPriorityDeletion(driver);
		MakeDefault Default = new MakeDefault(driver);

		// Selecting status from the Tickets menu
		creation.SelectStatus();

		// Creating status
		creation.CreateStatus();

		// Creating priority
		creation.CreatePriority();
		// to make priority as default
		Default.MakePriorityDefault();

		// TO go back to status page to make it default
		driver.findElement(By.xpath("//a[contains(text(),'Statuses')]")).click();
		// to make status as default
		Default.MakeStatusdefault();

		Thread.sleep(3000);

		// To create a ticket
		TicketCreation newticket = new TicketCreation(driver);
		newticket.CreatingTicket();

//		// Enter username & password
//		login.enterUsername("Agent");
//		login.enterPassword("Agent@123");
//
//		// Click on login button
//	login.clickLogin();

		// verifying the ticket and closing it
		TicketVerification_And_Closure ticketclosure = new TicketVerification_And_Closure(driver);
		ticketclosure.Ticketaction();

		// deleting status and priority
		deletion.DeletingDefaultStatus();
		deletion.DeletingDefaultPriority();

		// logout
		logout.logout();

		Thread.sleep(5000);

	}

}
