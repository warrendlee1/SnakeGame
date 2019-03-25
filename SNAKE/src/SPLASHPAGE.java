import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

public class SPLASHPAGE {
	int gamestate, points, level;
	Font title, subtitle, dir, play, gg, stats;
	Color fontCol;

	public SPLASHPAGE() {
		title = new Font("sansserif", Font.BOLD, 70);
		subtitle = new Font("courier", Font.BOLD, 26);
		dir = new Font("courier", Font.PLAIN, 15);
		play = new Font("sansserif", Font.BOLD, 30);
		gg = new Font("sansserif", Font.BOLD, 70);
		stats = new Font("sansserif",Font.BOLD, 30);
		level = 1;
	}

	public void homeScreen(Graphics g) {
		points = 0;
		level = 1;
		// title
		g.setFont(title);
		Random r1 = new Random();
		g.setColor(Color.BLACK);
		for (int i = 191; i <= 201; i++) {
			g.setColor(fontCol);
			g.drawString("S N A K E", i, i + 10);
		}
		g.setColor(Color.white);
		g.drawString("S N A K E", 190, 200);

		// subtitle
		g.setFont(subtitle);
		g.setColor(Color.WHITE);
		
		g.drawString("W  A  R  R  E  N   L.", 200, 260);

		// directions
		g.setFont(dir);
		g.drawString("Use arrow keys to move the snake across the gridded field!", 105, 350);
		g.drawString("Collect as many apples as you can, but don't eat yourself!", 105, 400);
		g.drawString("Avoid the walls, and then catch the mouse to win the game!", 105, 450);
		g.setFont(play);
		g.drawString("p r e s s    E N T E R    t o    p l a y", 100, 550);

	}
	
	public void levels(Graphics g) {
		g.setFont(stats);
		g.setColor(Color.white);
		g.drawString("points: " + points, 10, 30);
		g.drawString("Level:  " + level, 10, 60);
		
	}

	public void gameOver(Graphics g) {
		// prints points
		g.setColor(Color.BLACK);
		g.setFont(gg);
		for (int i = 111; i <= 120; i++) {
			g.drawString("GAMEOVER", i, i + 150);
		}
		g.setColor(Color.white);
		g.drawString("GAMEOVER", 110, 260);

		// print stats
		g.setFont(subtitle);
		g.drawString("POINTS:    	 " + points, 120, 300
				);
		g.drawString("HIGH LEVEL:    " + level, 120, 330);
		g.setColor(Color.RED);
		g.drawString("Press R to restart game!", 120, 450);
	}
	
	
}
