package simpleGoogleTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestGoogle {
	WebDriver driver = null;

	@Test(priority = 1)
	public void openGoogle() {

		driver = new ChromeDriver();

		driver.get("https://www.google.co.in");

		System.out.println("Opened Google with title : " + driver.getTitle());
	}

	@Test(priority = 2)
	public void searchGoogle() {

		driver.findElement(By.cssSelector("input[name= \"q\"]")).sendKeys("Selenium");
		driver.findElement(By.cssSelector("input[name= \"q\"]")).sendKeys(Keys.ENTER);

		System.out.println("Searched Google");

	}
@Test(priority=3)
	public void selectingPage() {

		driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div > div.yuRUbf > a > div > cite"))
				.click();

		System.out.println("Selected Page with title : " + driver.getTitle());
		driver.navigate().back();
		driver.navigate().back();
	}

@Test(priority=4)
public void closingBrowser() {
//	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	System.out.println(driver.getTitle());
	driver.close();
	System.out.println("Closed the open browser");
}
}

