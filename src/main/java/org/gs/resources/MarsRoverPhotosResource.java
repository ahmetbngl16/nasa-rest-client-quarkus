package org.gs.resources;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.gs.model.MarsRoverPhotos;
import org.gs.proxy.MarsRoverProxy;
import org.gs.utils.imageDowloader;
import org.gs.utils.typeConvertion;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;

@Path("/nasa")
public class MarsRoverPhotosResource {
    
    private String apiKey="aRGq9kc9DmclP7G7PdLc1VnFcWVhgwyklfux8pkw";
    
    @Inject
    @RestClient
    MarsRoverProxy marsRoverProxy;

    @GET
    @Path("/sol")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPhotoSol(@QueryParam("sol") int sol){
        String solPhotos=marsRoverProxy.getPhotoSol(sol, apiKey);
        MarsRoverPhotos marsRoverPhotos=typeConvertion.parseJson(solPhotos);
        return Response.ok(marsRoverPhotos).build();
    }
    @GET
    @Path("/sol-camera")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPhotoSolCamera(@QueryParam("sol") int sol,@QueryParam("camera") String camera) throws IOException{
        String solCameraPhotos=marsRoverProxy.getPhotoSolCamera(sol, camera, apiKey);
        MarsRoverPhotos marsRoverPhotos=typeConvertion.parseJson(solCameraPhotos);
        imageDowloader.saveImage(marsRoverPhotos.getPhotos());
        return Response.ok(marsRoverPhotos).build();
    }
    @GET
    @Path("/sol-page")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPhotoSolPage(@QueryParam("sol") int sol,@QueryParam("page") int page){
        String solPagePhotos=marsRoverProxy.getPhotoSolPage(sol, page, apiKey);
        MarsRoverPhotos marsRoverPhotos=typeConvertion.parseJson(solPagePhotos);
        return Response.ok(marsRoverPhotos).build();
    }
    @GET
    @Path("/earth-date")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPhotoSolPage(@QueryParam("earth_date") String earthDate) throws IOException{
        String earthDatePhotos=marsRoverProxy.getPhotoEarthDate(earthDate, apiKey);
        MarsRoverPhotos marsRoverPhotos=typeConvertion.parseJson(earthDatePhotos);
        imageDowloader.saveImage(marsRoverPhotos.getPhotos());
        return Response.ok(marsRoverPhotos).build();
    }
}
