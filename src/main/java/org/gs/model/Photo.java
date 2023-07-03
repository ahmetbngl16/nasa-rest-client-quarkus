package org.gs.model;

import java.net.URL;

public class Photo {
    private long id;
    private long sol;
    private Camera camera;
    private URL img_src;
    private String earth_date;
    private Rover rover;

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSol() {
        return sol;
    }

    public void setSol(long sol) {
        this.sol = sol;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public URL getImg_src() {
        return img_src;
    }

    public void setImg_src(URL img_src) {
        this.img_src = img_src;
    }

    public String getEarth_date() {
        return earth_date;
    }

    public void setEarth_date(String earth_date) {
        this.earth_date = earth_date;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }
}
