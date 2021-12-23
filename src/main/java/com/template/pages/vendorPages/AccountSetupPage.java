package com.template.pages.vendorPages;

import com.template.elements.commonElements.Checkbox;
import com.template.elements.commonElements.HtmlElement;
import com.template.pages.BasePage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface AccountSetupPage extends BasePage {
    @FindBy("//input[@name='firstName' and not(@tabindex)]")
    HtmlElement firstName();

    @FindBy("//input[@name='lastName' and not(@tabindex)]")
    HtmlElement lastName();

    @FindBy("//input[@name='workTitle' and not(@tabindex)]")
    HtmlElement workTitle();

    @FindBy("//input[@name='email' and not(@tabindex)]")
    HtmlElement email();

    @FindBy("//input[@name='mobilePhone' and not(@tabindex)]")
    HtmlElement phone();

    @FindBy("(//div/ul[@role='menu'])[2]/li[1]//p")
    HtmlElement selectedCountry();

    @FindBy("//div[./following-sibling::p]/img")
    HtmlElement countryPickerButton();

    @FindBy("//input[@name='password' and not(@tabindex)]")
    HtmlElement password();

    @FindBy("//input[@name='agreedToTermsAndConditions' and not(@tabindex)]")
    Checkbox agreement();

    @FindBy("//button[@type='submit']")
    HtmlElement submit();

    @FindBy("//*[text()='We just need to gather a bit more information about your company. Follow these 4 easy steps.']")
    HtmlElement onBoardingDescription();

    @FindBy("//p[text()='You must agree to terms of service.']")
    HtmlElement agreementShouldBeCheckedError();
}
