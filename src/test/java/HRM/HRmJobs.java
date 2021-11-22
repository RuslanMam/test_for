package HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class HRmJobs {
     WebDriver driver;
    String webdriverAddress = "webdriver.chrome.driver";
    String webdriverPath = "/Users/gagash/IdeaProjects/untitled2/untitled2/MyFirstSELProject/resources/chromedriver";
    String userName="yoll-student";
    String password="Bootcamp1#";
    @BeforeMethod
    public void setup() {
        System.setProperty(webdriverAddress, webdriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dev-hrm.yoll.io/");
        Login.loginIn(driver,userName,password);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();

    }
@Test
    public void verify_adding_new_job() throws InterruptedException {
        Random random=new Random();
        random.nextInt(900);
        driver.findElement(By.cssSelector("#menu_admin_viewAdminModule")).click();
        driver.findElement(By.cssSelector("#menu_admin_Job")).click();
        driver.findElement(By.cssSelector("#menu_admin_viewJobTitleList")).click();
        WebElement addBtn=driver.findElement(By.cssSelector("#btnAdd"));
        WebElement deleteBtn=driver.findElement(By.id("btnDelete"));
        Assert.assertTrue(addBtn.isDisplayed());
        Assert.assertTrue(deleteBtn.isDisplayed());
        addBtn.click();
        Thread.sleep(2000);
        String enteredTitle ="Developer"+  random.nextInt(900);
        String enteredDiscription="Frontent Dev" +random.nextInt(900);
        driver.findElement(By.cssSelector("#jobTitle_jobTitle")).sendKeys(enteredTitle);
        driver.findElement(By.cssSelector("#jobTitle_jobDescription")).sendKeys(enteredDiscription);
        driver.findElement(By.cssSelector("#btnSave")).click();
        Thread.sleep(2000);


        List<WebElement> allTitles=  driver.findElements(By.xpath("//table[@id='resultTable']/tbody//tr//td[2]"));
boolean recordMatch=false;
for(WebElement eachTitle:allTitles){
String   actualTitle=eachTitle.getText();
if(actualTitle.equals(enteredTitle)){
    recordMatch=true;
    break;
}
}
Assert.assertTrue(recordMatch);
    }

}
