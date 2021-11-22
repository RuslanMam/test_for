package Annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BassicAnnotations {
    WebDriver driver;
    String webdriverAddress = "webdriver.chrome.driver";
    String webdriverPath = "/Users/gagash/IdeaProjects/untitled2/untitled2/MyFirstSELProject/resources/chromedriver";
    @BeforeMethod
    public void setup(){
        System.setProperty(webdriverAddress, webdriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dev-hrm.yoll.io/");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
   @Test
    public void login_with_valid_credentials(){
       WebElement userNameInput= driver.findElement(By.cssSelector("input#txtUsername"));
       userNameInput.sendKeys("yoll-student");
       WebElement pinInput= driver.findElement(By.cssSelector("input#txtPassword"));
       pinInput.sendKeys("Bootcamp1#");
       WebElement submitBtn = driver.findElement(By.cssSelector("input#btnLogin"));
       submitBtn.click();
       WebElement welcomeToPage=driver.findElement(By.cssSelector("a#welcome"));
       Assert.assertEquals(welcomeToPage.getText(),"Welcome Yoll");
   }
   @Test
    public void login_with_invalid_credentials(){
       WebElement userNameInput= driver.findElement(By.cssSelector("input#txtUsername"));
       userNameInput.sendKeys("yoll-student");
       WebElement pinInput= driver.findElement(By.cssSelector("input#txtPassword"));
       pinInput.sendKeys("Bootcamp#");
       WebElement submitBtn = driver.findElement(By.cssSelector("input#btnLogin"));
       submitBtn.click();
       WebElement invalidCredentials=driver.findElement(By.cssSelector("span#spanMessage"));
       Assert.assertEquals(invalidCredentials.getText(),"Invalid credentials");

   }

}
