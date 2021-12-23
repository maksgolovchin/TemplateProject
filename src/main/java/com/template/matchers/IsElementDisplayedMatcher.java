package com.template.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Factory;

public class IsElementDisplayedMatcher extends TypeSafeMatcher<WebElement> {

    private IsElementDisplayedMatcher() {
    }

    @Factory
    static Matcher<WebElement> isDisplayed() {
        return new IsElementDisplayedMatcher();
    }

    @Override
    protected boolean matchesSafely(WebElement item) {
        try {
            return item.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Element is displayed on page");
    }

    @Override
    public void describeMismatchSafely(WebElement element, Description mismatchDescription) {
        mismatchDescription.appendText("Element ").appendValue(element.getText()).appendText(" is not displayed on page");
    }

}
