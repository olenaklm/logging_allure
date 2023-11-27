package org.example.uitests.pages.main;

import org.example.uitests.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
 //   @FindBy(xpath = "//*[@id='content']/div/h4")
    @FindBy(id = "flash")
    private WebElement successfulMessage;

    public MainPage() {
        super();
    }

    public String getSuccessMessageText() {
        return successfulMessage.getText();
    }
}
