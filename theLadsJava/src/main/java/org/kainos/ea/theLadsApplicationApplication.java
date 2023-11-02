package org.kainos.ea;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.kainos.ea.resources.ClientController;
import org.kainos.ea.resources.DelivEmpController;
import org.kainos.ea.resources.ProjectController;
import org.kainos.ea.resources.SalesEmployeeController;

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
        bootstrap.addBundle(new SwaggerBundle<theLadsApplicationConfiguration>(){
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(theLadsApplicationConfiguration configuration){
                return configuration.getSwagger();
            }
        });
    }

    @Override
    public void run(final theLadsApplicationConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
        environment.jersey().register(new DelivEmpController());
        environment.jersey().register(new SalesEmployeeController());
        environment.jersey().register(new ClientController());
        environment.jersey().register(new ProjectController());

    }

}
