import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//fieldek az oldalon es methodok az interakciora, driver ide nem kell csak majd a testbe,
// framework csak az interakcio static minden

public class HomePage {
    private  WebDriver driver;
    private WebDriverWait wait;
    private  By emailField = By.xpath("//*[@id=\"indpl_login_box_180\"]/form/div[3]/div[2]/div[1]/input[1]");
    private  By passwordField = By.xpath("//*[@id=\"indpl_login_box_180\"]/form/div[3]/div[2]/div[1]/input[2]");
    private  By loginButton = By.xpath("//*[@id=\"indpl_login_box_180\"]/form/div[3]/div[2]/div[2]/input");
    private By privacyStatement = By.id("qc-cmp2-ui");
    private By headerOfPrivacyStatement = By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[1]/div/div/figure/h2");
    private By contentOfPrivacyStatement = By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[1]/div/div/div");
    private By acceptPrivacyStatementButton = By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]");
    private By wrongUserNameOrPasswordIndicator = By.xpath("//*[contains(@class,'indpl_err_box')]");
    private By logOutButton = By.className("ahigh");
    private By firstForumPageButton = By.xpath("//b[.='A Törzsasztal']");


    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    public  void writeToUserNameField(String username){
        driver.findElement(emailField).sendKeys(username);
    }
    public void writeToPassWordField(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public TopicPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new TopicPage(driver);
    }
    public String getContentOfPrivacyStatement(){
        wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(privacyStatement)));
        String toReturn = "";
        toReturn += driver.findElement(headerOfPrivacyStatement).getText()+ "\n";
        toReturn += driver.findElement(contentOfPrivacyStatement).getText();
        return toReturn;
    }
    public void acceptPrivacyStatement(){
        wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(privacyStatement)));
        driver.findElement(acceptPrivacyStatementButton).click();
    }
    public String getWrongUserNameErrorMessage(){
        wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(wrongUserNameOrPasswordIndicator)));
        return driver.findElement(wrongUserNameOrPasswordIndicator).getText();
    }
    public LogOutPage logOut(){
        wait = new WebDriverWait(driver,5);
        WebElement logOutButtonWE = driver.findElement(logOutButton);
        wait.until(ExpectedConditions.visibilityOf(logOutButtonWE));
        logOutButtonWE.click();
        return new LogOutPage(driver);
    }
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public TopicPage logIn(){
        String data="";
        try {
            File file = new File("logincredentials.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                data += scanner.nextLine()+" ";
            }
        } catch (FileNotFoundException e) {
            System.err.println("There is no such file");
            e.printStackTrace();
        }
        String[] logincredentials = data.split(" ");
        acceptPrivacyStatement();
        writeToUserNameField(logincredentials[0]);
        writeToPassWordField(logincredentials[1]);
        clickLoginButton();
        return new TopicPage(driver);
    }
    public boolean isThereLogInPanel(){
        boolean isLoginPanel = false;
        if(driver.findElement(emailField).isDisplayed()){
            isLoginPanel = true;
        }
        return isLoginPanel;
    }
    public ForumPage clickFirstForumPageButton(){
        driver.findElement(firstForumPageButton).click();
        return new ForumPage(driver);
    }

}
