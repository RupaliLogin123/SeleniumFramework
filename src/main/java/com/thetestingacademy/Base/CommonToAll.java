package com.thetestingacademy.Base;

import com.thetestingacademy.Driver.DriverManager;
import com.thetestingacademy.Util.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.time.Duration;

import static com.thetestingacademy.Driver.DriverManager.getDriver;

public class CommonToAll {
    public void openVWOLoginURL(String url) {
        try {
            switch (url){
                case "qa":
                    getDriver().get(PropertyReader.readKey("qa_url"));
                    break;
                case "preprod":
                    getDriver().get(PropertyReader.readKey("uat_url"));
                    break;
                default:
                    getDriver().get(PropertyReader.readKey("url"));
                    break;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickElement(By by){
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by){
        by.click();
    }

    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement element, String key) {
        element.sendKeys(key);
    }



    // Waits

    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public WebElement getElement(By key) {
        return getDriver().findElement(key);
    }

    public WebElement getElement(WebElement element) {
        return element;
    }


}
