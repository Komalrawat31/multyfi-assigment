package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardPage {

    WebDriver driver;
    WebDriverWait wait;

    // ----------------------
    // Locators
    // ----------------------
    By dashboardContainer = By.xpath("//*[@id='root__layout']");
    By historySection = By.xpath("//*[@id='root__layout']//*[text()='History']");
    By logoutOption = By.xpath("//p[text()='Logout']");

    // ----------------------
    // New locators for Historical Cards
    // ----------------------

    // Historical cards
    By historicalCards = By.xpath("//div[contains(@class,'MuiCard-root')]");

    // Dynamic locator for segment chips
    private By getSegmentChip(String segment) {
        return By.xpath("//div[contains(@class,'MuiChip-root')]//span[text()='" + segment + "']");
    }

    // Button inside card to view historical trades
    private By viewHistoricalButton = By.xpath(".//button[contains(text(),'view historical trades')]");

    // ----------------------
    // Constructor
    // ----------------------
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ----------------------
    // Existing Methods
    // ----------------------
    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardContainer)).isDisplayed();
    }

    public boolean isHistoryVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(historySection)).isDisplayed();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutOption)).click();
    }

    // ----------------------
    // New Method: View Historical Cards for a Segment
    // ----------------------
    public void viewHistoricalCards(String segment) {
        // Click the segment chip
        wait.until(ExpectedConditions.elementToBeClickable(getSegmentChip(segment))).click();

        // Wait for cards to be visible
        List<WebElement> cards = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(historicalCards));

        // Iterate through cards
        for(WebElement card : cards){
            System.out.println("---- Card Content ----");
            System.out.println(card.getText());

            // Click 'view historical trades' button if present
            try {
                WebElement button = card.findElement(viewHistoricalButton);
                if(button.isDisplayed()){
                    button.click();
                }
            } catch (Exception e){
                // Button not present in this card
            }
        }
    }
}
