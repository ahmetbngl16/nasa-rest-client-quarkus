package org.gs.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import org.gs.model.Photo;

public class imageDowloader {

    	public static void saveImage(URL imageUrl, String destinationFile) throws IOException {
		InputStream is = imageUrl.openStream();
		OutputStream os = new FileOutputStream("src/main/java/org/gs/images/"+destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}

    	public static void saveImage(List<Photo> allPhotos) throws IOException {
        
        System.out.println("photos size : "+allPhotos.size());
        for (Photo photo : allPhotos) {
        InputStream is = photo.getImg_src().openStream();
		System.out.println("img source : "+photo.getImg_src().toString());
		OutputStream os = new FileOutputStream("src/main/java/org/gs/images/"+photo.getEarth_date()+"-"+photo.getId()+".JPG");

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
        System.out.println("image saved "+photo.getEarth_date());
        }    

	}


}
