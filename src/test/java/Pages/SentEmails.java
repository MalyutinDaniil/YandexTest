package Pages;

import com.sun.org.apache.bcel.internal.ExceptionConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SentEmails {

    private WebDriver driver;


    @FindBy(css= "a.fid-4")
    private WebElement SentEmaisButton;




    public SentEmails(WebDriver driver){
        this.driver=driver;
    }

    public void checkSentEmails(String Theme){
        this.SentEmaisButton.click();
        driver.findElement(By.xpath("//span[text()='" + Theme + "']"));


    }
}
