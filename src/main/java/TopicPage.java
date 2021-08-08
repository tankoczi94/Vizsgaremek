import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopicPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By userNameField = By.xpath("//*[@id=\"leftcol\"]/div[1]/h4");
    public TopicPage(WebDriver driver){
        this.driver = driver;
    }

    public String getUserName(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(userNameField)));
        return driver.findElement(userNameField).getText();
    }
}
