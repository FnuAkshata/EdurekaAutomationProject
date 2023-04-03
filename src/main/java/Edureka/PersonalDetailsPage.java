package Edureka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPage extends BasePage {

    WebDriver driver;

    public PersonalDetailsPage(WebDriver driver) {
        super(driver);

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "fullName")
    WebElement fullName;

    @FindBy(xpath = "(//button[@type='button'])[5]")
    WebElement experience;

    @FindBy(css = "ul[class='available-items'] li:nth-child(1)")
    WebElement experience2_4;

    @FindBy(xpath = "//body[1]/app-root[1]/app-onboarding-user-details[1]/section[1]/div[1]/mat-tab-group[1]/div[1]/mat-tab-body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/ngx-select-dropdown[1]/div[1]/button[1]")
    WebElement industry;

    @FindBy(xpath = "//li[normalize-space()='IT-Hardware & Networking']")
    WebElement industryType;

    @FindBy(css = "#designation")
    WebElement designation;

    By userDetails = By.cssSelector(".onboarding-p2.step-1");


    public void updatePersonalDetails() {

        waitUntilElementToAppear(userDetails);
        fullName.click();
        fullName.clear();
        fullName.sendKeys("David");
        experience.click();
        experience2_4.click();
        industry.click();
        industryType.click();
        designation.click();
        designation.sendKeys("Senior Engineer");


    }
}
