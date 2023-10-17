package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Map extends Entity {
	BufferedImage image = null;
	public Map(float x, float y, String path, float width, float height) {
		super(x, y, path, 0, 0);
		importImage();
	}
	
	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
	}
	
	private void importImage() {
		InputStream is = getClass().getResourceAsStream(path);
		try {
			this.image = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
