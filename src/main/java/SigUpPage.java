import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SigUpPage {
    private WebDriver driver;

    public SigUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailField = By.cssSelector("input#register_form_mail_input");
    private By userNameField = By.cssSelector("input#register_form_username_input");
    private By passwordField = By.cssSelector("input#register_form_password_input");
    private By genderDropDown = By.cssSelector("select#register_form_gender_input");
    private String genderDropDownOption = "//select[@id='register_form_gender_input']/option[text()='%s']";
    private By ageDropDown = By.cssSelector("select#register_form_age_input");
    private String ageDropDownOption = "//select[@id='register_form_age_input']/option[text()='%s']";
    private By registerButton = By.cssSelector("button#register_form_submit");
    private String errorByText = "//label[@class='unlogged-label' and text()='%s']";

    public SigUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);

        return this;
    }

    public SigUpPage typeUserName(String userName) {
        driver.findElement(userNameField).sendKeys(userName);

        return this;
    }

    public SigUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);

        return this;
    }

    public SigUpPage setGender(String gender) {
        driver.findElement(genderDropDown).click();
        new WebDriverWait(driver,5).until(visibilityOfElementLocated(
            By.xpath(String.format(genderDropDownOption, gender))
        )).click();

        return this;
    }

    public SigUpPage setAge(String age) {
        driver.findElement(ageDropDown).click();
        new WebDriverWait(driver,5).until(visibilityOfElementLocated(
            By.xpath(String.format(ageDropDownOption, age))
        )).click();

        return this;
    }

    public void clickSignUpButton() {
        driver.findElement(registerButton).click();
    }

    public List<WebElement> getErrors() {
        return driver.findElements(errorByText)
    }

    public String getErrorByNumber(int number) {
        return getErrors().get(number - 1).getText();
    }

    public boolean isErrorVisible(String message) {
        return driver.findElements(By.xpath(String message(errorByText, message))).size() > 0 &&;
    }
}
