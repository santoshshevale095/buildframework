package pageObjects;

import absractComponent.abstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends abstractComponent {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmail;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement pwd;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement Submit;


    public void LoginFlow(String email, String password) {

        loginEmail.sendKeys(email);
        pwd.sendKeys(password);
        Submit.click();
    }
}