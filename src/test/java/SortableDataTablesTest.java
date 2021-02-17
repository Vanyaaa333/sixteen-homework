import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;



public class SortableDataTablesTest {

    protected static String BASE_URL = "http://the-internet.herokuapp.com/";

    WebDriver driver;

    WebElement taskFiveUrl;
    WebElement firstTableFirstElement;
    WebElement firstTableSecondElement;
    WebElement secondTableFirstElement;
    WebElement secondTableSecondElement;


    @BeforeMethod
    private void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);
        driver = new ChromeDriver(option);
        driver.get(BASE_URL);
        taskFiveUrl = driver.findElement(By.xpath("//a[text()=\"Sortable Data Tables\"]"));
        taskFiveUrl.click();
    }

    @Test
    public void getTableElements(){
        firstTableFirstElement = driver.findElement(By.xpath("//table[@id=\"table1\"]//tr[1]//td[1]"));
        Assert.assertEquals(firstTableFirstElement.getText(),"Smith","True first element didn't got by first table");
        firstTableSecondElement = driver.findElement(By.xpath("//table[@id=\"table1\"]//tr[1]//td[2]"));
        Assert.assertEquals(firstTableSecondElement.getText(),"John","True second element didn't got by first table");
        secondTableFirstElement = driver.findElement(By.xpath("//table[@id=\"table2\"]//tr[1]//td[1]"));
        Assert.assertEquals(secondTableFirstElement.getText(),"Smith","True first element didn't got by second table");
        secondTableSecondElement = driver.findElement(By.xpath("//table[@id=\"table2\"]//tr[1]//td[2]"));
        Assert.assertEquals(secondTableSecondElement.getText(),"John","True second element didn't got by second table");
    }


    @AfterMethod(alwaysRun = true)
    private void tearDown(){
        driver.quit();
    }

}


