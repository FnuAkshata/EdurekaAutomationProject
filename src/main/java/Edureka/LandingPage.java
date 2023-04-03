package Edureka;

import EdurekaUtility.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

//    Constants constants;
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(driver,this);
    }

    public void goTo(){
        driver.get(Constants.BASE_URL);
    }
}
