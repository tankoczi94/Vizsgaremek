import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginTest extends BaseTest{
    @Test
    public void logInTest(){
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
        homePage.writeToPassWordField(logincredentials[1]);
        //Valamiert nem veszi at a drivert azt megkelloldani vidikbol
        TopicPage topicPage = homePage.clickLoginButton();
        Assertions.assertEquals(topicPage.getUrlOfPage(),"https://forum.index.hu/Topic/showTopicList");
    }
}
