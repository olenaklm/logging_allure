package org.example.uitests;

import org.example.uitests.browser.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        // driver = new ChromeDriver();
        //
        //  System.setProperty("browser", "chrome");
        driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
        System.out.println("before class");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("before method");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("after method");
    }


    @AfterClass
    public void afterClass() {
        if (driver != null)
            driver.quit();
        System.out.println("after class");
    }


}
