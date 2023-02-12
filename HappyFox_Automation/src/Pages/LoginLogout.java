package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.This;

public class LoginLogout {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	
	// Locator for username field
	By uName = By.id("id_username");

	// Locator for password field
	By pswd = By.id("id_password");

	// Locator for login button
	By loginBtn = By.id("btn-submit");
	
	// Locator for Profile button 
	
	By ProfileButton = By.xpath("//div[@data-test-id='staff-menu']");
	
	By Logout = By.xpath("//li[@data-test-id='staff-menu_logout']");
	public LoginLogout(WebDriver driver) {
		this.driver = driver;

	}
	
	public void login() throws IOException {
		File src = new File("C:\\Testdata\\TestData.xlsx"); // this is like
		// creating a objct for the file path and assigning it in inputstream

		FileInputStream excel = new FileInputStream(src); // using this to fetch the
															// sheet
// nedw change 
		XSSFWorkbook workbook = new XSSFWorkbook(excel); // this is used to load excel workbook
		XSSFSheet sheet1 = workbook.getSheetAt(0);// this is to specify the sheet in which the data is

		// String data0 = sheet1.getRow(0).getCell(0).getStringCellValue(); // this gets
		// us the value that is in the (0,0)
		// cell in the sheet
//			int rowcount = sheet1.getLastRowNum();
		// when we get the last row we know the size so we r using that here
		String username = sheet1.getRow(1).getCell(0).getStringCellValue();
		String password = sheet1.getRow(1).getCell(1).getStringCellValue();


//System.out.println(rowcount);
		driver.findElement(uName).sendKeys(username);
		driver.findElement(pswd).sendKeys(password);
		driver.findElement(loginBtn).click();
	}
	


	
	

	// Method to enter username

	
	public void logout() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement ProfileButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-test-id='staff-menu']")));
		ProfileButton.click();
		
		driver.findElement(Logout).click();
		Thread.sleep(2000);
		
	}
	

}
