package handle;

import java.awt.Rectangle;

public class Collision {
	public static boolean isCollision(Rectangle animal, Rectangle car) {
		return animal.intersects(car.getBounds());
	}
}
