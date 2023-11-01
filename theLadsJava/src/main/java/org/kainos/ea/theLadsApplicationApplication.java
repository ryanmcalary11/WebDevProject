package org.kainos.ea;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.kainos.ea.resources.DelivEmpController;


public class theLadsApplicationApplication extends Application<theLadsApplicationConfiguration> {

    public static void main(final String[] args) throws Exception {
        new theLadsApplicationApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropwizardWebService";
    }

    @Override
    public void initialize(final Bootstrap<theLadsApplicationConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<theLadsApplicationConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(theLadsApplicationConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }

    @Override
    public void run(final theLadsApplicationConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new DelivEmpController());

    }

}