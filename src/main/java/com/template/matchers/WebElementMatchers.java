package com.template.matchers;

import org.hamcrest.Matcher;
import org.openqa.selenium.WebElement;

import java.util.Collection;

public class WebElementMatchers {

    public static Matcher<WebElement> hasAttribute(final String attributeName,
                                                   final Matcher<String> attributeValueMatcher) {
        return com.template.matchers.HasAttributeMatcher.hasAttribute(attributeName, attributeValueMatcher);
    }

    public static Matcher<WebElement> hasAttribute(final String attributeName, final String attributeValue) {
        return com.template.matchers.HasAttributeMatcher.hasAttribute(attributeName, attributeValue);
    }

    public static Matcher<WebElement> hasValue(final Matcher<String> valueMatcher) {
        return com.template.matchers.HasAttributeMatcher.hasValue(valueMatcher);
    }

    public static Matcher<WebElement> hasText(String textMatcher) {
        return HasTextMatcher.hasText(textMatcher);
    }

    public static Matcher<WebElement> hasText(Matcher<String> textMatcher) {
        return HasTextMatcher.hasText(textMatcher);
    }

    public static Matcher<WebElement> hasValue(String textMatcher) {
        return HasValueMatcher.hasValue(textMatcher);
    }

    public static <E> Matcher<Collection<? extends E>> isNotEmpty() {
        return IsCollectionNotEmpty.isNotEmpty();
    }

    public static Matcher<WebElement> isDisabled() {
        return IsElementDisabledMatcher.isDisabled();
    }

    public static Matcher<WebElement> isDisplayed() {
        return IsElementDisplayedMatcher.isDisplayed();
    }

    public static Matcher<WebElement> isEnabled() {
        return IsElementEnabledMatcher.isEnabled();
    }

    public static Matcher<WebElement> exists() {
        return IsElementExistMatcher.exists();
    }

    public static Matcher<WebElement> isNotDisplayed() {
        return IsElementNotDisplayedMatcher.isNotDisplayed();
    }

    public static Matcher<WebElement> notExists() {
        return IsElementNotExistMatcher.notExists();
    }

    public static Matcher<WebElement> hasCssValue(String css, String textMatcher) {
        return HasCssValueMatcher.hasCssValue(css, textMatcher);
    }

    public static Matcher<WebElement> hasCssValue(String css, Matcher<String> textMatcher) {
        return HasCssValueMatcher.hasCssValue(css, textMatcher);
    }
}
