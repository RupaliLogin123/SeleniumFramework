package com.thetestingacademy.Page.Pagefactory;

import com.thetestingacademy.Base.CommonToAll;
import com.thetestingacademy.Util.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class LoginVWO_PF extends CommonToAll {
    WebDriver driver;

    public LoginVWO_PF(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Page Locators

    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;

    // Page Actions

    public String loginToVWOInvalidCreds() throws FileNotFoundException {
        enterInput(username, PropertyReader.readKey("invalid_username"));
        enterInput(password, PropertyReader.readKey("invalid_password"));
        clickElement(signButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return error_message.getText();
    }


}