import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogOutTest extends BaseTest{
    @Test
    public void logOutTest(){
        homePage.logIn();
        LogOutPage logOutPage = homePage.logOut();
        Assertions.assertEquals("https://kilepes.blog.hu/", logOutPage.getUrl());
    }
    @Test
    public void navigateBackTest(){
        homePage.logIn();
        LogOutPage logOutPage = homePage.logOut();
        homePage = logOutPage.navigateback();
        Assertions.assertTrue(homePage.isThereLogInPanel());
    }
}
