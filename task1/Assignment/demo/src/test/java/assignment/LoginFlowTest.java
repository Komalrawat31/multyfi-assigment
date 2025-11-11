package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFlowTest {

    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://multyfi.com/"); // replace with your actual login page

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void testLoginHistoryLogoutFlow() {
        // -------------------------------
        // Login
        // -------------------------------
        loginPage.enterPhoneNumber("66666-55555");
        loginPage.clickLoginButton();

        // Enter OTP
        loginPage.enterOtp("5151"); // change as per real OTP logic

        // Click Continue
        loginPage.clickContinueAfterOtp();

        // -------------------------------
        // Verify Dashboard and History
        // -------------------------------
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard not visible!");
        Assert.assertTrue(dashboardPage.isHistoryVisible(), "History section not visible!");

        // -------------------------------
        // View Historical Cards for all segments
        // -------------------------------
        String[] segments = {"Equity","Futures","Options","Commodities","Multibaggers"};
        for(String segment : segments){
            dashboardPage.viewHistoricalCards(segment);
        }

        // -------------------------------
        // Logout
        // -------------------------------
        dashboardPage.clickLogout();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
