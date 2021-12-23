package com.template.pages.designerPages;

import com.template.elements.commonElements.HtmlElement;
import com.template.pages.BasePage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface DesignerDashboardPage extends BasePage {

    @FindBy("//*[text()='Designer Dashboard Page']")
    HtmlElement designerDashboardTitle();
}
