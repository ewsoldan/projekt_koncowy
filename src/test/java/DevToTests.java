import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DevToTests {

    private WebDriver driver;
    public String baseURL = "https://dev.to/";

    public void HighlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Seleniumdrivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(baseURL);

    }

    @Test

    public void Test1() {

        String currentURL = driver.getCurrentUrl();
        assertTrue("The current url isn't dev.to", baseURL.equals(currentURL));


    }

    @Test

   public void Test2() {
        WebElement week = driver.findElement(By.xpath("//*[@id=\"on-page-nav-controls\"]/div/nav/a[2]"));
        week.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe("https://dev.to/top/week"));
        String nowyURL = driver.getCurrentUrl();
        assertTrue("The current url isn't dev.to",nowyURL.equals("https://dev.to/top/week"));



    }

    @Test

    public void Test3() throws InterruptedException {
        WebElement week = driver.findElement(By.xpath("//*[@id=\"on-page-nav-controls\"]/div/nav/a[2]"));
        HighlightElement(week);
        week.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe("https://dev.to/top/week"));
        WebElement firstlinktitle = driver.findElement(By.cssSelector(".crayons-story__title > a"));
        HighlightElement(firstlinktitle);
        String linktofirstpost = firstlinktitle.getAttribute("href");
        WebElement pierwszy = driver.findElement(By.className("crayons-story__title"));
        HighlightElement(pierwszy);
        pierwszy.click();
        wait.until(ExpectedConditions.urlToBe(linktofirstpost));
        String currenturl = driver.getCurrentUrl();
        assertTrue(linktofirstpost.equals(currenturl));

    }
}
