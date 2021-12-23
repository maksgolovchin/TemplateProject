package com.template.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

public class IsElementDisabledMatcher extends TypeSafeMatcher<WebElement> {

    private IsElementDisabledMatcher() {
    }

    static Matcher<WebElement> isDisabled() {
        return new IsElementDisabledMatcher();
    }

    @Override
    protected boolean matchesSafely(WebElement item) {
        return !item.isEnabled();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Element is disabled");
    }

    @Override
    public void describeMismatchSafely(WebElement element, Description mismatchDescription) {
        mismatchDescription.appendText("Element ").appendValue(element).appendText(" is enabled");
    }

}