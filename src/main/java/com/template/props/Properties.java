package com.template.props;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("properties")
public interface Properties {
    Properties props = PropertyLoader.newInstance().populate(Properties.class);

    @Property("browserName")
    String browserName();

    @Property("url")
    String url();

    @Property("downloadsFolder")
    String downloadsFolder();

    @Property("remoteWebDriverUrl")
    String remoteWebDriverUrl();

    @Property("environment")
    String environment();

    @Property("browser_width")
    int browserWidth();

    @Property("browser_height")
    int browserHeight();

}
