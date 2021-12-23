package com.template.elements.blocks;

import com.template.elements.commonElements.HtmlElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

import static com.template.matchers.WebElementMatchers.isDisplayed;


public interface PaginationBlock {
    @FindBy("//div[contains(text(),'Items per page')]")
    HtmlElement itemsPerPagePicker();

    @FindBy("//li[text()='{{ option }}']")
    HtmlElement itemsPerPageOption(@Param("option") String option);

    @FindBy("//input[@inputmode='numeric']")
    HtmlElement paginationPageInput();

    @FindBy("//button[@aria-label='Go to next page']")
    HtmlElement paginationNextPage();

    @FindBy("//button[@aria-label='Go to previous page']")
    HtmlElement paginationPreviousPage();

    default void selectItemsPerPage(int number) {
        itemsPerPagePicker().click();
        itemsPerPageOption(String.valueOf(number)).waitUntil(isDisplayed()).click();
    }

    default void clickNextPage() {
        paginationNextPage().waitUntil(isDisplayed()).click();
    }

    default void clickPreviousPage() {
        paginationPreviousPage().waitUntil(isDisplayed()).click();
    }

}
