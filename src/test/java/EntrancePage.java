import org.openqa.selenium.WebDriver;

import java.io.IOException;


class EntrancePage extends PageBase {
/*
    private final By footerBy = By.className("footer-block");
    private final By searchBarToggleBy = By.xpath("//a[@class='search-bar-toggler']/i");
    private final By searchBarBy = By.name("search");
    */
    public EntrancePage(WebDriver driver) throws IOException {
        super(driver);
        this.driver.get("https://www.unity.com/");
    }    

    public void getTitle(){
        System.out.println(driver.getTitle());
    }
    /*
    public String getFooterText() {

        return this.waitAndReturnElement(footerBy).getText();
    }
    
    public SearchResultPage search(String searchQuery) {
        this.waitAndReturnElement(searchBarToggleBy).click();
        
        this.waitAndReturnElement(searchBarBy).sendKeys(searchQuery + "\n");
        return new SearchResultPage(this.driver);
    }*/
}
