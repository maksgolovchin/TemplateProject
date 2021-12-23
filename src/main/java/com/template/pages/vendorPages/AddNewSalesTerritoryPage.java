package com.template.pages.vendorPages;

import com.template.elements.commonElements.Checkbox;
import com.template.elements.commonElements.HtmlElement;
import com.template.elements.modals.BaseModal;
import com.template.pages.BasePage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface AddNewSalesTerritoryPage extends BasePage {
    @FindBy("//input[@name='name' and not(@tabindex)]")
    HtmlElement nameInput();

    @FindBy("//textarea[not(@tabindex)]")
    HtmlElement description();

    @FindBy("//input[@name='typeId' and @value='1']")
    HtmlElement allowSalesRadio();

    @FindBy("//input[@name='typeId' and @value='2']")
    HtmlElement optOutRadio();

    @FindBy("(//button[./span[text()='Save']])[1]")
    HtmlElement saveSaleTerritory();

    @FindBy("//button[.//span[text()='Delete Sales Territory']]")
    HtmlElement deleteSaleTerritory();

    @FindBy("//div[contains(@class,'MuiDialog-paper')]//button[./span[text()='Delete Sales Territory']]")
    HtmlElement confirmDeletion();

    @FindBy("//button[.//span[text()='Delete Sales Territory']]")
    HtmlElement deleteSalesTerritoryButton();

    @FindBy("//div[contains(@class,'MuiDialog-paper')]")
    BaseModal deleteSalesTerritoryModal();

    @FindBy("//div[contains(@class,'MuiDialog-paper')]")
    BaseModal leaveWithoutSavingModal();

    @FindBy("//input[@type='checkbox' and @name='assignAll']")
    Checkbox assignAllCheckBox();

    @FindBy("//button[./span[text()='Confirm']]")
    HtmlElement confirmAssignAll();
}
