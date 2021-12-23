package com.template.steps.vendorSteps;

import com.template.pages.vendorPages.BrandProfilePage;
import com.template.steps.common.BasePageSteps;
import com.template.webdriver.WebDriverManager;

public class BrandProfileSteps extends BasePageSteps<BrandProfileSteps> {
    public BrandProfileSteps(WebDriverManager driverManager, String windowHandle) {
        super(driverManager, windowHandle);
    }

    @Override
    protected BrandProfileSteps self() {
        return this;
    }

    private BrandProfilePage onBrandProfilePage() {
        return on(BrandProfilePage.class);
    }
}
