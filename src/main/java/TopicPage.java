import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopicPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By userNameField = By.xpath("//*[@id=\"leftcol\"]/div[1]/h4");
    private By settingsButton = By.xpath("//a[.='Beállítások']");
    private By firstForumPageButton = By.xpath("//b[.='A Törzsasztal']");
    private By editedArticlesButton = By.xpath("//a[.='Piszkozatok']");

    public TopicPage(WebDriver driver){
        this.driver = driver;
    }

    public String getUserName(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(userNameField)));
        return driver.findElement(userNameField).getText();
    }
    public SettingsPage clickOnSettings(){
        driver.findElement(settingsButton).click();
        return new SettingsPage(driver);
    }
    public ForumPage clickFirstForumPageButton(){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(firstForumPageButton));
        driver.findElement(firstForumPageButton).click();
        return new ForumPage(driver);
    }
    public EditedArticlePage clickOnEditedArticles(){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(editedArticlesButton));
        driver.findElement(editedArticlesButton).click();
        return new EditedArticlePage(driver);
    }
}
