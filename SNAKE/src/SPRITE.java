import java.awt.image.BufferedImage;
public class SPRITE {
	BufferedImage[] frames;
	int delay, timer = 0, position = 0;
	
	public SPRITE(BufferedImage image, int rows, int cols, int delay) {
		frames = new BufferedImage[rows*cols];
		
		this.delay = delay;
		
		int width = image.getWidth()/cols;
		int height = image.getHeight()/rows;
		
		int index = 0;
		
		for(int i= 0;i<image.getHeight();i+= height) {
			for(int j = 0;j<image.getWidth();j+= width) {
				BufferedImage temp = image.getSubimage(j, i, width, height);
				frames[index] = temp;
				
				index++;
			}
		}
	}
	
	public BufferedImage getCurrentFrame() {
		BufferedImage frame = frames[position];
		if(timer>delay) {
			position++;
			position%=frames.length;
			timer = 0;
		}else {
			timer++;
		}
		return frame;
	}
}
