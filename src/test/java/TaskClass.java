import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskClass {
    String webdriverAddress = "webdriver.chrome.driver";
    String webdriverPath = "/Users/gagash/IdeaProjects/untitled2/untitled2/MyFirstSELProject/resources/chromedriver";
    WebDriver driver;
    @Test
    public void VerifyMyAccountheader() throws InterruptedException {
        System.setProperty(webdriverAddress, webdriverPath);
//        Go to http://automationpractice.com/index.php
        driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/index.php");
        Thread.sleep(2000);
        //        Login scenario
//        Click signin button on homepage using xpath and ‘contains’ method
        WebElement clickSignin = driver.findElement(By.xpath("//*[contains(@class,'login')]"));
        clickSignin.click();

        //        Enter your email
        WebElement email = driver.findElement(By.cssSelector("#email"));
        email.sendKeys("surgebook1@gmail.com");
        //        Enter your pwd
        WebElement pin = driver.findElement(By.cssSelector("#passwd"));
        pin.sendKeys("DDdd12345");
        //        Click signin button
        WebElement signin = driver.findElement(By.cssSelector("#SubmitLogin"));
        signin.click();
        //        Verify My Account header is displayed by using assertTrue() method
        WebElement accauntPlaseholder = driver.findElement(By.xpath("//*[contains(text(),'Ru Ma')]"));
        String actualText = accauntPlaseholder.getText();
        String expectedText = "Ru Ma";
        //        Verify My Account header is displayed by using assertTrue() method
        Assert.assertTrue(actualText.equals(expectedText));

    }
//        Verify your name is displayed on the upper right corner by using assertEquals() method
       @Test
             public void displayedNameOnTop() throws InterruptedException {

           //        Verify My Account header is displayed by using assertTrue() method
           WebElement accauntPlaseholder = driver.findElement(By.xpath("//*[contains(text(),'Ru Ma')]"));
           String actualText = accauntPlaseholder.getText();
           String expectedText = "Ru Ma";
           //        Verify My Account header is displayed by using assertTrue() method
        Assert.assertEquals(actualText,expectedText);
           driver.quit();

    }
}