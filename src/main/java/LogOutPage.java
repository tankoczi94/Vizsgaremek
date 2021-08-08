import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOutPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By privacyStatement = By.xpath("//*[@id=\"qc-cmp2-ui\"]");

    public LogOutPage(WebDriver driver){
        this.driver=driver;
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public HomePage navigateback(){
        driver.navigate().back();
        return new HomePage(driver);
    }
}
