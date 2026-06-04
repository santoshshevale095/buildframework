package pageObjects;

import absractComponent.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class payments extends abstractComponent {

    WebDriver driver;
    public payments(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }


    @FindBy(xpath = "//input[@name='name_on_card']")
    WebElement memberName;

    @FindBy(xpath = "//input[@name='card_number']")
    WebElement CardNumber;

    @FindBy(xpath = "//input[@name='cvc']")
    WebElement cvcNumber;

    @FindBy(xpath = "//input[@name='expiry_month']")
    WebElement month;

    @FindBy(xpath = "//input[@name='expiry_year']")
    WebElement year;

    @FindBy(id = "submit")
    WebElement finalSubmit;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/p")
    WebElement finaltext;

   String actualMessage = "Congratulations! Your order has been confirmed!";


    public void paymentDetails(Map<String,String>data){

        memberName.sendKeys(data.get("cardName"));
        CardNumber.sendKeys(data.get("cardNumber"));
        cvcNumber.sendKeys(data.get("cvc"));
        month.sendKeys(data.get("month"));
        year.sendKeys(data.get("year"));
        finalSubmit.click();
      System.out.println(finaltext.getText());
        Assert.assertTrue(actualMessage.contains("Congratulations! Your order has been confirmed!"));



    }



}

