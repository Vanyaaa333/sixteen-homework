import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;



public class InputTest {

    protected static String BASE_URL = "http://the-internet.herokuapp.com/";

    WebDriver driver;

    WebElement taskFourUrl;
    WebElement inputUrl;


    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);
        driver = new ChromeDriver(option);
        driver.get(BASE_URL);
        taskFourUrl = driver.findElement(By.xpath("//a[text()=\"Inputs\"]"));
        taskFourUrl.click();
        inputUrl = driver.findElement(By.tagName("input"));

    }

    @Test
    public void inputLettersTest() {
        inputUrl.sendKeys("x");
        Assert.assertEquals(inputUrl.getAttribute("value"), "", "Numeric line can't use letters");
    }

    @Test
    public void inputSymbolsTest() {
        inputUrl.sendKeys("#");
        Assert.assertEquals(inputUrl.getAttribute("value"), "", "Numeric line can't use symbols");
    }

    @Test
    public void inputSpaceTest() {
        inputUrl.sendKeys(" ");
        Assert.assertEquals(inputUrl.getAttribute("value"), "", "Numeric line can't use spaces");
    }

    @Test
    public void inputRationalNumbersWithArrowUpTest() {
        inputUrl.sendKeys("2,5");
        inputUrl.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(inputUrl.getAttribute("value"), "3,5", "Arrow up isn't increase rational numbers");
    }

    @Test
    public void inputRationalNumbersWithArrowDownTest() {
        inputUrl.sendKeys("2,5");
        inputUrl.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(inputUrl.getAttribute("value"), "1,5", "Arrow up isn't decrease rational numbers");
    }

    @Test
    public void inputZeroWithArrowUpTest() {
        inputUrl.sendKeys("0");
        inputUrl.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(inputUrl.getAttribute("value"), "1", "Arrow up isn't increase zero");
    }

    @Test
    public void inputZeroWithArrowDownTest() {
        inputUrl.sendKeys("0");
        inputUrl.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(inputUrl.getAttribute("value"), "-1", "Arrow up isn't decrease zero");
    }

    @Test
    public void inputIrrationalNumbersWithArrowUpTest() {
        inputUrl.sendKeys("e");
        inputUrl.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(inputUrl.getAttribute("value"), Math.exp(1)+1, "Arrow up isn't increase irrational numbers");
    }

    @Test
    public void inputIrrationalNumbersWithArrowDownTest() {
        inputUrl.sendKeys("e");
        inputUrl.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(inputUrl.getAttribute("value"), Math.exp(1)-1, "Arrow up isn't decrease irrational numbers");
    }

    @Test
    public void inputNegativeNumbersWithArrowUpTest() {
        inputUrl.sendKeys("-2");
        inputUrl.sendKeys(Keys.ARROW_UP);
        Assert.assertEquals(inputUrl.getAttribute("value"), "-1", "Arrow up isn't increase negative numbers");
    }

    @Test
    public void inputNegativeNumbersWithArrowDownTest() {
        inputUrl.sendKeys("-2");
        inputUrl.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals(inputUrl.getAttribute("value"), "-3", "Arrow up isn't decrease negative numbers");
    }

    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        driver.quit();
    }
}

