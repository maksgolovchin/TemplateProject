package com.template.elements.blocks;

import com.template.elements.commonElements.HtmlElement;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.Keys;

public interface SearchBlock extends AtlasWebElement<SearchBlock> {

    @FindBy("//button[.//span[contains(@class,'icon-search')]]")
    HtmlElement searchIcon();

    @FindBy("//button[.//span[contains(@class,'icon-search')]]/following-sibling::div//input[not(@tabindex)]")
    HtmlElement searchInput();

    default void search(String name) {
        searchIcon().click();
        searchInput().sendKeys(name + Keys.ENTER);
    }
}
