import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;



public class AddRemoveElementsTest {

    protected static String BASE_URL = "http://the-internet.herokuapp.com/";

    WebDriver driver;

    WebElement taskOneUrl;
    WebElement bottomAddUrl;
    WebElement bottomDeleteUrl;


    @BeforeMethod
    private void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);
        driver = new ChromeDriver(option);
        driver.get(BASE_URL);
        taskOneUrl = driver.findElement(By.xpath("//a[text()=\"Add/Remove Elements\"]"));
        taskOneUrl.click();
        bottomAddUrl = driver.findElement(By.xpath("//button[@onclick=\"addElement()\"]"));

    }

    @Test
    public void addRemoveElementsTest(){
        bottomAddUrl.click();
        bottomAddUrl.click();
        bottomDeleteUrl = driver.findElement(By.xpath("//button[text()=\"Delete\"]"));
        bottomDeleteUrl.click();
        Assert.assertEquals(driver.findElements(By.xpath("//button[text()=\"Delete\"]")).size(),1,"Element isn't added or removed");
    }


    @AfterMethod(alwaysRun = true)
    private void tearDown(){
        driver.quit();
    }

}
