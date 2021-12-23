package com.template.steps.vendorSteps;

import com.template.pages.vendorPages.DashboardPage;
import com.template.steps.common.BasePageSteps;
import com.template.webdriver.WebDriverManager;
import io.qameta.allure.Step;

import static com.template.matchers.WebElementMatchers.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class DashboardSteps extends BasePageSteps<DashboardSteps> {

    public DashboardSteps(WebDriverManager driverManager, String windowHandle) {
        super(driverManager, windowHandle);
    }

    @Override
    protected DashboardSteps self() {
        return this;
    }

    @Step
    public DashboardSteps shouldSeeWelcomeMessage() {
        onDashboardPage().welcomeMessage().should(isDisplayed());
        return this;
    }

    @Step
    public DashboardSteps shouldNotSeeWelcomeMessage() {
        onDashboardPage().welcomeMessage().should(isNotDisplayed());
        return this;
    }


    @Step
    public DashboardSteps selectStep(int index) {
        click(onDashboardPage().stepSelectors().should(hasSize(greaterThan(0))).get(index));
        return this;
    }

    @Step
    public DashboardSteps clickOnlyOneTeamMember() {
        click(onDashboardPage().onlyOneTeamMemberButton());
        return this;
    }

    @Step
    public int getTradeAccountsCount() {
        return Integer.parseInt(onDashboardPage().tradeAccounts().getText());
    }

    @Step
    public DashboardSteps shouldSeeTradAccountsCount(int count) {
        onDashboardPage().tradeAccounts().should(hasText(String.valueOf(count)));
        return this;
    }

    private DashboardPage onDashboardPage() {
        return on(DashboardPage.class);
    }
}
