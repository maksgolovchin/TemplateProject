package com.template.pages;

import com.template.elements.commonElements.HtmlElement;
import com.template.elements.menus.Footer;
import com.template.elements.menus.LeftSideMenu;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface BasePage extends WebPage, Footer {

    @FindBy("//img[@alt='Loading']")
    HtmlElement loader();

    @FindBy("//div[@role='progressbar']")
    HtmlElement progressBar();

    @FindBy("//div[@data-qa='data-qa-sidebar']")
    LeftSideMenu leftSideMenu();

    @FindBy("//div[@role='progressbar']")
    ElementsCollection<HtmlElement> progressBars();

    @FindBy("//*[text()='{{ message }}']")
    HtmlElement successMessage(@Param("message") String message);

    @FindBy("//h1[text()='Congrats!']")
    HtmlElement congrats();

    @FindBy("//div[contains(@data-qa,'data-qa-snackbar-alert')]")
    HtmlElement snackBarAlert();

    @FindBy("//div[@data-qa='data-qa-alert data-qa-alert-error']")
    HtmlElement baseErrorMessage();

    @FindBy("//*[text()='{{ text }}']")
    HtmlElement anyText(@Param("text") String text);

    @FindBy("(//p)[1]")
    HtmlElement version();
}
