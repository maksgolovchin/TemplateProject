package com.template.utlis.softAssertions;

import com.template.webdriver.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultipleStepSoftAssertion {

    private final List<AssertionError> failedAssertions = new ArrayList<>();
    private WebDriverManager driverManager = null;
    private String uuid;

    public void softAssert(WebDriverManager driverManager, Runnable... actionsWithAsserts) {
        this.driverManager = driverManager;
        uuid = Allure.getLifecycle().getCurrentTestCaseOrStep().get();
        this.bundleAsserts(actionsWithAsserts);
    }

    private void bundleAsserts(Runnable... actionsWithAsserts) {
        runAllAsserts(actionsWithAsserts);
    }

    public void assertAll() {
        if (!failedAssertions.isEmpty()) {
            throw new AssertionError(
                    String.format(
                            "%d failed assertions found:%n %s",
                            failedAssertions.size(), getJoinedAssertionMessage()));
        }
    }

    private void runAllAsserts(Runnable... actionWithMultipleAsserts) {
        Stream.of(actionWithMultipleAsserts).forEach(
                i -> {
                    int count = failedAssertions.size();
                    this.runAssert(i);
                    if (failedAssertions.size() > count) {
                        driverManager.makeScreenshot();
                        markStepAsFailed();
                    }
                }
        );
    }

    public void markStepAsFailed() {
        Allure.getLifecycle().updateStep(uuid, stepResult -> stepResult.setStatus(Status.FAILED));
        Allure.getLifecycle().stopStep();
    }

    private void runAssert(Runnable actionWithAssert) {
        try {
            actionWithAssert.run();
        } catch (AssertionError | NoSuchElementException error) {
            failedAssertions.add(new AssertionError(Arrays.asList(error.getMessage().split("\n")).get(0)));
        }
    }

    private String getJoinedAssertionMessage() {
        return failedAssertions.stream()
                .map(AssertionError::getMessage)
                .collect(Collectors.joining("\n"));
    }
}
