package com.template.elements.modals.vendor;

import com.template.elements.commonElements.HtmlElement;
import com.template.elements.modals.BaseModal;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface EditMyProfileModal extends BaseModal {
    @FindBy(".//input[@name='firstName' and not(@tabindex)]")
    HtmlElement firstName();

    @FindBy(".//input[@name='lastName' and not(@tabindex)]")
    HtmlElement lastName();

    @FindBy(".//input[@name='workTitle' and not(@tabindex)]")
    HtmlElement workTitle();

    @FindBy(".//input[@name='employer' and not(@tabindex)]")
    HtmlElement employer();

    @FindBy(".//input[@name='mobilePhone' and not(@tabindex)]")
    HtmlElement phoneNumber();

    @FindBy("(.//div/ul[@role='menu'])[2]/li[1]//p")
    HtmlElement selectedCountry();

    @FindBy(".//div[./following-sibling::p]/img")
    HtmlElement countryPickerButton();

    @FindBy(".//button[./*[text()='Save']]")
    HtmlElement save();
}

