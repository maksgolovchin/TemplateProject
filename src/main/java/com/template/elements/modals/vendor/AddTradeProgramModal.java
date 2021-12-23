package com.template.elements.modals.vendor;

import com.template.elements.commonElements.HtmlElement;
import com.template.elements.modals.BaseModal;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface AddTradeProgramModal extends BaseModal {
    @FindBy("//input[@name='openingOrder' and not(@tabindex)]")
    HtmlElement openingOrder();

    @FindBy("//input[@name='name' and not(@tabindex)]")
    HtmlElement tradeProgramName();

    @FindBy("//input[@name='minimumSpendPerYear' and not(@tabindex)]")
    HtmlElement minimumSpendPerYear();

    @FindBy("//textarea[@name='description']")
    HtmlElement description();

    @FindBy("//input[@name='discountPercentage' and not(@tabindex)]")
    HtmlElement discountFromHighestPrice();

    @FindBy("//button[.//span[text()='Save Trade Program']]")
    HtmlElement saveTradeProgram();

    @FindBy("//button[.//span[text()='Update trade program']]")
    HtmlElement updateTradeProgram();


}
