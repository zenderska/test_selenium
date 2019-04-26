import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class SignUpTest {
    WebDriver driver;
    SigUpPage page;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/Users/robert/Downloads/geckodriver 2");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.deezer.com/register");
    }

    @Test
    public void typeInvalidYear()   {
        page = new SignUpPage(driver);
        page.setGender("M")
                .setAge("7");
        Assert.assertTrue(page.isErrorVisible("Проверьте все поля."));
    }

    @After
    public void tearDown()  {
        driver.quit();
    }

}
