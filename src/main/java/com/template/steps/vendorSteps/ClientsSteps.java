package com.template.steps.vendorSteps;

import com.template.pages.vendorPages.ClientsPage;
import com.template.steps.common.BasePageSteps;
import com.template.utlis.softAssertions.MultipleStepSoftAssertion;
import com.template.webdriver.WebDriverManager;
import io.qameta.allure.Step;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.template.matchers.WebElementMatchers.isDisplayed;
import static com.template.utlis.Constants.DATE_FORMATTER;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class ClientsSteps extends BasePageSteps<ClientsSteps> {
    public ClientsSteps(WebDriverManager driverManager, String windowHandle) {
        super(driverManager, windowHandle);
    }

    @Step
    public ClientsSteps shouldNotSeeClients() {
        onPage().emptyClientsImage().should(isDisplayed());
        onPage().emptyClientsLabel().should(isDisplayed());
        onPage().vendorRows().should(hasSize(0));
        return this;
    }

    @Step
    public ClientsSteps shouldSeeClientsSortedByDateSoft(MultipleStepSoftAssertion softAssertion, boolean oldToNew) {
        List<LocalDate> list = onPage().vendorRows().filter(i -> !i.approvalDate().getAttribute("innerHTML")
                .equals("--")).extract(i -> LocalDate.parse(i.approvalDate().getAttribute("innerHTML"), DATE_FORMATTER));
        List<LocalDate> sortedList;
        if (oldToNew)
            sortedList = list.stream().sorted(Comparator.reverseOrder()).collect(toList());
        else
            sortedList = list.stream().sorted().collect(toList());
        String message = "Sorting doesn't match: \nActual: " + list.stream().map(LocalDate::toString)
                .collect(Collectors.joining(", ")) + "\nExpected:" +
                sortedList.stream().map(LocalDate::toString).collect(Collectors.joining(", "));

        softAssertion.softAssert(driverManager, () ->
                assertThat(message, list, equalTo(sortedList)));
        return this;
    }


    @Step
    public ClientsSteps shouldSeeClientsSortedByFirmNameSoft(MultipleStepSoftAssertion softAssertion, boolean ascending) {
        List<String> list = onPage().vendorRows().extract(i -> i.name().getText());
        List<String> sortedList;
        if (!ascending) {
            sortedList = list.stream().sorted(Comparator.reverseOrder()).collect(toList());
        } else {
            sortedList = list.stream().sorted().collect(toList());
        }
        String message = "Sorting doesn't match: \nActual: " + String.join(", ", list) +
                "\nExpected:" + String.join(", ", sortedList);
        softAssertion.softAssert(driverManager, () ->
                assertThat(message, list, equalTo(sortedList)));
        return this;
    }

    @Step
    public ClientsSteps selectSorting(String sorting) {
        onPage().selectSorting(sorting);
        waitForPageLoad();
        return this;
    }

    @Override
    protected ClientsSteps self() {
        return this;
    }

    private ClientsPage onPage() {
        return on(ClientsPage.class);
    }
}
