import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginTest extends BaseTest{
    @Test
    public void logInTest(){
        TopicPage topicPage = homePage.logIn();
        Assertions.assertEquals("tanko94", topicPage.getUserName());
    }
    @Test
    public void logInNegativeTest(){
        homePage.acceptPrivacyStatement();
        homePage.writeToUserNameField("abc");
        homePage.writeToPassWordField("123");
        homePage.clickLoginButton();
        Assertions.assertTrue(homePage.getWrongUserNameErrorMessage().contains("Hibás felhasználónév vagy jelszó!"));
    }
    @Test
    public void validEmailInvalidPassword(){
        String data="";
        try {
            File file = new File("logincredentials.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                data += scanner.nextLine()+" ";
            }
        } catch (FileNotFoundException e) {
            System.err.println("There is no such file");
            e.printStackTrace();
        }
        String[] logincredentials = data.split(" ");
        homePage.acceptPrivacyStatement();
        homePage.writeToUserNameField(logincredentials[0]);
        homePage.writeToPassWordField("123");
        homePage.clickLoginButton();

        Assertions.assertTrue(homePage.getWrongUserNameErrorMessage().contains("Hibás felhasználónév vagy jelszó!"));
    }
}
