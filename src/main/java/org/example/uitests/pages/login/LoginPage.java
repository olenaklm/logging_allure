package org.example.uitests.pages.login;

import org.example.uitests.pages.BasePage;
import org.example.uitests.pages.main.MainPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginPage extends BasePage {
    private final static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

    @FindBy(id = "username")
    private WebElement userInput;

    @FindBy(css ="#password")
    private WebElement passwordInput;

    @FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
    private WebElement loginButton;

    @FindBy(id = "flash")
    private WebElement errorMessage;

    public LoginPage() {
        super();
    }

    private LoginPage setUserName(String userName) {
        return enterValueToWebElement(userInput, userName);
    }

    private LoginPage setUserPassword(String userPassword) {
        return enterValueToWebElement(passwordInput, userPassword);
    }

    private LoginPage enterValueToWebElement(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
        return this;
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    public MainPage login(String userName, String userPassword) {
        LOGGER.info("Start check successful login.");
        setUserName(userName)
                .setUserPassword(userPassword)
                .clickLoginButton();
        LOGGER.info("Click login button");
        LOGGER.debug("Debug check successful login.");
        LOGGER.info("Finish check successful login.");
        return new MainPage();
    }

    public LoginPage unsuccessfulLogin(String userName, String userPassword) {
        setUserName(userName)
                .setUserPassword(userPassword + "1")
                .clickLoginButton();
        return new LoginPage();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
