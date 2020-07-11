import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DevToTests {

    private WebDriver driver;
    public String baseURL;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Seleniumdrivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get(baseURL);

    }
}
