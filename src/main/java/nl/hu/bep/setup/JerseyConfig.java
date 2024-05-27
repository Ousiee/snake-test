package nl.hu.bep.setup;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("restservices")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(RolesAllowedDynamicFeature.class);
        register(GameResource.class);  // Voeg je resource classes hier toe
        register(SnakeResource.class);  // Voeg je resource classes hier toe
        register(LoginResource.class);  // Voeg je resource classes hier toe
    }
}
