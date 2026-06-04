package components;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import components.retry;


public class retry implements IRetryAnalyzer {

    int counter = 0;
    int retryLimit = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (counter < retryLimit) {
            counter++;
            return true;
        }
        return false;
    }



}
