
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class MultiplePages extends MainPage {

    String pages[] ={
            "https://id.unity.com/en/account/edit",
            "https://id.unity.com/en/privacy/edit",
            "https://id.unity.com/en/security",
            "https://id.unity.com/en/subscriptions",
            "https://id.unity.com/en/redeem_products/new"
    };

    public MultiplePages(WebDriver driver) throws IOException {
        super(driver);
        this.login(this.driver);
    }
    public void multiplePageTestFromArray(){

        for(String page:pages){
            this.driver.get(page);
            System.out.println(this.driver.getTitle());
        }
    }





}
