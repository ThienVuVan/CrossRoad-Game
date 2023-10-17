package entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import state.Playing;

public class Level extends Entity {
	
	private int lastScore = 0;
	private String level = "";
	private Playing playing;
	Font font = new Font("Consolas", Font.BOLD, 25);
	
	public Level(float x, float y, String path, float width, float height, Playing playing) {
		super(x, y, path, width, height);
		this.playing = playing;
	}

	public void update() {
		int currentScore = playing.getScore().getScore();
		int currentUPS = playing.getGame().getUPS();
		if(currentScore - lastScore >= 1 && playing.getGame().getUPS() < 350) {
			playing.getGame().setUPS(playing.getGame().getUPS() + 10);
			lastScore = currentScore;
		}
		if(currentUPS >= 195 && currentUPS < 245) {
			level = "1";
		}else if(currentUPS >= 250 && currentUPS <= 300) {
			level = "2";
		}else {
			level = "3";
		}
	}
	
	public void render(Graphics g) {
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Level: " + level , (int)x, (int)y);
	}
	
	public void resetUPS() {
		playing.getGame().setUPS(200);
	}
}
