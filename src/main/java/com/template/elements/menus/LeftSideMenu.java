package com.template.elements.menus;

import com.template.elements.commonElements.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface LeftSideMenu extends AtlasWebElement<LeftSideMenu> {
    @FindBy(".//ul//li//p[text()='{{ itemName }}']")
    HtmlElement leftSideMenuItem(@Param("itemName") String itemName);

    @FindBy(".//button[contains(@class,'MuiButtonBase-root') and not(.//span[contains(@class,'icon-arrow-left-rounded')])]")
    HtmlElement openCompanyDropDown();

    @FindBy(".//ul[contains(@class,'MuiList-root')]//li//span[text()='{{ companyName }}']")
    HtmlElement selectCompany(@Param("companyName") String companyName);

    @FindBy("//div[@data-qa='data-qa-sidebar']/div[2]/div[2]//p")
    HtmlElement selectedBrandName();

    @FindBy(".//ul//li//p")
    ElementsCollection<HtmlElement> leftSideMenuItems();

}
