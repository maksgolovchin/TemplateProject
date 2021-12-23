package com.template.steps.vendorSteps;

import com.template.pages.vendorPages.LoginPage;
import com.template.steps.common.BasePageSteps;
import com.template.webdriver.WebDriverManager;
import io.qameta.allure.Step;

import static com.template.matchers.WebElementMatchers.hasText;
import static com.template.matchers.WebElementMatchers.isDisplayed;

public class LoginSteps extends BasePageSteps<LoginSteps> {
    public LoginSteps(WebDriverManager driverManager, String windowHandle) {
        super(driverManager, windowHandle);
    }

    @Override
    protected LoginSteps self() {
        return this;
    }


    @Step
    public LoginSteps requestMagicLink(String email) {
        enterEmail(email);
        click(onLoginPage().submitButton());
        return this;
    }

    @Step
    public LoginSteps enterEmail(String email) {
        enterText(onLoginPage().emailInput().waitUntil(isDisplayed()), email);
        return this;
    }

    @Step
    public LoginSteps shouldSeeSuccessMagickLinkScreen(String email) {
        onLoginPage().requestedEmail().should(hasText(email));
        return this;
    }

    @Step
    public LoginSteps shouldSeeWrongPasswordMessage() {
        onLoginPage().wrongPasswordMessage().should(hasText(
                "Unfortunately, the email and password entered does not match our system's records." +
                          " Please try again or click Request a Magic Link " +
                          "to send an automatic login link to your email inbox."));
        return this;
    }

    @Step
    public DashboardSteps login(String email, String password) {
        clickLoginWithEmailAndPassword();
        enterEmail(email);
        enterPassword(password);
        click(onLoginPage().submitButton());
        return new DashboardSteps(driverManager, mainWindowHandle);
    }

    @Step
    public LoginSteps enterPassword(String password) {
        enterText(onLoginPage().passwordInput(), password);
        return this;
    }

    @Step
    public LoginSteps clickLoginWithEmailAndPassword() {
        click(onLoginPage().signInWithRegularEmail().waitUntil(isDisplayed(), 15));
        return this;
    }

    @Step
    public void requestPasswordReset(String email) {
        clickForgotPassword();
        enterEmail(email);
        click(onLoginPage().submitButton());
        onLoginPage().checkYourInbox().waitUntil(isDisplayed());
    }

    @Step
    public LoginSteps clickForgotPassword() {
        clickLoginWithEmailAndPassword();
        click(onLoginPage().forgotPassword().waitUntil(isDisplayed()));
        return this;
    }

    public String getVersion() {
        return onLoginPage().appVersion().waitUntil(isDisplayed()).getText();
    }

    @Step
    public LoginSteps shouldSeeSuccessResetPasswordScreen(String email) {
        onLoginPage().requestedEmail().should(hasText(email));
        return this;
    }

    private LoginPage onLoginPage() {
        return on(LoginPage.class);
    }
}
