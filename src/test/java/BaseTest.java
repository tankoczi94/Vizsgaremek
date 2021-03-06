//alap test innen orokli a tobbi kulon oldal teszt osztalya a drivert meg a sessiont,
// kell egy indulo oldal pl homepage

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;
    protected static int serial = 0;
    @BeforeEach
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://forum.index.hu/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        homePage = new HomePage(driver);


    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    public static void main(String[] args) {
        BaseTest test = new BaseTest();
        test.setUp();
    }
}
