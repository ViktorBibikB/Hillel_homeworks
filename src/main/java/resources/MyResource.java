package resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/resources")
public class MyResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String gotIt() {
        return "GOT IT";
    }
}
