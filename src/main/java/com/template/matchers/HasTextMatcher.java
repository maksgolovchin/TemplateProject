package com.template.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.WebElement;

import static org.hamcrest.Matchers.equalTo;

public class HasTextMatcher extends TypeSafeMatcher<WebElement> {

    private final Matcher<String> textMatcher;

    private HasTextMatcher(Matcher<String> textMatcher) {
        this.textMatcher = textMatcher;
    }

    public static Matcher<WebElement> hasText(final String textMatcher) {
        return new HasTextMatcher(equalTo(textMatcher));
    }

    public static Matcher<WebElement> hasText(final Matcher<String> textMatcher) {
        return new HasTextMatcher(textMatcher);
    }

    @Override
    public boolean matchesSafely(WebElement item) {
        return textMatcher.matches(item.getText());
    }

    public void describeTo(Description description) {
        description.appendText("Element text ").appendDescriptionOf(textMatcher);
    }

    @Override
    protected void describeMismatchSafely(WebElement item, Description mismatchDescription) {
        mismatchDescription.appendText("text of element ").appendValue(item).appendText(" was ").appendValue(item.getText());
    }


}