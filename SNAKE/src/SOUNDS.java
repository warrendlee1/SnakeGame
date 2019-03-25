import java.awt.Graphics2D;

public class SOUNDS extends GameDriverV4{
	SoundDriver sounds;

	public SOUNDS() {
		String[] filenames = new String[6];
		filenames[0] = "song.wav";
		filenames[1] = "eat.wav";
		filenames[2] = "hitWall.wav";
		filenames[3] = "poisonBubble.wav";
		filenames[4] = "breaking.wav";
		filenames[5] = "gameOver.wav";
		sounds = new SoundDriver(filenames);
	}

	public static void main(String[] args) {
		SOUNDS game = new SOUNDS();
		game.start();
		game.setFocusable(true);
	}

	public void PLAY(int x) {
		sounds.play(x);
	}

	public void LOOP(int x) {
		sounds.loop(x);
	}

	@Override
	public void draw(Graphics2D win) {
		// TODO Auto-generated method stub
		
	}

}