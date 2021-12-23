package com.template.elements.modals.vendor;

import com.template.elements.commonElements.HtmlElement;
import com.template.elements.modals.BaseModal;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface AddNewBrandModal extends BaseModal {
    @FindBy(".//div[./label]//input")
    HtmlElement brandName();

    @FindBy("//div[@role='presentation']//div[text()='Add a Brand']")
    HtmlElement addBrandOption();

    @FindBy("//button[./span[text()='Continue']]")
    HtmlElement continueButton();

    @FindBy("//div[contains(@class,'error')]/following-sibling::p")
    HtmlElement brandValidationError();
}
