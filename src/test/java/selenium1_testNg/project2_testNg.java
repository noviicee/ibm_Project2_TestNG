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
        // finding and selecting a user to send message to

        try {
            // find a user
            WebElement obj = driver.findElement(By.name("q"));
            obj.sendKeys("anamika");
            System.out.println("User found!");

            // select the found user
            WebElement obj1 = driver.findElement(By.name("submit"));
            obj1.click();
            
            System.out.println("User found and selected.");
            System.out.println("Test-1 has been passed");
            System.out.println("Closing this window..");
            driver.quit();
        } catch (Exception ex) {
            System.out.println("Exception encountered in finding and selecting the user to send message.");
            // System.out.println("Exception " + ex + " was encountered");
        }
    }

    @Test(priority = 2)
    public void main2() {
        // sending a message to the selected user

        // creating the message to be sent
        String msg = "This is message" + Math.random();

        try {

            // previous work
	            WebElement obj = driver.findElement(By.name("q"));
	            obj.sendKeys("anamika");
	            System.out.println("User found!");
	
	            WebElement obj1 = driver.findElement(By.name("submit"));
	            obj1.click();

            // sending a message to that user
	            WebElement obj2 = driver.findElement(By.xpath("//a[@class='btn btn-default ajax btn-sm']"));
	            obj2.click();
	
	            // writing the subject
	            Thread.sleep(5000);
	            WebElement obj3 = driver.findElement(By.id("subject_id"));
	            obj3.sendKeys("Hi! I am subject" + Math.random());
	
	            // writing the message
	            WebElement obj4 = driver.findElement(By.xpath("//*[@id='content_id']"));
	            obj4.sendKeys(msg);
	
	            // send the message
	            WebElement obj5 = driver.findElement(By.xpath("//a[@id='send_message_link']"));
	            obj5.click();
	            System.out.println("Message " + msg + " has been sent to the user.");
	            System.out.println("Test-2 has been passd");
	            System.out.println("Closing the Window...");
	            driver.quit();
        } catch (Exception ex) {
            System.out.println("Exception encountered while sending a message to the user.");
            System.out.println("Check Test-2");
            System.out.println("Exception encountered was: " + ex);
        }
    }

    @Test(priority = 3)
    public void main3() {
        // sending a message to the selected user

        // creating the message to be sent
        String msg = "This is message" + Math.random();

        try {

            // previous work
	            WebElement obj = driver.findElement(By.name("q"));
	            obj.sendKeys("anamika");
	            System.out.println("User found!");
	
	            WebElement obj1 = driver.findElement(By.name("submit"));
	            obj1.click();
	
	            // sending a message to that user
	            WebElement obj2 = driver.findElement(By.xpath("//a[@class='btn btn-default ajax btn-sm']"));
	            obj2.click();
	
	            Thread.sleep(5000);
	            WebElement obj3 = driver.findElement(By.id("subject_id"));
	            obj3.sendKeys("Hi! I am subject" + Math.random());
	
	            WebElement obj4 = driver.findElement(By.xpath("//*[@id='content_id']"));
	            obj4.sendKeys(msg);
	
	            WebElement obj5 = driver.findElement(By.xpath("//a[@id='send_message_link']"));
	            obj5.click();
	            System.out.println("Message " + msg + " has been sent to the user.");

            // assert final value
	            Thread.sleep(5000);
	            WebElement obj6 = driver.findElement(By.xpath("//*[@id='send_message']/div"));
	            String text = obj6.getText();
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