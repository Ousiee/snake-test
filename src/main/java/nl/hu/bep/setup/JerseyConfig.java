package nl.hu.bep.setup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

import nl.hu.bep.setup.GameResource;
import nl.hu.bep.setup.SnakeResource;
import nl.hu.bep.setup.LoginResource;

@ApplicationPath("restservices")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(RolesAllowedDynamicFeature.class);
        register(GameResource.class);
        register(SnakeResource.class);
        register(LoginResource.class);
    }
}
