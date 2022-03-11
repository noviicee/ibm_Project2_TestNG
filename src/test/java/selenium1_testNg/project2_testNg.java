package selenium1_testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class project2_testNg {
	// automate the process of login,
	// go to my social networks page,
	// find the user
	// send a message to that user
	// send an invitation to a user

	WebDriver driver;

	// Here I've added the login and
	// navigation to social network part in the
	// @BeforeMethod to reduce the complexity of the Code

	// To check for tests of login and
	// Navigating to Social Network,
	// check ./project2_testNg_0.java

	@BeforeMethod
	public void init() {
		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();

		// login
		try {
			driver.findElement(By.name("login")).sendKeys("Anamika1");
			driver.findElement(By.name("password")).sendKeys("AbcXyz");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@name='submitAuth']")).click();
			// assert
			WebElement obj = driver.findElement(By.xpath("//*[contains(text(),'Hello')]"));
			String text = obj.getText();
			Assert.assertTrue(text.contains("and welcome"));
			System.out.println("Resultant message was:" + text);
			System.out.println("Logged In!");
		} catch (Exception ex) {
			System.out.println("Exception encountered while Loggin In.");
			System.out.println("Program will not execute further.");
			System.out.println("Terminating now...");
			// System.out.println("Exception " + ex + " was encountered");
			return;
		}

		// go to social network
		try {
			WebElement obj1 = driver.findElement(By.xpath("//*[contains(text(),'Social')]"));
			obj1.click();
			System.out.println("Moved to the Social Networks tab!");
		} catch (Exception ex) {
			System.out.println("Exception while moving to Social Networks Tab.");
			System.out.println("Program will not execute further.");
			System.out.println("Terminating now...");
			// System.out.println("Exception " + ex + " was encountered");
			return;
		}
	}

	@Test(priority = 1)
	public void main1() {
		// selecting a user to send message to

		// find a user
		try {
			WebElement obj = driver.findElement(By.name("q"));
			obj.sendKeys("anamika");
			System.out.println("User found!");
		} catch (Exception ex) {
			System.out.println("Exception encountered in searching for user.");
			// System.out.println("Exception " + ex + " was encountered");
			return;
		}

		// select the found user
		try {
			WebElement obj = driver.findElement(By.name("submit"));
			obj.click();
		} catch (Exception ex) {
			System.out.println("Exception encountered in selecting the user to send message.");
		}
	}

	@Test(priority = 2)
	public void main2() {
		// sending a message to the user

		// creating the message to be sent
		String msg = "This is message" + Math.random();

		// previous work
		try {
			WebElement obj = driver.findElement(By.name("q"));
			obj.sendKeys("anamika");
			System.out.println("User found!");
		} catch (Exception ex) {
			System.out.println("Exception encountered in searching for user.");
		}

		try {
			WebElement obj = driver.findElement(By.name("submit"));
			obj.click();
		} catch (Exception ex) {
			System.out.println("Exception encountered in selecting the user to send message.");
		}

		// sending a message to that user
		try {
			WebElement obj = driver.findElement(By.xpath("//a[@class='btn btn-default ajax btn-sm']"));
			obj.click();
		} catch (Exception ex) {
			System.out.println("Exception encountered while initiating send message");
		}
		// writing the subject
		try {
			Thread.sleep(5000);
			WebElement obj = driver.findElement(By.id("subject_id"));
			obj.sendKeys("Hi! I am subject" + Math.random());
		} catch (Exception ex) {
			System.out.println("Exception encountered while trying to write a subject");
		}

		// writing the message
		try {
			WebElement obj = driver.findElement(By.xpath("//*[@id='content_id']"));
			obj.sendKeys(msg);
		} catch (Exception ex) {
			System.out.println("Exception encountered while trying to write message");
		}

		// send the message
		try {
			WebElement obj = driver.findElement(By.xpath("//a[@id='send_message_link']"));
			obj.click();
			System.out.println("Message " + msg + " has been sent to the user.");
		} catch (Exception ex) {
			System.out.println("Exception encountered while pressing send button keys!");
		}
	}

	@Test(priority = 3)
	public void main3() {
		// all work done
		// finally asserting the value
		// to check the message has been sent without encountering any errors

		// previous work
		try {
			WebElement obj = driver.findElement(By.name("q"));
			obj.sendKeys("anamika");
			System.out.println("User found!");
		} catch (Exception ex) {
			System.out.println("Exception encountered in searching for user.");
		}

		try {
			WebElement obj = driver.findElement(By.name("submit"));
			obj.click();
		} catch (Exception ex) {
			System.out.println("Exception encountered in selecting the user to send message.");
		}

		// sending a message to that user
		try {
			WebElement obj = driver.findElement(By.xpath("//a[@class='btn btn-default ajax btn-sm']"));
			obj.click();
		} catch (Exception ex) {
			System.out.println("Exception encountered while initiating send message");
		}
		// writing the subject
		try {
			Thread.sleep(5000);
			WebElement obj = driver.findElement(By.id("subject_id"));
			obj.sendKeys("Hi! I am subject" + Math.random());
		} catch (Exception ex) {
			System.out.println("Exception encountered while trying to write a subject");
		}

		// writing the message
		try {
			WebElement obj = driver.findElement(By.xpath("//*[@id='content_id']"));
			obj.sendKeys("This is message" + Math.random());
		} catch (Exception ex) {
			System.out.println("Exception encountered while trying to write message");
		}

		// send the message
		try {
			WebElement obj = driver.findElement(By.xpath("//a[@id='send_message_link']"));
			obj.click();
			System.out.println("The message has been sent to the user.");
		} catch (Exception ex) {
			System.out.println("Exception encountered while pressing send button keys!");
		}

		// assert final value
		try {
			Thread.sleep(5000);

			WebElement obj = driver.findElement(By.xpath("//*[@id='send_message']/div"));
			String text = obj.getText();
			Assert.assertTrue(text.contains("Your message has been sent"));
			System.out.println("Resultant message was:" + text);
			System.out.println("Program Completed");
			System.out.println("Closing the Window...");
			driver.quit();
		} catch (Exception ex) {
			System.out.println("Exception encountered");
			System.out.println("Seems like message was not sent.");
		}

	}
}