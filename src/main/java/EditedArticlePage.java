import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class EditedArticlePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By listOfElements = By.xpath("//*[@id=\"maintd\"]/table");
    private By deleteButtonOnElement = By.xpath("//a[contains(text(),'töröl')]");

    public EditedArticlePage(WebDriver driver){
        this.driver=driver;
    }

    public ArrayList<WebElement> getListOfComments(){
        return new ArrayList<WebElement>(driver.findElements(listOfElements));
    }
    public void deleteComment(){
        ArrayList<WebElement> listToUse = getListOfComments();
        if(listToUse.size()>0){
            listToUse.get(0).findElement(deleteButtonOnElement).click();
        }
    }
    public int getSizeOfElementsList(){
        return getListOfComments().size();
    }
}
