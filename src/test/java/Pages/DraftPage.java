package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftPage {

    private WebDriver driver;

    @FindBy(css = "a.fid-6")
    private WebElement draftEmaisButton;


    public DraftPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkSentEmails(String Theme) {
        this.draftEmaisButton.click();
        driver.findElement(By.xpath("//span[text()='" + Theme + "']"));

    }

}
