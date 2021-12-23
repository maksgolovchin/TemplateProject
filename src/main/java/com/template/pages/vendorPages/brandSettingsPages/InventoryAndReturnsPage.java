package com.template.pages.vendorPages.brandSettingsPages;

import com.template.elements.commonElements.HtmlElement;
import com.template.elements.menus.Tabs;
import com.template.pages.BasePage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface InventoryAndReturnsPage extends BasePage, Tabs {

    @FindBy("//button[./span[text()='Discard Changes']]")
    HtmlElement discardChanges();

    @FindBy("//input[@name='allowReturns' and @value='1']")
    HtmlElement allowReturnsRadio();

    @FindBy("//input[@name='allowReturns' and @value='2']")
    HtmlElement doNotAllowReturnsRadio();

    @FindBy("//input[@name='daysForReturns' and not(@tabindex)]")
    HtmlElement daysToReturnInput();

    @FindBy("//input[@name='stockedItemFee' and @value='1']")
    HtmlElement chargeFeeForStockedRadio();

    @FindBy("//input[@name='stockedItemFee' and @value='2']")
    HtmlElement doNotChargeForStockedRadio();

    @FindBy("//input[@name='stockedItemFeeValue' and not(@tabindex)]")
    HtmlElement stockedChargeInput();

    @FindBy("//div[@id='mui-component-select-stockedItemFeeTypeId']")
    HtmlElement stockedFeeTypePicker();

    @FindBy("//input[@name='designerReturnCharge' and @value='1']")
    HtmlElement chargeFeeForShippingRadio();

    @FindBy("//input[@name='designerReturnCharge' and @value='2']")
    HtmlElement doNotChargeForShippingRadio();

    @FindBy("//input[@name='designerReturnChargeValue' and not(@tabindex)]")
    HtmlElement chargeFeeForShippingInput();

    @FindBy("//div[@id='mui-component-select-designerReturnChargeTypeId']")
    HtmlElement shippingFeeTypePicker();

    @FindBy("//ul[@role='listbox']/li[text()='{{ value }}']")
    HtmlElement listBoxValue(@Param("value") String value);

    @FindBy("//textarea[@name='stockedProductPolicy']")
    HtmlElement shippingAndReturnsPolicy();

    @FindBy("//textarea[@name='madeToOrderPolicy']")
    HtmlElement madeToOrderReturnPolicy();

    @FindBy("//button[./span[text()='Save']]")
    HtmlElement save();

    @FindBy("//div[@role='tooltip']")
    HtmlElement errorTooltip();

    @FindBy("//input[@name='stockedItemFeeValue' and not(@tabindex)]/..//span//div")
    HtmlElement stockingFeeErrorIcon();

    @FindBy("//input[@name='daysForReturns' and not(@tabindex)]/..//span//div")
    HtmlElement daysToReturnErrorIcon();

    @FindBy("//input[@name='designerReturnChargeValue' and not(@tabindex)]/..//span//div")
    HtmlElement chargeFeeForShippingErrorIcon();


}
