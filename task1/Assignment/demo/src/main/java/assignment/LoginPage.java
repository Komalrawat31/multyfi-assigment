package assignment;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By phoneField = By.xpath("//input[contains(@placeholder, '1 (702) 123-4567')]");
    By otpField = By.xpath("//*[@id='otp']");
    By loginBtn = By.xpath("//*[@id='root__layout']/main/section/div/div[1]/div[2]/div/div/div/div/div/div[2]/button");
    


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void enterPhoneNumber(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneField)).sendKeys(phone);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public void enterOtp(String otp) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(otpField)).sendKeys(otp);
    }
    
   public void clickContinueAfterOtp() {
    By continueButton = By.xpath("//button[normalize-space()='Continue']"); // stable locator
    wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();

}
    }

