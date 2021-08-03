import org.openqa.selenium.WebDriver;

public class TopicPage {
    private WebDriver driver;
    public TopicPage(WebDriver driver){
        this.driver = driver;
    }

    public String getUrlOfPage() {
        return urlOfPage;
    }

    private String urlOfPage;

    {
        assert driver != null;
        urlOfPage = driver.getCurrentUrl();
    }
}
