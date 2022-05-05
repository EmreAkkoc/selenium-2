import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Base64;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;

public class FileOperations extends MainPage {

    private final By editAvatarButton = By.xpath("//*[@id=\"user-panel\"]/div/div[1]/div[2]/div[4]/a");

   // private final By dropFileZone = By.xpath("//*[@id=\"drop-zone\"]");
    private final By avatarUploadZone = By.id("avatar-upload");
    private final By saveFileButton = By.xpath("//*[@id=\"content-wrapper\"]/div/div/div[2]/div[2]/button");

    public FileOperations(WebDriver driver) throws IOException {
        super(driver);
        this.login(this.driver);
    }

    // Load a file on the classpath as a resource using the ClassLoader.
    URL url  = getClass().getClassLoader().getResource("emre.jpeg");
    // Convert the URL into a URI.
    URI uri;
    {
        try {
            uri = url.toURI();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    // Load the file from the URI.
    File file = new File(uri);
    // Get the absolute path to the file.
    String path = file.getAbsolutePath();



    public void uploadFile() throws InterruptedException {
        this.waitAndReturnElement(userDropDown).click();
        this.waitAndReturnElement(editAvatarButton).click();
        //this.waitAndReturnElement(dropFileZone).click();
        this.executeJavascript("document.getElementById('avatar-upload').style.width='100%'");
        this.executeJavascript("document.getElementById('avatar-upload').style.height='100%'");
        this.executeJavascript("document.getElementById('avatar-upload').style.overflow='visible'");
        Thread.sleep(1500);
        this.waitAndReturnElement(avatarUploadZone).sendKeys(path);
        Thread.sleep(7000);
        this.waitAndReturnElement(saveFileButton).click();

    }



    private final By dashboardButtonBy = By.xpath("//*[@id=\"main-wrapper\"]/div[2]/nav/ul/li[4]/a");
    private final By reSignInButtonBy = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/div[4]/div[2]/button");
    //*[@id="root"]/div/div/div[2]/div[1]/div[4]/div[2]/button
    private final By devopsButton = By.xpath("//*[@id=\"root\"]/header/div/aside/div[1]/div[1]/section[2]/nav/a[2]");
    private final By datasetsButton = By.xpath("//*[@id=\"root\"]/header/div/aside/div[2]/nav/button[7]");
    private final By assetsButton = By.xpath("//*[@id=\"root\"]/header/div/aside/div[2]/nav/div[7]/div/div/nav/a[4]");
    private final By file1Button = By.xpath("//*[@id=\"root\"]/div/div/div[1]/div/div/div/div[1]/div/div[2]/div[2]/div[2]/button");
    private final By canvas1By = By.id("unity-canvas-1");
    private final By closeButtonBy = By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/button");





    public void downloadMultipleFilesToFolder(){

        this.waitAndReturnElement(dashboardButtonBy).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement reSignInButton = driver.findElement(By.xpath("//*[text()='Get started free']"));

        reSignInButton.click();

        //this.waitAndReturnElement(reSignInButtonBy).click();
        this.login(this.driver);

        this.waitAndReturnElement(devopsButton).click();
        this.waitAndReturnElement(datasetsButton).click();
        this.waitAndReturnElement(assetsButton).click();
        this.waitAndReturnElement(file1Button).click();

        WebElement canvas =  this.waitAndReturnElement(canvas1By) ;

        String v = canvas.getAttribute("src");
        // creating URL
        URL i;

        {
            try {
                i = new URL(v);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        //having BufferedImage with ImageIO class
        BufferedImage s;

        {
            try {
                s = ImageIO.read(i);
                // save image in location with .png extension
                ImageIO.write(s, "png", new File("resources/1.png"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        this.waitAndReturnElement(closeButtonBy).click();
    }





}
