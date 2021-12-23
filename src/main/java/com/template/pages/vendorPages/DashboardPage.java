package com.template.pages.vendorPages;

import com.template.elements.commonElements.HtmlElement;
import com.template.pages.BasePage;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface DashboardPage extends BasePage {

    @FindBy("//h1[contains(text(),'Welcome,')]")
    HtmlElement welcomeMessage();

    @FindBy("//div[contains(@class,'MuiBox-root') and ./div/div[@class='react-swipeable-view-container']]")
    HtmlElement stepModal();

    @FindBy("//div[contains(@class,'MuiStepper-root')]//button")
    ElementsCollection<HtmlElement> stepSelectors();

    @FindBy("//button/span[text()='I am the only team member']")
    HtmlElement onlyOneTeamMemberButton();

    @FindBy("//button/span[contains(text(),'done editing sales territories')]")
    HtmlElement doneWithSalesTerritories();

    @FindBy("//div[./span[text()='Product Listings']]/following-sibling::div[./p[text()='Published']]/p[2]")
    HtmlElement publishedProducts();

    @FindBy("//div[./span[text()='Product Listings']]/following-sibling::div[./p[text()='Archived']]/p[2]")
    HtmlElement archivedProducts();

    @FindBy("//div[./span[text()='Sales']]/following-sibling::*")
    HtmlElement sales();

    @FindBy("//div[./span[text()='Trade Accounts']]/following-sibling::*")
    HtmlElement tradeAccounts();

    @FindBy("//div/p[text()='Saved Products']/following-sibling::*")
    HtmlElement savedProducts();

    @FindBy("//div/p[text()='Quoted Products']/following-sibling::*")
    HtmlElement quotedProducts();

    @FindBy("//div/p[text()='Ordered Products']/following-sibling::*")
    HtmlElement orderedProducts();

    @FindBy("//img[contains(@src,'empty-product-listings')]")
    HtmlElement emptyProductListingsImage();

    @FindBy("//img[contains(@src,'step_03')]")
    HtmlElement nothingToDoImage();

    @FindBy("//p[text()=' Work with Cora to promote your products.' and text()='No saved products, yet. ']")
    HtmlElement noSavedProductsTitle();

    @FindBy("//p[contains(text(),'All caught up! ')  and contains(text(),'Nothing more on your agenda.')]")
    HtmlElement nothingToDoTitle();

}
