package com.template.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class IsElementNotDisplayedMatcher extends TypeSafeMatcher<WebElement> {

    private IsElementNotDisplayedMatcher() {
    }

    static Matcher<WebElement> isNotDisplayed() {
        return new IsElementNotDisplayedMatcher();
    }

    @Override
    protected boolean matchesSafely(WebElement item) {
        try {
            return !item.isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Element is not displayed on page");
    }

    @Override
    public void describeMismatchSafely(WebElement element, Description mismatchDescription) {
        mismatchDescription.appendText("Element ").appendValue(element).appendText(" is displayed on page");
    }
}
