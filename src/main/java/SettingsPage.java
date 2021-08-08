import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsPage {
    private WebDriver driver;
    private By introductionfield = By.xpath("//textarea[@name='introduction']");
    private By checkBoxToAgree = By.xpath("//input[@id='chk_policy']");
    private By okButton = By.xpath("//input[@id='btn_settings_ok']");

    public SettingsPage(WebDriver driver){
        this.driver=driver;
    }
    public void writeToIntroduction(String towrite){
        WebElement field = driver.findElement(introductionfield);
        field.clear();
        field.sendKeys(towrite);
        driver.findElement(checkBoxToAgree).click();
        driver.findElement(okButton).click();
    }
    public String getContentOfIntroduction(){
        return driver.findElement(introductionfield).getText();
    }
}
