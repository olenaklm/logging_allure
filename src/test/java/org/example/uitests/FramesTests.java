package org.example.uitests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.example.uitests.browser.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class FramesTests extends BaseTests {
    private WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        goToPart("nested_frames");
        driver = WebDriverHolder.getInstance().getDriver();
    }

    @Test
    @Description("Test frame-bottom")
    public void switchToFrame() {
        driver.switchTo().frame("frame-bottom");

        String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body, "BOTTOM");

        driver.switchTo().defaultContent();

        List<WebElement> webElementList = driver.findElements(By.xpath("//frameset/frame"));
        Assert.assertEquals(webElementList.size(), 2);
    }

    @DataProvider
    public Object[][] createData() {
        return new Object[][]{
                {"LEFT", "frame-left"},
                {"MIDDLE", "frame-middle"},
                {"RIGHT", "frame-right"},
                {"BOTTOM", "frame-bottom"},
        };
    }

    @Test(dataProvider = "createData")
    @Severity(CRITICAL)
    public void switchToFrameUniversal(String expResult, String frameName) {

//        goToPart("nested_frames");

//        if (!expResult.equals("BOTTOM")) {
        if (!expResult.equals("BOTTOMMMMMM")) {
            driver.switchTo().frame("frame-top");
        }

        driver.switchTo().frame(frameName);


        String body = driver.findElement(By.xpath("//body")).getText();
//        Assert.assertEquals(body, expResult);
        Assert.assertEquals(body, "NOTHING");

        driver.switchTo().defaultContent();

        List<WebElement> webElementList = driver.findElements(By.xpath("//frameset/frame"));
        Assert.assertEquals(webElementList.size(), 2);

    }

}
