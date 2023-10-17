package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Car extends Entity {
	BufferedImage image = null;
	private int carSpeed = 1;
	private int carDir;
	public Car(float x, float y, String path, float width, float height, int carDir) {
		super(x, y, path, width, height);
		this.carDir = carDir;
		importImage();
	}
	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
		//drawHitBox(g);
	}
	
	public void update() {
		updateHitBox();
		updatePos();
	}
	
	private void updatePos() {
		if(carDir == 0) {
			x += carSpeed;
			if(x > 1000) {
				x = 0;
			}
		}else {
			x -= carSpeed;
			if(x < 0) {
				x = 1000;
			}
		}
		
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
