import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;


public class NotificationMessagesTest {

    protected static String BASE_URL = "http://the-internet.herokuapp.com/";

    WebDriver driver;

    WebElement taskSeventhUrl;
    WebElement bottomNotificationMassage;
    WebElement notificationMassage;


    @BeforeMethod
    private void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);
        driver = new ChromeDriver(option);
        driver.get(BASE_URL);
        taskSeventhUrl = driver.findElement(By.xpath("//a[text()=\"Notification Messages\"]"));
        taskSeventhUrl.click();
        bottomNotificationMassage = driver.findElement(By.xpath("//a[text()=\"Click here\"]"));

    }

    @Test
    public void getTableElements(){
        bottomNotificationMassage.click();
        notificationMassage = driver.findElement(By.xpath("//div[@id=\"flash\"]"));
        String actualResult = notificationMassage.getText();
        boolean isTextRight = actualResult.contains("Action successful") || actualResult.contains("Action unsuccesful, please try again");
            Assert.assertTrue(isTextRight,"Notification text isn't right");
    }


    @AfterMethod(alwaysRun = true)
    private void tearDown(){
        driver.quit();
    }

}

