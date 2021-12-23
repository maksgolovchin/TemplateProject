package com.template.pages.vendorPages;

import com.template.elements.blocks.PaginationBlock;
import com.template.elements.blocks.SearchBlock;
import com.template.elements.blocks.SortingBlock;
import com.template.elements.blocks.VendorClientRow;
import com.template.elements.commonElements.HtmlElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.WebPage;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface ClientsPage extends WebPage, PaginationBlock, SearchBlock, SortingBlock {
    @FindBy("//img[contains(@src,'empty-clients')]")
    HtmlElement emptyClientsImage();

    @FindBy("//div[@role='row' and @data-rowindex]")
    ElementsCollection<VendorClientRow> vendorRows();

    @FindBy("//p[text()='Let’s bring more attention to your brand! ']")
    HtmlElement emptyClientsLabel();

    @FindBy("//img[contains(@src,'empty-search')]")
    HtmlElement noResultsFoundImage();

    @FindBy("//p[text()='No results were found for your search. ']")
    HtmlElement noResultsFoundLabel();
}
