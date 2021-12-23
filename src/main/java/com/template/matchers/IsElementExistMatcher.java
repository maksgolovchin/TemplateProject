package com.template.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class IsElementExistMatcher extends TypeSafeMatcher<WebElement> {

    private IsElementExistMatcher() {
    }

    static Matcher<WebElement> exists() {
        return new IsElementExistMatcher();
    }

    @Override
    protected boolean matchesSafely(WebElement item) {
        try {
            item.findElement(By.xpath("self::*"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Element exist");
    }

    @Override
    public void describeMismatchSafely(WebElement element, Description mismatchDescription) {
        mismatchDescription.appendText("Element ").appendValue(element).appendText(" does not exist");
    }

}
