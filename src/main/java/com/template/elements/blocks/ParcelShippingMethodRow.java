package com.template.elements.blocks;

import com.template.elements.commonElements.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ParcelShippingMethodRow extends AtlasWebElement<ParcelShippingMethodRow> {
    @FindBy("./td[@label='Shipping Method Nickname']/p")
    HtmlElement nickName();

    @FindBy("./td//button")
    HtmlElement actionsButton();

    @FindBy("//div[./ul/li[text()='Delete'] and not(contains(@style,'visibility: hidden;'))]/ul/li[text()='Delete']")
    HtmlElement deleteAction();

    @FindBy("//div[./ul/li[text()='Edit'] and not(contains(@style,'visibility: hidden;'))]/ul/li[text()='Edit']")
    HtmlElement editAction();

    @FindBy("./td[@label='Carrier']/p")
    HtmlElement carrier();

    @FindBy("./td[@label='Service Offered']/p")
    HtmlElement serviceOffered();

    @FindBy("./td[@label='Calculation Method (Internal use only)']/p")
    HtmlElement calculationMethod();

    @FindBy(".//input")
    HtmlElement defaultRadio();
}
