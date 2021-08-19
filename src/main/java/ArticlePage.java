import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArticlePage {
    private WebDriverWait wait;
    private WebDriver driver;
    private By commentButton = By.xpath("//*[@id=\"controls\"]/a");
    private By ownComment = By.xpath("//a[contains(@class,'art_owner')]/strong[contains(text(),'tanko94')]/ancestor::tbody[1]//p");

    public ArticlePage(WebDriver driver){
        this.driver=driver;
    }

    public EditArticlePage clickCommentButton(){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(commentButton));
        driver.findElement(commentButton).click();
        return new EditArticlePage(driver);
    }

    public String getCommentText(){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(ownComment)));
        return driver.findElement(ownComment).getText();
    }

}
