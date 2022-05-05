
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;

import java.io.IOException;

public class MainPage extends PageBase{

    private final By usernameBy = By.xpath("//*[@id=\"conversations_create_session_form_email\"]");
    private final By passwordBy = By.xpath("//*[@id=\"conversations_create_session_form_password\"]");
    private final By signInButtonBy = By.xpath("//*[@id=\"new_conversations_create_session_form\"]/div[2]/div[2]/div/div[1]/div/div[1]");
    private final By rememberMeCheckBox = By.xpath("//*[@id=\"new_conversations_create_session_form\"]/div[2]/div[1]/div[3]/div/label");


    protected final By userDropDown = By.xpath("//*[@id=\"main-header\"]/div/div[2]/div[3]/a/i");
    private final By logoutButton = By.xpath("//*[@id=\"user-panel\"]/div/a[4]");

    /*
    WebElement usernameElement;
    WebElement passwordElement;
    WebElement signInButtonElement;

    */
    public MainPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver.get(config.getProperty("loginUrl"));
    }

    public void login(WebDriver driver)  {
        this.waitAndReturnElement(usernameBy).sendKeys(config.getProperty("username"));
        this.waitAndReturnElement(passwordBy).sendKeys(config.getProperty("password"));
        this.waitAndReturnElement(rememberMeCheckBox).click();
        this.waitAndReturnElement(rememberMeCheckBox).click();
        this.waitAndReturnElement(signInButtonBy).click();

    }

    public void logout(WebDriver driver){
        this.login(driver);
        this.waitAndReturnElement(userDropDown).click();
        this.waitAndReturnElement(logoutButton).click();
    }

    public void historyBackAndForward(WebDriver driver){
        this.driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.driver.navigate().forward();
    }
}
