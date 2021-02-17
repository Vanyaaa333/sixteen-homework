import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxesTest {

    protected static String BASE_URL = "http://the-internet.herokuapp.com/";

    WebDriver driver;

    WebElement taskTwoUrl;
    List<WebElement> checkboxesUrl;
    WebElement bottomDeleteUrl;


    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);
        driver = new ChromeDriver(option);
        driver.get(BASE_URL);
        taskTwoUrl = driver.findElement(By.xpath("//a[text()=\"Checkboxes\"]"));
        taskTwoUrl.click();
        checkboxesUrl = driver.findElements(By.cssSelector("[type=checkbox]"));


    }

    @Test
    public void uncheckedFirstBoxTest() {
        Assert.assertEquals(checkboxesUrl.get(0).isEnabled(), true, "First box isn't unchecked");
    }

    @Test
    public void checkedFirstBoxTest(){
        checkboxesUrl.get(0).click();
        Assert.assertEquals(checkboxesUrl.get(0).isSelected(),true,"First box isn't checked");
    }

    @Test
    public void checkedSecondBoxTest(){
        Assert.assertEquals(checkboxesUrl.get(1).isSelected(),true,"Second box isn't checked");
    }

    @Test
    public void uncheckedSecondBoxTest() {
        checkboxesUrl.get(1).click();
        Assert.assertEquals(checkboxesUrl.get(1).isEnabled(), true, "Second box isn't unchecked");
    }


    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        driver.quit();
    }
}

