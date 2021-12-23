package com.template.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import static org.hamcrest.Matchers.is;

public class HasCssValueMatcher extends TypeSafeMatcher<WebElement> {
    private final String cssValueName;
    private final Matcher<String> attributeValueMatcher;

    private HasCssValueMatcher(String cssValueName, Matcher<String> attributeValueMatcher) {
        this.cssValueName = cssValueName;
        this.attributeValueMatcher = attributeValueMatcher;
    }

    public static Matcher<WebElement> hasCssValue(final String cssValueName, final Matcher<String> cssValueMatcher) {
        return new HasCssValueMatcher(cssValueName, cssValueMatcher);
    }

    public static Matcher<WebElement> hasCssValue(final String cssValueName, final String cssValue) {
        return new HasCssValueMatcher(cssValueName, is(cssValue));
    }

    @Override
    public boolean matchesSafely(WebElement item) {
        return attributeValueMatcher.matches(item.getCssValue(cssValueName));
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("css value ").appendValue(cssValueName).appendText(" ").appendDescriptionOf(attributeValueMatcher);
    }

    @Override
    protected void describeMismatchSafely(WebElement item, Description mismatchDescription) {
        mismatchDescription.appendText("css value ").appendValue(cssValueName).appendText(" of element ").
                appendValue(item).appendText(" was ").appendValue(item.getCssValue(cssValueName));
    }

}
