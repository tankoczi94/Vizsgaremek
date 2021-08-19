import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SettingsPageTest extends BaseTest{
    @Test
    public void testInputField(){
        TopicPage topicPage = homePage.logIn();
        SettingsPage settingsPage = topicPage.clickOnSettings();
        for (int i = 0; i < 3; i++) {
            settingsPage.writeToIntroduction("abc"+serial);
            serial++;
        }

        Assertions.assertEquals("abc"+(--serial), settingsPage.getContentOfIntroduction());
    }
}
