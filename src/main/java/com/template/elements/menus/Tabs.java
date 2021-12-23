package com.template.elements.menus;

import com.template.elements.commonElements.HtmlElement;
import com.template.pages.BasePage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Tabs extends BasePage {
    @FindBy("//div[@class='MuiTabs-flexContainer']/button[.//*[text()='Shipping Origins']]")
    HtmlElement shippingOriginsTab(); //TOD refactor, add default methods

    @FindBy("//div[@class='MuiTabs-flexContainer']/button[.//*[text()='Brand Primary Information']]")
    HtmlElement brandInformationTab();

    @FindBy("//div[@class='MuiTabs-flexContainer']/button[.//*[text()='Shipping Methods']]")
    HtmlElement shippingMethodsTab();

    @FindBy("//div[@class='MuiTabs-flexContainer']/button[.//*[text()='Inventory & Returns']]")
    HtmlElement inventoryAndReturnsTab();

    @FindBy("//div[@class='MuiTabs-flexContainer']/button[.//*[text()='Message Templates']]")
    HtmlElement messageTemplatesTab();

}
