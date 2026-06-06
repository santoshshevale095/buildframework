package tests;

import base.BaseTest;

import components.retry;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.*;
import utils.JsonDataReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;





@Listeners(components.Listener.class)
public class TestRun extends BaseTest {

    @DataProvider
    public Object[][] getData() throws IOException {

        JsonDataReader reader = new JsonDataReader();

        List<Map<String,String>> data = reader.getJsonData();
        return new Object[][]{
                {data.get(0)},
                {data.get(1)},

        };
    }

    @Test(dataProvider = "getData", retryAnalyzer = retry.class)
    public void PositiveLogIn(Map<String,String> data)
            throws IOException{

        LandingPage land = new LandingPage(driver);
       LoginPage log = land.Clickloginbutton();



        System.out.println("Checking : Blue Top - Jenkins Poll SCM Test");
        log.LoginFlow(
                data.get("email"),
                data.get("password")
        );

        //ProductCart
        productCart product = new productCart(driver);
        System.out.println(product.getProductCount());

        product.getProductNames();


        //ProceedCart

        proceedtoCheckout check = new proceedtoCheckout(driver);
        check.checkout();

        //Payments
        payments payment = new payments(driver);
        payment.paymentDetails(data);



    }

}
