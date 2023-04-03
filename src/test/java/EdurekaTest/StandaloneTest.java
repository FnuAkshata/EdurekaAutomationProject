package EdurekaTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class StandaloneTest {

    public WebDriver driver;

    @Test
    public void loginTest() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://www.edureka.co/");

        driver.findElement(By.cssSelector(".login_click.login-vd.giTrackElementHeader")).click(); // clicking on login button

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='new_sign_up_optim'] div[class='modal-content']")));

        WebElement email = driver.findElement(By.id("si_popup_email"));
        WebElement password = driver.findElement(By.id("si_popup_passwd"));


        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("si_popup_email")));
        actions.click(email).build().perform();
        actions.sendKeys(email, "Use Your Email").build().perform();
        actions.click(password).build().perform();
        actions.sendKeys(password, "Use Your Password").build().perform();


        driver.findElement(By.cssSelector("button[class='clik_btn_log btn-block']")).click();

        // Navigate to My Profile

        WebElement profile = driver.findElement(By.cssSelector(".img30"));
        WebElement myProfile = driver.findElement(By.xpath("//a[@href='https://learning.edureka.co/my-profile']"));

        actions.click(profile).build().perform();
        actions.sendKeys(Keys.ARROW_DOWN).click(myProfile).build().perform();
        String pagetitle = driver.getTitle();
        System.out.println(pagetitle);

        // update personal details and career interest


        driver.findElement(By.xpath("//i[@class='icon-pr-edit'])[2]")).click();
        driver.findElement(By.id("fullName")).click();
        driver.findElement(By.cssSelector("#fullName")).sendKeys("Raam");


        driver.close();

    }
}
