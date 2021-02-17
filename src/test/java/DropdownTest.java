import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest {

    protected static String BASE_URL = "http://the-internet.herokuapp.com/";

    WebDriver driver;

    WebElement taskThreeUrl;
    Select dropdownListUrl;
    List<WebElement> optionsList;
    WebElement option;


    @BeforeMethod
    private void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.setHeadless(true);
        driver = new ChromeDriver(option);
        driver.get(BASE_URL);
        taskThreeUrl = driver.findElement(By.xpath("//a[text()=\"Dropdown\"]"));
        taskThreeUrl.click();
        dropdownListUrl = new Select(driver.findElement(By.id("dropdown")));
        optionsList  = dropdownListUrl.getOptions();

    }

    @Test
    public void selectingTheFirstItem() {
        WebElement firstItem = driver.findElement(By.xpath("//option[@value='1']"));
        firstItem.click();
        Assert.assertEquals(firstItem.getAttribute("text"), "Option 1", "First item isn't selected");
    }

    @Test
    public void selectingTheSecondItem() {
        optionsList.get(2).click();
        option = dropdownListUrl.getFirstSelectedOption();
        Assert.assertEquals(option.getText(), "Option 2", "Second item isn't selected");
    }


    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        driver.quit();
    }
}




