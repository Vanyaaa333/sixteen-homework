import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


public class HoversTest {

    protected static String BASE_URL = "http://the-internet.herokuapp.com/";

    WebDriver driver;

    WebElement taskEighthUrl;
    List<WebElement> usersUrl;
    List<WebElement> usersNameUrl;
    List<WebElement> viewProfileUserUrl;
    WebElement error;



    @BeforeMethod
    private void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);
        driver = new ChromeDriver(option);
        driver.get(BASE_URL);
        taskEighthUrl = driver.findElement(By.xpath("//a[text()=\"Hovers\"]"));
        taskEighthUrl.click();
        usersUrl = driver.findElements(By.xpath("//img[@src=\"/img/avatar-blank.jpg\"]"));
        usersNameUrl = driver.findElements(By.tagName("h5"));
        viewProfileUserUrl = driver.findElements(By.xpath("//a[text()=\"View profile\"]"));

    }

    @Test
    public void getFirstUserСhecks(){
        Actions builder = new Actions(driver);
        builder.moveToElement(usersUrl.get(0)).perform();
        Assert.assertEquals(usersNameUrl.get(0).getText(),"name: user1");
        builder.moveToElement(viewProfileUserUrl.get(0)).click().perform();
        error = driver.findElement(By.xpath("//*[text()=\"Not Found\"]"));
        Assert.assertEquals(error.getText(),"Not Found");
    }

    @Test
    public void getSecondUserСhecks(){
        Actions builder = new Actions(driver);
        builder.moveToElement(usersUrl.get(1)).perform();
        Assert.assertEquals(usersNameUrl.get(1).getText(),"name: user2");
        builder.moveToElement(viewProfileUserUrl.get(1)).click().perform();
        error = driver.findElement(By.xpath("//*[text()=\"Not Found\"]"));
        Assert.assertEquals(error.getText(),"Not Found");
    }

    @Test
    public void getThirdUserСhecks(){
        Actions builder = new Actions(driver);
        builder.moveToElement(usersUrl.get(2)).perform();
        Assert.assertEquals(usersNameUrl.get(2).getText(),"name: user3");
        builder.moveToElement(viewProfileUserUrl.get(2)).click().perform();
        error = driver.findElement(By.xpath("//*[text()=\"Not Found\"]"));
        Assert.assertEquals(error.getText(),"Not Found");
    }


    @AfterMethod(alwaysRun = true)
    private void tearDown(){
        driver.quit();
    }

}
