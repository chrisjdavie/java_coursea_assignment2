
/**
 * Convert images to grayscale and save.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class batch_invert {
	//I started with the image I wanted (inImage)
	public ImageResource invert(ImageResource inImage) {
		//Duplicate image
		ImageResource outImage = new ImageResource(inImage);
		//for each pixel in outImage
		for (Pixel pixel: outImage.pixels()) {
			//look at the corresponding pixel in inImage
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			
			//set pixel's red to inverse
			pixel.setRed(255 - inPixel.getRed());
			//set pixel's green to inverse
			pixel.setGreen(255 - inPixel.getGreen());
			//set pixel's blue to inverse
			pixel.setBlue(255 - inPixel.getBlue());
		}
		//outImage is your answer
		return outImage;
	}

	public void selectAndConvertAndSave () {
		DirectoryResource dr = new DirectoryResource();
		for (File f: dr.selectedFiles()){
		    ImageResource inImage = new ImageResource(f);
		    ImageResource invertImage = invert(inImage);
		    String fname = inImage.getFileName();
		    fname = fname.substring(0, fname.length()-3);
		    fname += "jpg";
		    String newFname = "invert-" + fname;
		    invertImage.setFileName(newFname);
		    invertImage.save();
		  }
	}

	public void testGray() {
		ImageResource ir = new ImageResource();
		ImageResource invert = invert(ir);
		invert.draw();
	}
	
	
}