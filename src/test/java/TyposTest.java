import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


public class TyposTest {

    protected static String BASE_URL = "http://the-internet.herokuapp.com/";

    WebDriver driver;

    WebElement taskSixthUrl;
    List<WebElement> text;


    @BeforeMethod
    private void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);
        driver = new ChromeDriver(option);
        driver.get(BASE_URL);
        taskSixthUrl = driver.findElement(By.xpath("//a[text()=\"Typos\"]"));
        taskSixthUrl.click();
        text = driver.findElements(By.tagName("p"));

    }

    @Test
    public void getTableElements(){
        Assert.assertEquals(text.get(0).getText(),"This example demonstrates a typo being introduced. It does it randomly on each page load.","True second element didn't got by second table");
        Assert.assertEquals(text.get(1).getText(),"Sometimes you'll see a typo, other times you won,t.","True second element didn't got by second table");
    }


    @AfterMethod(alwaysRun = true)
    private void tearDown(){
        driver.quit();
    }

}
