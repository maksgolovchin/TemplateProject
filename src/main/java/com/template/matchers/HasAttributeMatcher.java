package com.template.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import static org.hamcrest.Matchers.is;

public class HasAttributeMatcher extends TypeSafeMatcher<WebElement> {

    private final String attributeName;
    private final Matcher<String> attributeValueMatcher;

    private HasAttributeMatcher(String attributeName, Matcher<String> attributeValueMatcher) {
        this.attributeName = attributeName;
        this.attributeValueMatcher = attributeValueMatcher;
    }

    static Matcher<WebElement> hasAttribute(final String attributeName,
                                            final Matcher<String> attributeValueMatcher) {
        return new HasAttributeMatcher(attributeName, attributeValueMatcher);
    }

    static Matcher<WebElement> hasAttribute(final String attributeName, final String attributeValue) {
        return new HasAttributeMatcher(attributeName, is(attributeValue));
    }

    static Matcher<WebElement> hasValue(final Matcher<String> valueMatcher) {
        return hasAttribute("value", valueMatcher);
    }

    static Matcher<WebElement> hasValue(final String value) {
        return hasAttribute("value", is(value));
    }

    @Override
    public boolean matchesSafely(WebElement item) {
        return attributeValueMatcher.matches(item.getAttribute(attributeName));
    }

    public void describeTo(Description description) {
        description.appendText("attribute ").appendValue(attributeName).appendText(" ")
                .appendDescriptionOf(attributeValueMatcher);
    }

    @Override
    protected void describeMismatchSafely(WebElement item, Description mismatchDescription) {
        mismatchDescription.appendText("attribute ").appendValue(attributeName).appendText(" of element ")
                .appendValue(item).appendText(" was ").appendValue(item.getAttribute(attributeName));
    }
}