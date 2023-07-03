package org.gs.proxy;

import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("/mars-photos")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient()
public interface MarsRoverProxy {

    // https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY
    @GET
    @Path("/api/v1/rovers/curiosity/photos")
    String getPhotoSol(@QueryParam("sol") int sol, @QueryParam("api_key") String apiKey);

    // https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&camera=fhaz&api_key=DEMO_KEY
    @GET
    @Path("/api/v1/rovers/curiosity/photos")
    String getPhotoSolCamera(@QueryParam("sol") int sol,@QueryParam("camera") String camera,@QueryParam("api_key") String apiKey);

    // https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&page=2&api_key=DEMO_KEY 
    @GET
    @Path("/api/v1/rovers/curiosity/photos")
    String getPhotoSolPage(@QueryParam("sol") int sol,@QueryParam("page") int page,@QueryParam("api_key") String apiKey);

    // https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?earth_date=2023-06-20&api_key=aRGq9kc9DmclP7G7PdLc1VnFcWVhgwyklfux8pkw
    @GET
    @Path("/api/v1/rovers/curiosity/photos")
    String getPhotoEarthDate(@QueryParam("earth_date") String earthDate, @QueryParam("api_key") String apiKey);

}
