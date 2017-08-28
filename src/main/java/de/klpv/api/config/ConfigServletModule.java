package de.klpv.api.config;

import com.google.api.server.spi.guice.EndpointsModule;
import com.google.common.collect.ImmutableList;
import de.klpv.api.TestEndpoint;

public class ConfigServletModule extends EndpointsModule {

    /**
     * declare servlet mappings here.
     */
    @Override
    protected void configureServlets() {

        configureEndpoints("/_ah/api/*",
            ImmutableList.of(
                TestEndpoint.class
            )
        );

    }

}
