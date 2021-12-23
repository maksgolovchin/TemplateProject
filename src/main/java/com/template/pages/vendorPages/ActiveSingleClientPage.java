package com.template.pages.vendorPages;

import com.template.elements.commonElements.HtmlElement;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ActiveSingleClientPage extends WebPage {

    @FindBy("//div[text()='Sales Territory']/following-sibling::div/span")
    HtmlElement salesTerritory();

    @FindBy("//div[text()='Status']/following-sibling::div//span")
    HtmlElement status();

    @FindBy("//div[text()='Trade Program']/following-sibling::div/a")
    HtmlElement tradeProgram();

    @FindBy("//div[text()='Urgency']/following-sibling::div")
    HtmlElement urgency();

    @FindBy("//div[text()='Source']/following-sibling::div")
    HtmlElement source();

    @FindBy("//div[text()='Focus(es)']/following-sibling::div")
    HtmlElement focuses();

    @FindBy("//h2")
    HtmlElement firmName();


}
