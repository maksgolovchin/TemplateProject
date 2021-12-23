package com.template.elements.commonElements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.fail;

public interface Select extends AtlasWebElement<Select> {

    @FindBy(".//option")
    ElementsCollection<HtmlElement> options();

    default void select(String text) {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(this);
        try {
            select.selectByVisibleText(text);
        } catch (NoSuchElementException e) {
            List<String> options = select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
            fail("Item with text " + text + " is missing. Presented values : " + options);
        }
    }

    default void deselectAll() {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(this);
        select.deselectAll();
    }

    default void selectByValue(String text) {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(this);
        try {
            select.selectByValue(text);
        } catch (NoSuchElementException e) {
            fail("Item with value " + text + " is missing");
        }

    }

    default ElementsCollection<String> getOptions() {
        return options().extract(WebElement::getText).extract(String::trim);
    }

    default void shouldNotHaveOption(String text) {
        options().filter(i -> i.getText().equals(text)).should("Option " + text + " is displayed",
                hasSize(0));
    }

    default void shouldHaveOption(String text) {
        options().filter(i -> i.getText().equals(text)).should("Option " + text + " is displayed",
                hasSize(1));
    }

    default String getSelectedOption() {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(this);
        return select.getFirstSelectedOption().getText();
    }

    default void shouldHaveValueSelected(String expected) {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(this);
        assertThat(select.getFirstSelectedOption().getText().trim(), equalTo(expected));
    }

    default void shouldHaveAllOptionsSelected() {
        org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(this);
        assertThat(select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList()),
                equalTo(options().should(hasSize(greaterThan(0))).extract(WebElement::getText)));
    }
}
