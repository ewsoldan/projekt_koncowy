package selenium.automated.PageObjects;

import org.openqa.selenium.WebDriver;

public class DevToMainPage {
    String url = "https://dev.to/";
    WebDriver driver;

    public DevToMainPage(WebDriver driver){

        this.driver = driver;
        driver.get(url);

    }

}
