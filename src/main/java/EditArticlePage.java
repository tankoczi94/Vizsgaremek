import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditArticlePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By commentSectionInFrame = By.xpath("//body[@id='tinymce']");
    private By sendInButtonInFrame = By.xpath("//div[@id='editor_border']/p[1]/input[@name='submit_public']");
    private By frame = By.xpath("//*[@id=\"editor_obj_tbl\"]/tbody/tr[2]/td/iframe");
    private By errorMessage = By.xpath("//*[@id=\"maintd\"]/form/div/div[1]");


    public EditArticlePage(WebDriver driver){
        this.driver=driver;
    }

    public void switchToFrame(){
        driver.switchTo().frame(driver.findElement(frame));
    }

    public void clearTextArea(){
        switchToFrame();
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.attributeToBe(commentSectionInFrame,"contenteditable","true"));
        driver.findElement(commentSectionInFrame).clear();
        switchToMainArea();
    }
    public void enterComment(String comment){
        switchToFrame();
        driver.findElement(commentSectionInFrame).sendKeys(comment);
        switchToMainArea();
    }
    public void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
    public ArticlePage sendInComment(){
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(sendInButtonInFrame));
        driver.findElement(sendInButtonInFrame).click();
        return new ArticlePage(driver);
    }
    public String getErrorText(){
        WebElement errormsg = driver.findElement(errorMessage);
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(errormsg));
        return errormsg.getText();
    }
}
