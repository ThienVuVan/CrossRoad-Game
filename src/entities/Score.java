package entities;

import static utilz.constants.MapMark1.*;
import static utilz.constants.MapMark2.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import utilz.stateConstants.MapState;
import utilz.stateConstants.ScoreState;


public class Score extends Entity {
	
	private Animal animal;
	private int score = 0;
	Font font = new Font("Consolas", Font.BOLD, 25);
	
	public Score(float x, float y, String path, float width, float height, Animal animal) {
		super(x, y, path, width, height);
		this.animal = animal;
	}

	public void render(Graphics g) {
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString("Score: " + score, (int)x, (int)y);
	}
	
	public void resetScore() {
		score = 0;
	}
	public int getScore() {
		return score;
	}
	
	public void update() {
		switch(MapState.state) {
		case MAP1:
			switch(ScoreState.state) {
			case MARK1:
				if(animal.getY() < mark1_1_1 && animal.getY() > mark1_1_2) {
					score++;
					ScoreState.state = ScoreState.MARK2;
				}
				break;
			case MARK2:
				if(animal.getY() < mark1_2_1 && animal.getY() > mark1_2_2) {
					score++;
					ScoreState.state = ScoreState.MARK3;
				}
				break;
			case MARK3:
				if(animal.getY() < mark1_3_1 && animal.getY() > mark1_3_2) {
					score++;
					ScoreState.state = ScoreState.MARK1;
				}
				break;
			default:
				break;
			}
		case MAP2:
			switch(ScoreState.state) {
			case MARK1:
				if(animal.getY() < mark2_1_1 && animal.getY() > mark2_1_2) {
					score++;
					ScoreState.state = ScoreState.MARK2;
				}
				break;
			case MARK2:
				if(animal.getY() < mark2_2_1 && animal.getY() > mark2_2_2) {
					score++;
					ScoreState.state = ScoreState.MARK3;
				}
				break;
			case MARK3:
				if(animal.getY() < mark2_3_1 && animal.getY() > mark2_3_2) {
					score++;
					ScoreState.state = ScoreState.MARK1;
				}
				break;
			default:
				break;
			}
		}
	}

}
