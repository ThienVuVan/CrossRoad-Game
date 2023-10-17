package entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

import utilz.stateConstants.GameState;


public class MenuButton {
	private int x, y;
	private BufferedImage image;
	private String path;
	private Rectangle bounds;
	private GameState state;
	public MenuButton(int x, int y, String path, GameState state) {
		this.x = x;
		this.y = y;
		this.path = path;
		this.state = state;
		loadImage();
		initBounds();
	}
	private void initBounds() {
		bounds = new Rectangle(x,y,120,40);
	}
	private void loadImage() {
		InputStream is = getClass().getResourceAsStream(path);
		try {
			this.image = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}
	public void update() {
		
	}
	public Rectangle getBounds() {
		return bounds;
	}
	public void applyGameState() {
		GameState.state = state;
	}
	public void setLocationRight() {
		this.x = 530;
		this.y = 420;
		bounds = new Rectangle(x,y,120,40);
	}
}
