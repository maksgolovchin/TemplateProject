package com.template.elements.blocks;

import com.template.elements.commonElements.Checkbox;
import com.template.elements.commonElements.HtmlElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

import java.util.List;

import static com.template.matchers.WebElementMatchers.hasAttribute;
import static com.template.matchers.WebElementMatchers.isDisplayed;
import static org.hamcrest.Matchers.not;


public interface SortingBlock {
    @FindBy("//div[@id='mui-component-select-ordering']")
    HtmlElement sortingPicker();

    @FindBy("//li[text()='{{ option }}']")
    HtmlElement sortingOption(@Param("option") String option);

    @FindBy("//div[@id='mui-component-select-sales_territory_ids']")
    HtmlElement salesTerritoryPicker();

    @FindBy("//li[.//div[text()='{{ option }}']]/span[1]//input")
    Checkbox option(@Param("option") String option);

    @FindBy("div[@id='mui-component-select-status']")
    HtmlElement statusPicker();

    default void selectSorting(String sorting) {
        sortingPicker().waitUntil(not(hasAttribute("aria-disabled", "true"))).click();
        sortingOption(sorting).waitUntil(isDisplayed()).click();

    }

    default void selectSalesTerritories(List<String> territories) {
        salesTerritoryPicker().waitUntil(not(hasAttribute("aria-disabled", "true"))).click();
        for (String territory : territories) {
            option(territory).setChecked(true);
        }
    }

    default void selectStatus(List<String> statuses) {
        statusPicker().waitUntil(not(hasAttribute("aria-disabled", "true"))).click();
        for (String territory : statuses)
            option(territory).setChecked(true);
    }

    default void deselectStatus(List<String> statuses) {
        statusPicker().waitUntil(not(hasAttribute("aria-disabled", "true"))).click();
        for (String status : statuses)
            option(status).setChecked(false);
    }
}
