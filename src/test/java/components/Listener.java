package components;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportNG;


public class Listener extends BaseTest implements ITestListener {


    ExtentReports extent = ExtentReportNG.getReportObject();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {


        System.out.println("Test Failed : "
                + result.getMethod().getMethodName());

        try {

            BaseTest test = (BaseTest) result.getInstance();

            WebDriver driver = test.getDriver();

            test.getScreenshot(
                    result.getMethod().getMethodName(),
                    driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }

}