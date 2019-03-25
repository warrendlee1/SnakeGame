import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SNAKEGAME extends GameDriverV4 {
	SPLASHPAGE splashpage;
	SNAKE snake;
	POISON poison;
	FOOD food;
	Color col; 
	SOUNDS sound;
	BufferedImage s; 
	SPRITE sprite;
	int gamestate;
	
	public SNAKEGAME() {
		splashpage = new SPLASHPAGE();
		snake = new SNAKE(6,7);
		food = new FOOD();
		poison = new POISON();
		gamestate = 0;
		sound = new SOUNDS();
		s = this.addImage("sprite.png");
		sprite = new SPRITE(s, 2,4,8);
	}
	
	public void drawGrid(Graphics2D win) {
		col = new Color(52,0,0);
		for(int i = 0; i< 700; i+= 50) {
			win.setColor(col);
			win.drawLine(i, 0, i, 700);
			win.drawLine(0, i, 700, i);
		}
	}
	
	public void eatFood() {
		if(snake.hits(food)) {
			snake.addTail();
			sound.PLAY(1);
			food = new FOOD();
			splashpage.points += 1000;
		}
	}
	
	public void eatPoison() {
		if(snake.hits(poison)) {
			sound.PLAY(4);
			snake.isDead = true;
		}
	}
	
	@Override
	public void draw(Graphics2D win) {
		this.setBackGroundColor(new Color(102,51,0));
	
		if(gamestate == 0) {
			sound.PLAY(0);
			win.drawImage(sprite.getCurrentFrame(), null, 100,150);
			splashpage.homeScreen(win);
			snake = new SNAKE(6,7);
			if(GameDriverV4.Keys[KeyEvent.VK_ENTER]) {
				gamestate = 1;
			}
		}
		
		if(gamestate == 1) {
			this.drawGrid(win);
			splashpage.levels(win);
			food.moveAndDraw(win);
			snake.draw(win);
			this.eatFood();
			
			if(snake.isDead) {
				sound.PLAY(2);
				gamestate = 3;
			}
			if(splashpage.points >= 10000) {
				gamestate = 2;
				splashpage.level = 2;
				sound.PLAY(3);
			}
		}
		
		if(gamestate == 2) {
			this.drawGrid(win);
			splashpage.levels(win);
			poison.moveAndDraw(win);
			food.moveAndDraw(win);
			snake.draw(win);
			this.eatFood();
			this.eatPoison();
			if(snake.isDead) {
				sound.PLAY(2);
				gamestate = 3;
			}
		}
		
		if(gamestate == 3) {
			splashpage.gameOver(win);
			sound.PLAY(5);
			if(GameDriverV4.Keys[KeyEvent.VK_R]) {
				gamestate = 0;
			}
		}

		
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		SNAKEGAME snake = new SNAKEGAME();
		snake.start();
	}
}
