package com.template.elements.blocks;

import com.template.elements.commonElements.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface VendorClientRow extends AtlasWebElement<VendorClientRow> {
    @FindBy(".//div[@data-field='designFirm.name']//a/div/div[2]/div")
    HtmlElement name();

    @FindBy("./div//button")
    HtmlElement sendMessage();

    @FindBy(".//div[@data-field='isSourcedFromCora']")
    HtmlElement source();

    @FindBy(".//div[@data-field='approvalDate']")
    HtmlElement approvalDate();

}
