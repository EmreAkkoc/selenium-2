import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class SeleniumTest {
    public WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();


        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }



    //-get page title
    @Test
    public void testMainPage() throws IOException {
        EntrancePage entrancePage = new EntrancePage(this.driver);
        entrancePage.getTitle();

    }






    //-get body text
    @Test
    public void testGetBodyText() throws IOException {
        PageBase pageBase = new PageBase(this.driver);
        pageBase.getBodyText();
    }


    //-fill simple form and send
    //- fill input (checkbox-remember me)
    @Test
    public void testLogin() throws IOException {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.login(this.driver);

    }


    // testing history going back and forward
    @Test
    public void testHistoryBackAndForward() throws IOException {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.login(this.driver);
        mainPage.historyBackAndForward(this.driver);
    }


    //-send form with user
    //-full input(text box-name field)
    @Test
    public void testChangeName() throws IOException {
        ChangeSettings changeSettings = new ChangeSettings(this.driver);
        changeSettings.changeName();
    }



    //-logout
    @Test
    public void testLogout() throws IOException {
        MainPage loginPage = new MainPage(this.driver);
        loginPage.logout(this.driver);
    }



    //-filling dropdown
    @Test
    public void testChangeTimeZone() throws IOException {
        ChangeSettings changeSettings = new ChangeSettings(this.driver);
        changeSettings.changeTimeZone();
    }




    //-testing multiple page navigation from array
    @Test
    public void testMultiplePageFromArray() throws IOException {
        MultiplePages multiplePages = new MultiplePages(this.driver);
        multiplePages.multiplePageTestFromArray();

    }



    // -upload file
    // -javascript execution
    @Test
    public void testFileUpload() throws InterruptedException, IOException {
        FileOperations fileOperations = new FileOperations(this.driver);
        fileOperations.uploadFile();
    }




    /* close but unity.com is not in possession of multiple downloadable files
    @Test
    public void testDownloadMultipleFilesToFolder(){
        FileOperations fileOperations = new FileOperations(this.driver);
        fileOperations.downloadMultipleFilesToFolder();
    }
    */














    /*@Test
    public void testSearch() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.getFooterText().contains("2021 ELTE Faculty of Informatics"));
               
        SearchResultPage searchResultPage = mainPage.search("Students");
        String bodyText = searchResultPage.getBodyText();
        Assert.assertTrue(bodyText.contains("found"));
        Assert.assertTrue(bodyText.contains("For Students"));
    }
    
    @Test
    public void testSearch2() {
        String[] searchQueries={"something","","xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"};  
        for(String searchQuery : searchQueries) {  
            MainPage mainPage = new MainPage(this.driver);
            SearchResultPage searchResultPage = mainPage.search(searchQuery);
            String bodyText = searchResultPage.getBodyText();
            Assert.assertTrue(bodyText.contains("found"));
        }  
    }

     */
    

    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
