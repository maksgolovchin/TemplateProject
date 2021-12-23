package com.template.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import static org.hamcrest.Matchers.is;

public class HasValueMatcher extends TypeSafeMatcher<WebElement> {
    private static final String VALUE = "value";
    private final Matcher<String> attributeValueMatcher;

    private HasValueMatcher(Matcher<String> attributeValueMatcher) {
        this.attributeValueMatcher = attributeValueMatcher;
    }

    static Matcher<WebElement> hasValue(final String attributeValue) {
        return new HasValueMatcher(is(attributeValue));
    }

    @Override
    public boolean matchesSafely(WebElement item) {
        return attributeValueMatcher.matches(item.getAttribute(VALUE));
    }

    public void describeTo(Description description) {
        description.appendText("value of element is ").appendDescriptionOf(attributeValueMatcher);
    }

    @Override
    protected void describeMismatchSafely(WebElement item, Description mismatchDescription) {
        mismatchDescription.appendText("value of element ")
                .appendValue(item).appendText(" was ").appendValue(item.getAttribute(VALUE));
    }
}