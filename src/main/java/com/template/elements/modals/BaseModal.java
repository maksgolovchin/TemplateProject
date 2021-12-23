package com.template.elements.modals;

import com.template.elements.commonElements.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface BaseModal extends AtlasWebElement<BaseModal> {
    @FindBy(".//button[contains(@class,'close')]")
    HtmlElement closeModal();

    @FindBy(".//button[.//span[text()='{{ buttonName }}']]")
    HtmlElement button(@Param("buttonName") String buttonName);

    @FindBy(".//h2")
    HtmlElement title();
}
