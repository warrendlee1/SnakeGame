import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
public class POISON extends GAMEOBJECT {
	static Random rand = new Random();
	BufferedImage poisonImage;
	
	public POISON() {
		super(rand.nextInt(13), rand.nextInt(13));
		col = Color.BLACK;
		poisonImage = addImage("POISON.png");
	}
	
	public void moveAndDraw(Graphics2D win) {
		win.drawImage(poisonImage, null, this.x - 25, this.y-23);
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


