package com.template.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

public class IsElementEnabledMatcher extends TypeSafeMatcher<WebElement> {

    private IsElementEnabledMatcher() {
    }

    static Matcher<WebElement> isEnabled() {
        return new IsElementEnabledMatcher();
    }

    @Override
    protected boolean matchesSafely(WebElement item) {
        return item.isEnabled();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Element is enabled");
    }

    @Override
    public void describeMismatchSafely(WebElement element, Description mismatchDescription) {
        mismatchDescription.appendText("Element ").appendValue(element).appendText(" is not enabled");
    }

}