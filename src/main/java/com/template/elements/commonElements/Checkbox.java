package com.template.elements.commonElements;

import io.qameta.atlas.webdriver.AtlasWebElement;

public interface Checkbox extends AtlasWebElement<Checkbox> {
    default void setChecked(boolean state) {
        if (isSelected() != state) {
            click();
        }
    }
}
