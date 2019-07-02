package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WritePage {

    private WebDriver driver;

    private WebDriverWait wait;

    @FindBy(css = "a.js-main-action-compose")
    private WebElement NewEmail;

    @FindBy(name = "to")
    private WebElement To;

    @FindBy(name = "subj-17fa45b673e44d2ae53c0e70d6b310c326405983")
    private WebElement Theme;

    @FindBy(css = "textarea.cke_contents_ltr")
    private WebElement Subject;


    @FindBy(css = "button.js-send-button")
    private WebElement SendButton;

    @FindBy(css = "div.mail-Done-Title")
    private WebElement Sent;

    @FindBy(css = "div.ns-view-compose-cancel-button")
    private WebElement Close;

    @FindBy(css = "button._nb-small-action-button")
    private WebElement CloseAndSaveButton;


    public WritePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void writeEmail(String To, String Theme, String Text) {
        this.NewEmail.click();

        this.To.sendKeys(To);

        this.Theme.sendKeys(Theme);

        this.Subject.sendKeys(Text);

    }

    public void sendEmail() {
        SendButton.click();
        wait.until(ExpectedConditions.visibilityOf(Sent));

    }

    public void savedEmail() {
        Close.click();
        CloseAndSaveButton.click();


    }


}
