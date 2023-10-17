package entities;

 import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Animal extends Entity {
	private BufferedImage image;
	private boolean left, up, right;
	private float animalSpeed = 1;
	Font font = new Font("Consolas", Font.BOLD, 25);

	
	public Animal(float x, float y, String path, float width, float height) {
		super(x, y, path, width, height);
		importImage();
	}
	
	public void update() {
		updatePos();
		updateHitBox();
	}

	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
		//drawHitBox(g);
	}
	@SuppressWarnings("incomplete-switch")
	private void updatePos() {
		// left and right;
		if(left && !right) {
			x -= animalSpeed;
		}else if(right && !left) {
			x += animalSpeed;
		}
		// up;
		if(up) {
			y -= animalSpeed;
		}
		// run again;
		if(y == 0) {
			y = 570;
		}else if(y == 600) {
			y = 600;
		}
		
		if(x == 980) {
			x = 0;
		}else if(x == 0) {
			x = 970;
		}
	}
	
	public void resetDirBooleans() {
		setLeft(false);
		setRight(false);
		setUp(false);
	}
	private void importImage() {
		InputStream is = getClass().getResourceAsStream(path);
		try {
			this.image = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isLeft() {
		return left;
	}
	public void setLeft(boolean left) {
		this.left = left;
	}
	public boolean isUp() {
		return up;
	}
	public void setUp(boolean up) {
		this.up = up;
	}
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	
}
