package com.template.pages.vendorPages.brandSettingsPages;

import com.template.elements.commonElements.HtmlElement;
import com.template.elements.menus.Tabs;
import com.template.pages.BasePage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface BrandPrimaryInformationPage extends BasePage, Tabs {
    @FindBy("//button[.//span[text()='EDIT']]")
    HtmlElement editButton();

    @FindBy("//div[text()='Brand Type']/following-sibling::div")
    HtmlElement tradeType();

    @FindBy("//div[text()='Legal Name']/following-sibling::div")
    HtmlElement legalName();

    @FindBy("//div[text()='Federal EIN']/following-sibling::div")
    HtmlElement federalNumber();

    @FindBy("//div[text()='Address']/following-sibling::div")
    HtmlElement address();

    @FindBy("//div[text()='Phone']/following-sibling::div")
    HtmlElement phone();

    @FindBy("//div[text()='Email']/following-sibling::div")
    HtmlElement email();

    @FindBy("//div[text()='Website']/following-sibling::div")
    HtmlElement website();

    @FindBy("//div[text()='Instagram']/following-sibling::div/a")
    HtmlElement instagram();


}
