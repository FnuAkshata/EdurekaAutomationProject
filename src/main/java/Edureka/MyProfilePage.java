package Edureka;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends BasePage {
    WebDriver driver;

    public MyProfilePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".img30")
    WebElement profileIcon;

    @FindBy(xpath = "//a[@href='https://learning.edureka.co/my-profile']")
    WebElement myProfile;

    @FindBy(xpath = "(//i[@class='icon-pr-edit'])[2]")
    WebElement editIcon;

    public void myProfile() {

        Actions actions = new Actions(driver);
        actions.click(profileIcon).build().perform();
        actions.sendKeys(Keys.ARROW_DOWN).click(myProfile).build().perform();
        String pagetitle = driver.getTitle();
        System.out.println(pagetitle);

    }

    public PersonalDetailsPage personalDetails() {

        editIcon.click();
        return new PersonalDetailsPage(driver);
    }
}
