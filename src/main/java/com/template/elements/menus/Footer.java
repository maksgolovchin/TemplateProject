package com.template.elements.menus;

import com.template.elements.commonElements.HtmlElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface Footer {
    @FindBy("//div[@name='ContactUsButton]")
    HtmlElement contactUs();

    @FindBy("//div[@name='TwitterAccount']")
    HtmlElement twitter();

}
