import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class SNAKE extends GameDriverV4{
	Color col;
	ArrayList<BODYPART> bodyparts;
	int maxDelay;
	int currentDelay;
	int dx;
	int dy;
	int speed;
	BufferedImage bodyImage;
	BufferedImage headImageUP,headImageDOWN, headImageRIGHT, headImageLEFT;
	boolean isDead;

	public SNAKE(int column, int row) {
		bodyparts = new ArrayList<BODYPART>();
		
		// one part
		bodyparts.add(new BODYPART(column, row));
		
		bodyparts.add(new BODYPART(column-1, row));
		bodyparts.add(new BODYPART(column-2, row));
		bodyparts.add(new BODYPART(column-3, row));
		
		this.maxDelay = 5;
		this.currentDelay = 0;
		this.speed = 1;
		this.dx = speed;
		this.dy = 0;
		
		bodyImage = addImage("SNAKE_BODY.png");
		
		headImageUP 	= addImage("SNAKE_HEAD_UP.png");
		headImageDOWN 	= addImage("SNAKE_HEAD_DOWN.png");
		headImageRIGHT 	= addImage("SNAKE_HEAD_RIGHT.png");
		headImageLEFT 	= addImage("SNAKE_HEAD_LEFT.png");
		
		isDead = false;

	}
	
	public boolean hits(GAMEOBJECT object) {
		if(bodyparts.get(0).getGridLocation().equals(object.getGridLocation())) {
			return true;
		}else {
			return false;
		}
	}
	
	public void addTail() {
		bodyparts.add(new BODYPART(bodyparts.get(bodyparts.size()-1).column, bodyparts.get(bodyparts.size()-1).row));
	}

	public void draw(Graphics2D win) {
		if(bodyparts.get(0).getX() < 0) {
			//implement quit game
			isDead = true;
		}
		if(bodyparts.get(0).getX() > 700) {
			//implement quit game
			isDead = true;
		}
		if(bodyparts.get(0).getY() < 0) {
			//implement quit game
			isDead = true;
		}
		if(bodyparts.get(0).getY() > 700) {
			//implement quit game
			isDead =true;
		}
		
		
		
		
		if(GameDriverV4.Keys[KeyEvent.VK_UP]) {
			dx = 0;
			dy = -speed;
			
		} else if(GameDriverV4.Keys[KeyEvent.VK_DOWN]) {
			dx = 0;
			dy = speed;
		} else if(GameDriverV4.Keys[KeyEvent.VK_RIGHT]){
			dx = speed;
			dy = 0;
		} else if(GameDriverV4.Keys[KeyEvent.VK_LEFT]) {
			dy = 0;
			dx = -speed;
		}
		
		if(currentDelay == maxDelay) {
			
			//TODO: check head with all body parts
			for(int i = bodyparts.size() - 1; i > 0; i--) {
				if(bodyparts.get(0).getGridLocation().equals(bodyparts.get(i).getGridLocation())) {
					//implement quit game
					isDead = true;
				}
			}
			
			for (int i = bodyparts.size() - 1; i > 0; i--) {
				bodyparts.get(i).setGridLocation(bodyparts.get(i - 1).getGridLocation());
			}
			
			Point headLocation = bodyparts.get(0).getGridLocation();
			bodyparts.get(0).setGridLocation(new Point((int)headLocation.getX() + dx, (int)headLocation.getY() + dy));
			
			currentDelay = 0;
		}else {
			currentDelay ++;
		}
		for (BODYPART b : bodyparts) {
			b.moveAndDraw(win);
		}
		for(int i =0;i<bodyparts.size();i++) {
			win.drawImage(bodyImage, null, bodyparts.get(i).x - 18, bodyparts.get(i).y-28);

		}
		if (dx == 1) {
			win.drawImage(headImageRIGHT, null, bodyparts.get(0).x, bodyparts.get(0).y-28);
		}
		if (dx == -1) {
			win.drawImage(headImageLEFT, null, bodyparts.get(0).x - 25, bodyparts.get(0).y-28);
		}
		if (dy == 1) {
			win.drawImage(headImageDOWN, null, bodyparts.get(0).x -25, bodyparts.get(0).y-22);
		}
		if (dy == -1) {
			win.drawImage(headImageUP, null, bodyparts.get(0).x-25, bodyparts.get(0).y-28);
		}
		
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
