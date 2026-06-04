package pageObjects;


import absractComponent.abstractComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends abstractComponent {

    WebDriver driver;

    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);


    }

    @FindBy(xpath="//a[contains(text(),'Signup')]")
    WebElement loginbutton;


    public LoginPage  Clickloginbutton(){

        waitForElementToAppear(loginbutton);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", loginbutton);




        return new LoginPage(driver);
    }


}
