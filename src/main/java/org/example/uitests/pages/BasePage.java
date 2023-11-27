package org.example.uitests.pages;


import org.example.uitests.browser.WebDriverHolder;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
//    protected WebDriver driver;

    public BasePage() {
//        this.driver = driver;
        PageFactory.initElements(WebDriverHolder.getInstance().getDriver(), this);
//        WebDriverHolder.getInstance().getDriver();
    }

    public void sleep(long msec) throws InterruptedException {
        Thread.sleep(msec);
    }
}
