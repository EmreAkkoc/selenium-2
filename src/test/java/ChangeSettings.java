import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;

import java.io.IOException;


public class ChangeSettings extends MainPage {
    private final By changeNameButton = By.xpath("//*[@id=\"content-wrapper\"]/div/div[2]/div[2]/div[1]/div[3]/a");
    private final By nameTextBox = By.xpath("//*[@id=\"change_user_name_form_name\"]");
    private final By saveNameButton = By.xpath("//*[@id=\"new_change_user_name_form\"]/div[2]/input");

    private final By changeTimeZoneButton = By.xpath("//*[@id=\"content-wrapper\"]/div/div[2]/div[2]/div[5]/div[3]/a");
    private final By changeTimeZoneDropDown = By.xpath("//*[@id=\"new_change_user_time_zone_form\"]/div[1]/div/div/button");
    private final By timeZone = By.xpath("//*[@id=\"new_change_user_time_zone_form\"]/div[1]/div/div/div/ul/li[302]/a");
    private final By timeZoneSaveButton = By.xpath("//*[@id=\"new_change_user_time_zone_form\"]/div[2]/input");

    public ChangeSettings(WebDriver driver) throws IOException {
        super(driver);
        this.login(driver);
    }

    public void changeName(){
        this.waitAndReturnElement(changeNameButton).click();
        this.waitAndReturnElement(nameTextBox).clear();
        this.waitAndReturnElement(nameTextBox).sendKeys("EMRE AKKOC");
        this.waitAndReturnElement(saveNameButton).click();
    }

    public void changeTimeZone(){
        this.waitAndReturnElement(changeTimeZoneButton).click();
        this.waitAndReturnElement(changeTimeZoneDropDown).click();
        this.waitAndReturnElement(timeZone).click();
        this.waitAndReturnElement(timeZoneSaveButton).click();

    }
}
