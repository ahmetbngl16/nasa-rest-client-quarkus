package org.gs.utils;
import java.util.*;

import org.gs.model.Photo;


public class filteringManager {
    
    
    public static List<Photo> findImg(String paramName,List <Photo> allPhotos){
        List<Photo> photosFiltered=new ArrayList<>();
        try{
        System.out.println("Finding All "+ paramName+"in this date : "+allPhotos.get(0).getEarth_date().toString());
        int i=0;
        for (Photo photo : allPhotos) {
            System.out.println(photo.getCamera().getName().toString());
            if(photo.getCamera().getName().toString().equalsIgnoreCase(paramName)){
                System.out.println(i+"Photo : "+photo.getImg_src().toString());
                photosFiltered.add(photo);
            } 
        }
        return photosFiltered;
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return photosFiltered;

    }

}
