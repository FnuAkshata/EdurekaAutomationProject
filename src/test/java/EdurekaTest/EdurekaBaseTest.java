package EdurekaTest;

import Edureka.LandingPage;
import Edureka.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class EdurekaBaseTest {
    public WebDriver driver;
    public LandingPage landingPage;
    public LoginPage loginPage;


    public WebDriver setupDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;

    }

    @BeforeMethod
    public LandingPage launchApplication() {
        setupDriver();
        landingPage = new LandingPage(driver);
        landingPage.goTo();
        return landingPage;

    }


    @AfterClass
    public void teardown() {
        driver.quit();
    }

}
