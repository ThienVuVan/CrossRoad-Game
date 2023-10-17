package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	protected float x,y,width,height;
	protected String path;
	protected Rectangle hitBox;
	protected float xOri, yOri;
	public Entity(float x, float y, String path, float width, float height) {
		this.x = x;
		this.y = y;
		this.xOri = x;
		this.yOri = y;
		this.width = width;
		this.height = height;
		this.path = path;
		initHitBox();
	}
	
	public void resetPos() {
		x = xOri;
		y = yOri;
	}
	
	protected void drawHitBox(Graphics g) {
		// for debugging hitbox
		g.setColor(Color.PINK);
		g.drawRect(hitBox.x, hitBox.y, hitBox.width, hitBox.height);
	}
	private void initHitBox() {
		hitBox = new Rectangle((int) x, (int) y, (int) width, (int) height);
	}
	public void updateHitBox() {
		hitBox.x = (int)x;
		hitBox.y = (int)y;
	}
	public Rectangle getHitBox() {
		return hitBox;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
}
