package com.template.steps.common;

import com.template.pages.BasePage;
import com.template.steps.vendorSteps.BrandProfileSteps;
import com.template.steps.vendorSteps.ClientsSteps;
import com.template.utlis.softAssertions.MultipleStepSoftAssertion;
import com.template.webdriver.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static com.template.matchers.WebElementMatchers.*;
import static org.hamcrest.Matchers.hasSize;

public abstract class BasePageSteps<T extends BasePageSteps<T>> extends WebDriverSteps {
    int diffSize = 40;

    public BasePageSteps(WebDriverManager driverManager, String windowHandle) {
        super(driverManager, windowHandle);
    }

    protected abstract T self();

    @Step
    public T waitForPageLoad() {
        onBasePage().loader().waitUntil(isNotDisplayed(), 10);
        return self();
    }

    public void confirmAlert() {
        driverManager.getDriver().switchTo().alert().accept();
    }

    private void hideAllProgressBars() {
        for (int a = 1; a <= onBasePage().progressBars().size(); a++)
            executor.executeScript("arguments[0].style.visibility = 'hidden';",
                    driverManager.getDriver().findElement(By.xpath("(//div[@role='progressbar'])[" + a + "]")));

    }


    @Step
    public T refreshPage() {
        driverManager.getDriver().navigate().refresh();
        return self();
    }

    @Step
    public T shouldNotSeeContactUs() {
        onBasePage().contactUs().should(hasSize(1));
        return self();
    }

    @Step
    public T setBrowserSize(int width, int height) {
        driverManager.getDriver().manage().window().setSize(new Dimension(width, height));
        return self();
    }


    @Step
    public T shouldSeeErrorMessage(String text) {
        onBasePage().baseErrorMessage().should(hasText(text), 5);
        return self();
    }

    @Step
    public T assertAll(MultipleStepSoftAssertion assertion) {
        assertion.assertAll();
        return self();
    }

    @Step
    public ClientsSteps openClients() {
        click(onBasePage().leftSideMenu().leftSideMenuItem("Clients"));
        return new ClientsSteps(driverManager, mainWindowHandle);
    }

    @Step
    public BrandProfileSteps openBrandProfile() {
        click(onBasePage().leftSideMenu().leftSideMenuItem("Brand Profile"));
        return new BrandProfileSteps(driverManager, mainWindowHandle);
    }

    @Step
    public T shouldSeeFieldValidationAlertMessage(String text) {
        onBasePage().baseErrorMessage().should(isDisplayed()).should(hasText(text));
        return self();
    }

    public T logToConsole(String text) {
        sendToConsole(text);
        return self();
    }

    private BasePage onBasePage() {
        return on(BasePage.class);
    }

}
