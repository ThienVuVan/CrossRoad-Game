package entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import utilz.stateConstants.MapState;


public class ButtonMap {
	private int x, y;
	private BufferedImage image;
	private String path;
	private Rectangle bounds;
	private MapState state;
	public ButtonMap(int x, int y, String path, MapState state) {
		this.x = x;
		this.y = y;
		this.path = path;
		this.state = state;
		loadImage();
		initBounds();
	}
	private void initBounds() {
		bounds = new Rectangle(x,y,220,220);
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
	public void applyMapState() {
		MapState.state = state;
	}
}
