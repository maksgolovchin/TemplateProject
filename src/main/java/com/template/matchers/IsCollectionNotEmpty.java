package com.template.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.Collection;

public class IsCollectionNotEmpty<E> extends TypeSafeMatcher<Collection<? extends E>> {

    private IsCollectionNotEmpty() {
    }

    static <E> Matcher<Collection<? extends E>> isNotEmpty() {
        return new IsCollectionNotEmpty<>();
    }

    @Override
    protected boolean matchesSafely(Collection<? extends E> item) {
        return !item.isEmpty();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("collection size is not empty");
    }

    @Override
    public void describeMismatchSafely(Collection<? extends E> elements, Description mismatchDescription) {
        mismatchDescription.appendText("collection size is ").appendValue(elements.size());
    }

}