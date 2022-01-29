package bjtmastermind.umrc.program.fileManipulation;

import java.awt.image.BufferedImage;

public class RotateImage {
	
	public static final int FLIP_90 = 0;
	public static final int FLIP_NEG_90 = 1;
	public static final int FLIP_180 = 2;
	
	private static BufferedImage flip(BufferedImage img, int direction) {
		int width = img.getWidth();
		int height = img.getHeight();
		BufferedImage flipped = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		for(int h = 0; h < height; h++) {
			for(int w = 0; w < width; w++) {
				switch(direction) {
					case FLIP_90:
						flipped.setRGB(h, (width - 1) - w, img.getRGB(w, h));
						break;							
					case FLIP_180:
						flipped.setRGB((width - 1) - w, (height - 1) - h, img.getRGB(w, h));
						break;
					case FLIP_NEG_90:
						flipped.setRGB((height - 1) - h, w, img.getRGB(w, h));
						break;
				}
			}
		}
		return flipped;
	}
	
	public static BufferedImage getFlipped(BufferedImage img, int direction) {
		return flip(img, direction);
	}
}
