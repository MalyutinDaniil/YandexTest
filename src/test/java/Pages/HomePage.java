package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {


    private WebDriver driver;
    private static String HOME_URL = "https://yandex.ru";

    @FindBy(css = "a.desk-notif-card__login-enter-expanded")
    private WebElement EnterToEmail;

    @FindBy(id = "passp-field-login")
    private WebElement Login;

    @FindBy(id = "passp-field-passwd")
    private WebElement Password;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement Submit;


    public HomePage(WebDriver driver) {

        this.driver = driver;
        driver.get(HOME_URL);
    }


    public void LogIn(String login, String password) {
        EnterToEmail.click();
        Login.clear();
        Login.sendKeys(login);
        Submit.click();
        Password.clear();
        Password.sendKeys(password);
        Submit.click();
    }


}
