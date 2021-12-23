package com.template.pages.vendorPages;

import com.template.elements.commonElements.HtmlElement;
import com.template.elements.modals.vendor.EditMyProfileModal;
import com.template.pages.BasePage;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface BrandProfilePage extends BasePage {

    @FindBy("//div[@data-qa='data-qa-brand-profile-image-gallery']//button")
    HtmlElement editImages();

    @FindBy("//div[@data-qa='data-qa-brand-profile-products']//button[.//label[@class='avatar-label']]")
    HtmlElement editPromotedProducts();

    @FindBy("(//div[@data-qa='data-qa-brand-profile-description']//button)[1]")
    HtmlElement editAboutInformation();

    @FindBy("//div[contains(@class,'paperScrollPaper ')]")
    EditMyProfileModal editMyProfileModal();

    @FindBy("//button[./span[text()='view more']]")
    HtmlElement viewMore();

    @FindBy("//button[./span[text()='view less']]")
    HtmlElement viewLess();

    @FindBy("//p[contains(text(),'Style')]/following-sibling::div//span[text()='{{ tag }}']")
    HtmlElement styleTag(@Param("tag") String tag);

    @FindBy("//p[contains(text(),'Characteristics')]/following-sibling::div//span[text()='{{ tag }}']")
    HtmlElement characteristicsTag(@Param("tag") String tag);

    @FindBy("//h6[contains(text(),'About')]/following-sibling::p")
    HtmlElement description();

    @FindBy("//div[@data-qa='data-qa-brand-profile-image-gallery']//div[contains(@class,'swiper-slide')]")
    ElementsCollection<HtmlElement> brandProfileImages();

}
