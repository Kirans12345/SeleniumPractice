package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenDemoWebShop {
	WebDriver driver;

	@BeforeClass
	public void openbrowser() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");

	}

	@Test(dataProvider = "testdata")
	public void CreateAccount(String username, String password)
			throws InterruptedException {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);


	}

	@DataProvider(name = "testdata")
	public Object[][] datasupplier() throws IOException {

		Object[][] data = { { "user1@gmail.com", "user123" },
				{ "user2", "user2@gmail.com" },
				{  "user123", "user3@gmail.com" } };
		return data;

	}

}
