import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Assertion {
    String webdriverAddress = "webdriver.chrome.driver";
    String webdriverPath = "/Users/gagash/IdeaProjects/untitled2/untitled2/MyFirstSELProject/resources/chromedriver";
    @Test
    public void verifyBasic(){
        Assert.assertTrue(5>3,"First number smoller");
    }
    @Test
    public void verifySecondFalse(){
        Assert.assertFalse(2>3,"First number smoller");
    }
    @Test
    public void verifyFailTest(){
        Assert.fail("Failing thistest case because x ecseption occured");
    }
    @Test
    public void verifyAmazonLogo(){
        System.setProperty(webdriverAddress,webdriverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed on homepage");
        driver.quit();
    }
    @Test
    public void verifyAmazonCityPlaceholder(){
        System.setProperty(webdriverAddress,webdriverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        WebElement cityPlaceholder = driver.findElement(By.id("glow-ingress-line2"));
        String actualText = cityPlaceholder.getText();
        String expectedText = "Select your address";
        //Assert.assertTrue(actualText.equals(expectedText));
        //AssertEquals --> Is better way of doing it
        Assert.assertEquals(actualText, expectedText);
        driver.quit();
    }






}
