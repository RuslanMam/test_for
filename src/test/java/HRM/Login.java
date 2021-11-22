package HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    public static void loginIn(WebDriver driver, String userName, String password){
        WebElement userNameInput= driver.findElement(By.cssSelector("input#txtUsername"));
        userNameInput.sendKeys("userName");
        WebElement pinInput= driver.findElement(By.cssSelector("input#txtPassword"));
        pinInput.sendKeys("password");
        WebElement submitBtn = driver.findElement(By.cssSelector("input#btnLogin"));
        submitBtn.click();
    }
}
