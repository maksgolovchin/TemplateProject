package com.template.elements.menus;

import com.template.elements.commonElements.HtmlElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface UserMenu {
    @FindBy("//div[@data-qa='data-qa-user-menu']//button[contains(@class,'MuiButtonBase-root')]")
    HtmlElement openProfileDropDown();

    @FindBy("//li[@role='menuitem']//span[text()='My Profile']")
    HtmlElement myProfile();

    @FindBy("//li[@role='menuitem']//span[text()='Sign Out']")
    HtmlElement signOut();

    @FindBy("//div[@data-qa='data-qa-user-menu']//p")
    HtmlElement profileName();
}
