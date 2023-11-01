package org.kainos.ea;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.kainos.ea.resources.DelivEmpController;

public class theLadsApplicationApplication extends Application<theLadsApplicationConfiguration> {

    public static void main(final String[] args) throws Exception {
        new theLadsApplicationApplication().run(args);
    }

    @Override
    public String getName() {
        return "theLadsApplication";
    }

    @Override
    public void initialize(final Bootstrap<theLadsApplicationConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final theLadsApplicationConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new DelivEmpController());
    }

}
