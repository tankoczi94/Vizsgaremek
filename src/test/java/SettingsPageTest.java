import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SettingsPageTest extends BaseTest{
    @Test
    public void testInputField(){
        TopicPage topicPage = homePage.logIn();
        SettingsPage settingsPage = topicPage.clickOnSettings();
        settingsPage.writeToIntroduction("abc");
        Assertions.assertEquals("abc", settingsPage.getContentOfIntroduction());
    }
}
