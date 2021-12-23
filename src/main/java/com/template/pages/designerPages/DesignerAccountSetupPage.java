package com.template.pages.designerPages;

import com.template.elements.commonElements.Checkbox;
import com.template.elements.commonElements.HtmlElement;
import com.template.pages.BasePage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface DesignerAccountSetupPage extends BasePage {
    @FindBy("//input[@name='firstName' and not(@tabindex)]")
    HtmlElement firstName();

    @FindBy("//input[@name='lastName' and not(@tabindex)]")
    HtmlElement lastName();

    @FindBy("//input[@name='password' and not(@tabindex)]")
    HtmlElement password();

    @FindBy("//input[@name='workTitle' and not(@tabindex)]")
    HtmlElement workTitle();

    @FindBy("//input[@name='email' and not(@tabindex)]")
    HtmlElement email();

    @FindBy("//input[@name='mobilePhone' and not(@tabindex)]")
    HtmlElement phone();

    @FindBy("//input[@name='agreedToTermsAndConditions']")
    Checkbox agreement();

    @FindBy("//button[./span[text()='Set up account']]")
    HtmlElement submit();

}
