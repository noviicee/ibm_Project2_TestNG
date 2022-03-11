// program to test the Login functionality
// and navigating to Social Networks Tab functionality

package selenium1_testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class project2_testNg_0 {

	WebDriver driver;

	// The @BeforeMethod annotated method will be invoked before the execution of
	// each test method
	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", ".\\lib\\new\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();

	}

	// login
	@Test(priority = 1)
	public void main() {

		try {
			driver.findElement(By.name("login")).sendKeys("Anamika1");
			driver.findElement(By.name("password")).sendKeys("AbcXyz");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@name='submitAuth']")).click();

			// assert
			WebElement obj = driver.findElement(By.xpath("//*[contains(text(),'Hello')]"));
			String text = obj.getText();
			Assert.assertTrue(text.contains("and welcome"));
			System.out.println("Logged In!");
			System.out.println("Resultant message was:" + text);
			System.out.println("Closing this window...");
			driver.quit();
		} catch (Exception ex) {
			System.out.println("Exception encountered while Loggin In.");
			System.out.println("Check code for test-1");
			// System.out.println("Exception " + ex + " was encountered");
		}
	}

	// go to social network
	@Test(priority = 2)
	public void main1() throws Exception {

		try {
			driver.findElement(By.name("login")).sendKeys("Anamika1");
			driver.findElement(By.name("password")).sendKeys("AbcXyz");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@name='submitAuth']")).click();

			WebElement obj1 = driver.findElement(By.xpath("//*[contains(text(),'Social')]"));
			obj1.click();

			System.out.println("Moved to the Social Networks tab!");
			System.out.println("Closing this window...");
			driver.quit();
		} catch (Exception ex) {
			System.out.println("Exception while moving to Social Networks Tab.");
			System.out.println("Check the program for test-2");
			// System.out.println("Exception " + ex + " was encountered");
			return;
		}
	}

}
