package com.template.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class IsElementNotExistMatcher extends TypeSafeMatcher<WebElement> {

    private IsElementNotExistMatcher() {
    }

    static Matcher<WebElement> notExists() {
        return new IsElementNotExistMatcher();
    }

    @Override
    protected boolean matchesSafely(WebElement item) {
        try {
            item.findElement(By.xpath("self::*"));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Element does not exist");
    }

    @Override
    public void describeMismatchSafely(WebElement element, Description mismatchDescription) {
        mismatchDescription.appendText("Element ").appendValue(element).appendText(" exists");
    }

}
