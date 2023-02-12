package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginLogout;
import Pages.StatusAndPriorityCreation;
import Pages.StatusAndPriorityDeletion;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1_And_3 {

	WebDriver driver;

	@BeforeTest
	public void driverlaunch() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://interview3.supporthive.com/staff");

		driver.manage().window().maximize();
	}

	@Test

	public void Scenario1And3Execution() throws InterruptedException, IOException {
		// Creating object of Login page
		LoginLogout login = new LoginLogout(driver);

		// Enter username & password
		login.login();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		// Object creation for creation and deletion class
		StatusAndPriorityCreation creation = new StatusAndPriorityCreation(driver);
		StatusAndPriorityDeletion deletion = new StatusAndPriorityDeletion(driver);

		// Selecting status from the Tickets menu
		creation.SelectStatus();

		// Creating status
		creation.CreateStatus();
		// Deleting NonDefault Status
		deletion.DeletingnoDefaultStatus();

		// Creating priority
		creation.CreatePriority();
		// Deleting NonDefaultPriority
		deletion.DeletingnoDefaultPriority();
		
		Thread.sleep(3000);

		LoginLogout logout = new LoginLogout(driver);
		logout.logout();

	}

	@AfterTest

	public void teardown() throws InterruptedException {
		Thread.sleep(3000);

		driver.quit();
	}
}
