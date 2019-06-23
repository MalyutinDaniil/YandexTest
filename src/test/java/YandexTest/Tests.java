package YandexTest;

import Pages.DraftPage;
import Pages.HomePage;
import Pages.SentEmails;
import Pages.WritePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Tests {

    private WebDriver driver;


    String LOGIN = "";
    String PASSWORD = "";
    String TO = "";
    String THEME = UUID.randomUUID().toString();
    String SUBJECT = "Письмо";


    @BeforeMethod
    public void beforetest() {
        System.setProperty("webdriver.chrome.driver", "src\\resoursec\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void AfterMethod() {
        driver.close();
        driver.quit();
    }


    @Test

    public void SendAndCheck() {
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.LogIn(LOGIN, PASSWORD);
        WritePage writePage = PageFactory.initElements(driver, WritePage.class);
        writePage.writeEmail(TO, THEME, SUBJECT);
        writePage.sendEmail();
        SentEmails SentEmails = PageFactory.initElements(driver, SentEmails.class);
        SentEmails.checkSentEmails(THEME);

    }


    @Test

    public void WriteAndCheckMail() {

        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.LogIn(LOGIN, PASSWORD);
        WritePage writePage = PageFactory.initElements(driver, WritePage.class);
        writePage.writeEmail(TO, THEME, SUBJECT);
        writePage.savedEmail();
        DraftPage DraftPage = PageFactory.initElements(driver, DraftPage.class);
        DraftPage.checkSentEmails(THEME);


    }


}
