package com.template.props;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("credentials")
public interface Credentials {
    Credentials creds = PropertyLoader.newInstance().populate(Credentials.class);

    @Property("password")
    String password();

    @Property("email")
    String email();

}
