import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
public class FOOD extends GAMEOBJECT {
	static Random rand = new Random();
	BufferedImage appleImage;
	
	public FOOD() {
		super(rand.nextInt(13), rand.nextInt(13));
		col = Color.BLACK;
		appleImage = addImage("APPLE.png");
	}
	
	public void moveAndDraw(Graphics2D win) {
		super.moveAndDraw(win);
		win.drawImage(appleImage, null, this.x - 25, this.y-23);
	}
	
	public BufferedImage addImage(String name)  {
		BufferedImage img = null;
		try {
		
			img = ImageIO.read(this.getClass().getResource(name));
			
		
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return img;

	}
}

