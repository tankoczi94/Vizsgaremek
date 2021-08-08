import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ForumPage {
    private WebDriver driver;
    private By header = By.xpath("//*[@id=\"navilast\"]//b");
    private By pageButtons = By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a");
    private By topics = By.xpath("//*[@id=\"content1col\"]/tbody/tr[contains(@class,'tl_elem_')]");
    private By subjectOfTopics = By.xpath("//*[@id=\"content1col\"]/tbody/tr[@class]/td[contains(@class,'tle_subject')]/a");
    private By jumpToLastPageButton = By.xpath("//td[@id='maintd']/form[1]//img[@alt='>>']");
    private By jumpToNextPageButton = By.xpath("//td[@id='maintd']/form[1]//img[@alt='10>']");
    private By actualPage = By.xpath("//td[@id='maintd']/form[1]//b");

    public ForumPage(WebDriver driver){
        this.driver = driver;
    }
    public String[] listData(){
        int i =0;
        List<WebElement> subjects = driver.findElements(subjectOfTopics);
        String[] subjectsarr = new String[subjects.size()];
        for (WebElement element: subjects){
            subjectsarr[i]=(element.getText()+", ");
            i++;
        }
        return subjectsarr;
    }
    public int scrollThroughTopics(int scrolls){
        int lastPage = 0;
        int actualPageNumber = 0;
        driver.findElement(jumpToLastPageButton).click();
        lastPage = Integer
                .parseInt(driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/b"))
                        .getText());
        if(scrolls>=lastPage){
            driver.findElement(jumpToLastPageButton).click();
            actualPageNumber=Integer.parseInt(driver.findElement(actualPage).getText());
        }else{
            for (int i = 0; i < scrolls; i++) {
                driver.findElement(jumpToNextPageButton).click();
            }
            actualPageNumber=Integer.parseInt(driver.findElement(actualPage).getText());
        }
        return actualPageNumber;
    }
}
