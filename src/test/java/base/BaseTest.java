package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseTest {

 protected WebDriver driver;



    public WebDriver browserlaunch(String browser) throws IOException {



        if (browser.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();
            ChromeOptions options =new ChromeOptions();
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

        System.out.println("Screenshot Method Called");
        TakesScreenshot ts = (TakesScreenshot) driver;

        java.io.File source = ts.getScreenshotAs(OutputType.FILE);

        String filePath = System.getProperty("user.dir")
                + "//reports//" + testCaseName + ".png";
        System.out.println(filePath);

        FileUtils.copyFile(source, new File(filePath));

        return filePath;
    }


    @Parameters("browser")
    @BeforeMethod
    public void launch(@Optional("chrome") String browser)
            throws IOException {

        System.out.println("Browser = " + browser);
        
        driver = browserlaunch(browser);
        driver.get("https://automationexercise.com");
    }



    @AfterMethod
   public void teardown() {
        driver.quit();

    }

    public WebDriver getDriver() {
        return driver;
    }


}

