package Edureka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".login_click.login-vd.giTrackElementHeader")
    WebElement login;

    @FindBy(id = "si_popup_email")
    WebElement email;

    @FindBy(id = "si_popup_passwd")
    WebElement password;


    By loginPage = By.cssSelector("div[id='new_sign_up_optim'] div[class='modal-content']");

    public MyProfilePage login() {
        Actions actions = new Actions(driver);
        actions.click(login).build().perform();
        waitUntilElementToAppear(loginPage);
        actions.click(email).build().perform();
        actions.sendKeys(email, "saha123@gmail.com").build().perform();
        actions.click(password).build().perform();
        actions.sendKeys(password, "Ganapati6").build().perform();
        clickLoginButton();
        MyProfilePage myProfilePage = new MyProfilePage(driver);
        return myProfilePage;


    }


}
