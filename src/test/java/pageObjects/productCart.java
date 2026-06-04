package pageObjects;

import absractComponent.abstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productCart extends abstractComponent {

    WebDriver driver;

    public productCart(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(css=".product-image-wrapper")
    List<WebElement> products;

    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
    WebElement ContinueShoping;

    @FindBy(css = "a[href='/view_cart']")
    WebElement Cart;


    public int getProductCount(){

        return products.size();
    }

    public void getProductNames(){

    for(WebElement product :products) {

        String name = product.findElement(By.tagName("p"))
                        .getText();

        System.out.println("Checking : " + name);
        if (name.equalsIgnoreCase("Sleeveless Dress")){

            WebElement addToCartBtn =
                    product.findElement(By.xpath(".//a[text()='Add to cart']"));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", addToCartBtn);

            waitForElementToAppear(ContinueShoping);
            ContinueShoping.click();

            break;
        }

    }


        Cart.click();

    }


}
