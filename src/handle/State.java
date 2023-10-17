package handle;

import java.awt.event.MouseEvent;

import controller.Game;
import entities.ButtonAnimal;
import entities.ButtonMap;
import entities.MenuButton;

public class State {
	protected Game game;
	public State(Game game) {
		this.game = game;
	}
	
	public boolean isIn(MouseEvent e, MenuButton but) {
		return but.getBounds().contains(e.getX(), e.getY());
	}
	
	public boolean isChooseMap(MouseEvent e, ButtonMap but) {
		return but.getBounds().contains(e.getX(), e.getY());
	}
	public boolean isChooseAnimal(MouseEvent e, ButtonAnimal but) {
		return but.getBounds().contains(e.getX(), e.getY());
	}
	public Game getGame() {
		return game;
	}
}
