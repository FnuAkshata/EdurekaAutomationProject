package EdurekaTest;

import Edureka.LoginPage;
import Edureka.MyProfilePage;
import Edureka.PersonalDetailsPage;

import org.testng.annotations.Test;

public class EdurekaLoginTest extends EdurekaBrowserHome {

    @Test
    public void EdurekaLogin() {

        LoginPage loginPage = new LoginPage(driver);
        MyProfilePage myProfilePage = loginPage.login();
        myProfilePage.myProfile();
        PersonalDetailsPage personalDetailsPage = myProfilePage.personalDetails();
        personalDetailsPage.updatePersonalDetails();


    }
}
