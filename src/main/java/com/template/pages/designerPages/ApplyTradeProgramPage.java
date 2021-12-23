package com.template.pages.designerPages;

import com.template.elements.commonElements.Checkbox;
import com.template.elements.commonElements.HtmlElement;
import com.template.pages.BasePage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface ApplyTradeProgramPage extends BasePage {

    @FindBy("//input[@name='existingAccount' and @value='false']")
    Checkbox newClientRadio();

    @FindBy("//input[@name='existingAccount' and @value='true']")
    Checkbox existingClientRadio();

    @FindBy("//label[.//div[text()='{{ name }}']]//input")
    Checkbox urgency(@Param("name") String name);

    @FindBy("//input[@name='reviewedInformation']")
    Checkbox confirmCheckbox();

    @FindBy("//button[./span[text()='submit application']]")
    HtmlElement submitApplication();


}
