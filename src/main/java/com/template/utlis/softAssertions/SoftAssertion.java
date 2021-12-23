package com.template.utlis.softAssertions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoftAssertion {

    private final List<AssertionError> failedAssertions = new ArrayList<>();

    public static void softAssert(Runnable... actionsWithAsserts) {
        new SoftAssertion().bundleAsserts(actionsWithAsserts);
    }

    private void bundleAsserts(Runnable... actionsWithAsserts) {
        runAllAsserts(actionsWithAsserts);

        if (!failedAssertions.isEmpty()) {
            throw new AssertionError(
                    String.format(
                            "%d failed assertions found:%n %s",
                            failedAssertions.size(), getJoinedAssertionMessage()));
        }
    }

    private void runAllAsserts(Runnable... actionWithMultipleAsserts) {
        Stream.of(actionWithMultipleAsserts).forEach(this::runAssert);
    }

    private void runAssert(Runnable actionWithAssert) {
        try {
            actionWithAssert.run();
        } catch (AssertionError error) {
            failedAssertions.add(error);
        }
    }

    private String getJoinedAssertionMessage() {
        return failedAssertions.stream()
                .map(AssertionError::getMessage)
                .collect(Collectors.joining("\n"));
    }
}