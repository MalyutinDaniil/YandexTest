package YandexTest;

import Pages.DraftPage;
import Pages.HomePage;
import Pages.SentEmails;
import Pages.WritePage;
import Settings.Setup;
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

    Setup settings;
    String LOGIN;
    String PASSWORD;
    String TO;
    String THEME = UUID.randomUUID().toString();
    String BODDY = "Письмо";


    @BeforeMethod
    public void beforetest() {
        settings = new Setup();
        settings.getSetting();
        LOGIN = settings.LOGIN;
        PASSWORD = settings.PASSWORD;
        TO = settings.TO;
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
        writePage.writeEmail(TO, THEME, BODDY);
        writePage.sendEmail();
        SentEmails SentEmails = PageFactory.initElements(driver, SentEmails.class);
        SentEmails.checkSentEmails(THEME);

    }


    @Test

    public void WriteAndCheckMail() {

        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.LogIn(LOGIN, PASSWORD);
        WritePage writePage = PageFactory.initElements(driver, WritePage.class);
        writePage.writeEmail(TO, THEME, BODDY);
        writePage.savedEmail();
        DraftPage DraftPage = PageFactory.initElements(driver, DraftPage.class);
        DraftPage.checkSentEmails(THEME);


    }


}
