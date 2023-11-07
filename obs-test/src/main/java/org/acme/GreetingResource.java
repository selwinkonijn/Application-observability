package org.acme;

import org.jboss.logging.Logger;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/greeting")
public class GreetingResource {
    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @Path("/hello")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOG.info("Hello");
        return "Hello from RESTEasy Reactive";
    }

    @Path("/goodbye")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String goodbye() {
        LOG.info("Bye");
        return "See you soon!!!";
    }
}