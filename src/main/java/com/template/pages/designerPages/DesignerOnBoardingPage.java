package com.template.pages.designerPages;

import com.template.elements.commonElements.HtmlElement;
import com.template.pages.BasePage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface DesignerOnBoardingPage extends BasePage {


    @FindBy("//input[@name='parentCompanyLegalName' and not(@tabindex)]")
    HtmlElement designFirmLegalName();

    @FindBy("//input[@name='parentCompanyAddress.zipCode' and not(@tabindex)]")
    HtmlElement legalCompanyAddressZipCode();

    @FindBy("//input[@name='parentCompanyAddress.streetAddress1' and not(@tabindex)]")
    HtmlElement legalCompanyOfficeAddress();

    @FindBy("//input[@name='parentCompanyAddress.city' and not(@tabindex)]")
    HtmlElement legalCompanyCity();

    @FindBy("//ul[@role='listbox']/li[text()='{{ state }}']")
    HtmlElement stateOption(@Param("state") String state);

    @FindBy("//input[@type='file' and not(@tabindex)]")
    HtmlElement firmLogo();

    @FindBy("//input[@name='name' and not(@tabindex)]")
    HtmlElement firmName();

    @FindBy("//input[@name='firmAddress.zipCode' and not(@tabindex)]")
    HtmlElement firmZipCode();

    @FindBy("//input[@name='firmAddress.streetAddress1' and not(@tabindex)]")
    HtmlElement firmAddress();

    @FindBy("//input[@name='firmAddress.city' and not(@tabindex)]")
    HtmlElement firmCity();

    @FindBy("//div[contains(@id,'firmAddress.regionId')]")
    HtmlElement firmState();

    @FindBy("//input[@name='phone' and not(@tabindex)]")
    HtmlElement firmPhone();

    @FindBy("//label[text()='Firm Office Phone']/..//img")
    HtmlElement firmPhoneCountryPicker();

    @FindBy("//ul/li[not(@tabindex='-1')]/p[contains(text(),'{{ country }}')]")
    HtmlElement firmPhoneCountryOption(@Param("country") String country);

    @FindBy("//input[@name='email' and not(@tabindex)]")
    HtmlElement firmEmail();

}
