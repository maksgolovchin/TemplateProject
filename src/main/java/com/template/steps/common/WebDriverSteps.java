package com.template.steps.common;

import com.template.elements.commonElements.HtmlElement;
import com.template.pages.BasePage;
import com.template.webdriver.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.atlas.webdriver.WebPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

import static com.template.matchers.WebElementMatchers.hasAttribute;
import static com.template.matchers.WebElementMatchers.isDisplayed;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.openqa.selenium.Keys.*;

public class WebDriverSteps {

    public WebDriverManager driverManager;
    protected String mainWindowHandle;
    protected JavascriptExecutor executor;
    protected Actions actions;

    WebDriverSteps(WebDriverManager driverManager, String windowHandle) {
        this.driverManager = driverManager;
        this.mainWindowHandle = windowHandle;
        this.executor = (JavascriptExecutor) driverManager.getDriver();
        this.actions = new Actions(driverManager.getDriver());
    }

    protected void sendToConsole(String text) {
        executor.executeScript("console.error(\"" + text + "\");");
    }


    protected void scrollBottom() {
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait(200);
    }

    protected void setElementHidden(WebElement element) {
        executor.executeScript("arguments[0].setAttribute('style','visibility: hidden')", element);

    }

    protected void setElementHeightToAuto(WebElement element) {
        executor.executeScript("arguments[0].setAttribute('style','height: auto')", element);
    }

    protected void setElementMaxHeightToAuto(WebElement element) {
        executor.executeScript("arguments[0].setAttribute('style','max-height: 1000%')", element);
    }

    protected void scrollToElement(WebElement element) {
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void scroll(WebElement rootElement, int height) {
        executor.executeScript("arguments[0].scrollTo(0," + height + ")", rootElement);
    }

    protected void scrollTop() {
        executor.executeScript("window.scrollTo(0, 0)");
        wait(200);
    }

    protected void enterText(WebElement element, CharSequence... text) {
        try {
            element.sendKeys(chord(CONTROL, "a"), DELETE);
        } catch (Exception ignored) {
        }
        element.sendKeys(text);
    }

    protected void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Attachment
    protected byte[] attachFile(File file) {
        try {
            return FileUtils.readFileToByteArray(file);
        } catch (IOException a) {
            return new byte[0];
        }
    }

    protected void click(WebElement element) {
        executor.executeScript("arguments[0].click();", element.findElement(By.xpath("self::*")));
    }

    protected void hover(WebElement element) {
        actions.moveToElement(element.findElement(By.xpath("self::*"))).perform();
    }

    protected void elementShouldBeDisabled(HtmlElement element) {
        element.should(isDisplayed()).should(hasAttribute("disabled", "true"));
    }

    protected void elementShouldBeEnabled(HtmlElement element) {
        element.should(isDisplayed()).should(hasAttribute("disabled", emptyOrNullString()));
    }

    private BasePage onBasePage() {
        return on(BasePage.class);
    }


    protected <T extends WebPage> T on(Class<T> pageClass) {
        return driverManager.getAtlas().create(driverManager.getDriver(), pageClass);
    }

}
