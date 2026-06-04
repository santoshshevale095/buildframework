package pageObjects;

import absractComponent.abstractComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class proceedtoCheckout extends abstractComponent {

    WebDriver driver;

    public proceedtoCheckout(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


@FindBy(css = ".btn.btn-default.check_out")
    WebElement proceed;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    WebElement placeorder;


    public void checkout(){

        proceed.click();

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();",placeorder);


    }

}
