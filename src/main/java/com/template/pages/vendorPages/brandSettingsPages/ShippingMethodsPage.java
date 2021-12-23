package com.template.pages.vendorPages.brandSettingsPages;

import com.template.elements.blocks.ParcelShippingMethodRow;
import com.template.elements.commonElements.HtmlElement;
import com.template.elements.menus.Tabs;
import com.template.pages.BasePage;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface ShippingMethodsPage extends BasePage, Tabs {

    @FindBy("//button[.//span[text()='Add Parcel Shipping Method']]")
    HtmlElement addParcelShippingMethod();

    @FindBy("//button[.//span[text()='Add Freight Shipping Method']]")
    HtmlElement addFreightShippingMethod();

    @FindBy("//table[@data-qa='data-qa-parcel-shipping-methods']//tbody//tr")
    ElementsCollection<ParcelShippingMethodRow> parcelShippingMethodsRows();

    @FindBy("//label[.//div[text()='{{ value }}']]//input")
    HtmlElement defaultParcelMethodRadio(@Param("value") String value);


}
