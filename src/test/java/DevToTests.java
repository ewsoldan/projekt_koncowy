import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DevToTests {

    private WebDriver driver;
    public String baseURL = "https://dev.to/";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Seleniumdrivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(baseURL);

    }

    @Test

    public void Test1(){

        String currentURL = driver.getCurrentUrl();
        assertTrue("The current url isn't dev.to",baseURL.equals(currentURL));


    }

    @Test

    public void Test2() throws InterruptedException {
        WebElement week = driver.findElement(By.xpath("//*[@id=\"on-page-nav-controls\"]/div/nav/a[2]"));
        week.click();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String currentURL = driver.getCurrentUrl();
        assertTrue("The current url isn't dev.to",currentURL.equals("https://dev.to/top/week/"));

        //assertEquals("Czy przekierowalo na strone https://dev.to/top/week", "https://dev.to/top/week", currentURL);

    }
}
