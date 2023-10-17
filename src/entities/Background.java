package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Background extends Entity {
	BufferedImage image = null;
	public Background(float x, float y, String path, float width, float height) {
		super(x, y, path, width, height);
		importImage();
	}
	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
	}
	
	public void update() {
	}
	
	private void importImage() {
		InputStream is = getClass().getResourceAsStream(path);
		try {
			this.image = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
