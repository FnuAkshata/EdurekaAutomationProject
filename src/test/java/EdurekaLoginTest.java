import Edureka.LoginPage;
import Edureka.MyProfilePage;
import Edureka.PersonalDetailsPage;
import EdurekaTest.EdurekaBaseTest;

import org.testng.annotations.Test;

public class EdurekaLoginTest extends EdurekaBaseTest {

    @Test
    public void EdurekaLogin() {

        LoginPage loginPage = new LoginPage(driver);
        MyProfilePage myProfilePage = loginPage.login();
        myProfilePage.myProfile();
        PersonalDetailsPage personalDetailsPage = myProfilePage.personalDetails();
        personalDetailsPage.updatePersonalDetails();


    }
}
