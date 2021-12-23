package com.template.pages.vendorPages;

import com.template.elements.commonElements.HtmlElement;
import com.template.pages.BasePage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface LoginPage extends BasePage {

    @FindBy("//a[contains(text(),'Sign In')]")
    HtmlElement signInWithRegularEmail();

    @FindBy("//input[@type='text']")
    HtmlElement emailInput();

    @FindBy("//input[@type='password' and not(@tabindex)]")
    HtmlElement passwordInput();

    @FindBy("//button[@type='submit']")
    HtmlElement submitButton();

    @FindBy("//a[text()='sign up']")
    HtmlElement signUp();

    @FindBy("//div[@style]/p")
    HtmlElement appVersion();

    @FindBy("//a[text()='Forgot Password?']")
    HtmlElement forgotPassword();

    @FindBy("//h1[text()='Create a New Password']/..//input")
    HtmlElement newPasswordInput();

    @FindBy("//a[text()='claim your brand']")
    HtmlElement claimYourBrand();

    @FindBy("//*[text()='Check Your Inbox']")
    HtmlElement checkYourInbox();

    @FindBy("//h6")
    HtmlElement requestedEmail();

    @FindBy("//div[./div/div/input[@type='password']]/following-sibling::div/p")
    HtmlElement wrongPasswordMessage();

    @FindBy("(//img[@id='sh9img'])[1]")
    HtmlElement button();

    @FindBy("//img[@data-post_id='366815']")
    HtmlElement elementsada();

    @FindBy("//div[@class='sh9key']")
    HtmlElement key();

    @FindBy("//div[@class='recaptcha-checkbox-spinner-overlay']")
    HtmlElement captcha();

    @FindBy("//iframe[@title='reCAPTCHA']")
    HtmlElement captchaFrame();
}
