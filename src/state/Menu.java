package state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import controller.Game;
import entities.Background;
import entities.ButtonAnimal;
import entities.ButtonMap;
import entities.MenuButton;
import handle.State;
import utilz.stateConstants.AnimalState;
import utilz.stateConstants.GameState;
import utilz.stateConstants.MapState;
import utilz.stateConstants.MenuState;
import utilz.stateConstants.NextState;
import utilz.stateConstants.PlayState;

import static utilz.constants.ButtonTypes.*;
import static utilz.constants.MenuTypes.*;
import static utilz.constants.MapHomeTypes.*;
import static utilz.constants.AnimalHomeTypes.*;
import static utilz.constants.ChooseHomeTypes.*;

public class Menu extends State implements Statemethods {
	
	/* initialize thingneeds for game menu */
	private Background backgroundMenu;
	private ButtonMap map1, map2;
	private ButtonAnimal ani1,ani2,ani3;
	private MenuButton next, play, back;
	private MenuButton mapchoose, anichoose, street, mountain, cat, dog, mouse;
	
	/* Constructor */
	public Menu(Game game) {
		super(game);
		initclasses();
	}
	
	/* Create thingneeds for game menu */
	private void initclasses() {
		backgroundMenu = new Background(0 , 0,MENU , 0, 0);
		play = new MenuButton(330 ,420, PLAY, GameState.PLAYING);
		next = new MenuButton(420 ,420 ,NEXT ,GameState.MENU);
		back = new MenuButton(420, 420, BACK, GameState.MENU);
		map1 = new ButtonMap(170, 150, STREETHOME, MapState.MAP1);
		map2 = new ButtonMap(570, 150, MOUNTAINHOME, MapState.MAP2);
		ani1 = new ButtonAnimal(100, 150, MOUSEHOME, AnimalState.MOUSE);
		ani2 = new ButtonAnimal(400, 150, CATHOME, AnimalState.CAT);
		ani3 = new ButtonAnimal(700, 150, DOGHOME, AnimalState.DOG);
		createViewChoice();
	}
	
	/* Create view image for game when button is choosed */
	private void createViewChoice() {
		 mapchoose = new MenuButton(410,85,CHOOSEMAP,GameState.MENU);
		 anichoose = new MenuButton(410,85,CHOOSEANIMAL,GameState.MENU);
		 street = new MenuButton(410,85,STREETCHOOSED,GameState.MENU);
		 mountain = new MenuButton(410,85,MOUNTAINCHOOSED,GameState.MENU);
		 cat = new MenuButton(410,85,CATCHOOSED,GameState.MENU);
		 dog = new MenuButton(410,85,DOGCHOOSED,GameState.MENU);
		 mouse = new MenuButton(410,85,MOUSECHOOSED,GameState.MENU);
	}

	@Override
	public void update() {
		// To Do ...;
	}

	@Override
	public void draw(Graphics g) {
		// draw background menu;
		backgroundMenu.render(g);
		// check menu state;
		switch(MenuState.state) {
		case MENU1:
			// check map state to draw map choose;
			switch(MapState.state) {
			case NOMAP:
				mapchoose.draw(g);
				break;
			case MAP1:
				street.draw(g);
				break;
			case MAP2:
				mountain.draw(g);
				break;
			}
			// defaul draw;
			map1.draw(g);
			map2.draw(g);
			switch(NextState.state) {
			case NO:
				break;
			case YES:
				next.draw(g);
			}
			break;
		case MENU2:
			// check animal state to draw animal choose;
			switch(AnimalState.state) {
			case NOANI:
				anichoose.draw(g);
				break;
			case CAT:
				cat.draw(g);
				break;
			case DOG:
				dog.draw(g);
				break;
			case MOUSE:
				mouse.draw(g);
				break;
			}
			// defaul draw;
			ani1.draw(g);
			ani2.draw(g);
			ani3.draw(g);
			switch(PlayState.state) {
			case NO:
				break;
			case YES:
				play.draw(g);
			}
			back.draw(g);
		}
	}

	/* Contro Menu */
	@Override
	public void mousePressed(MouseEvent e) {
		// check menu state;
		switch(MenuState.state) {
		case MENU1:
			// is choose map 1;
			if(isChooseMap(e, map1)) {
				map1.applyMapState();
				game.getPlaying().createMap();
				NextState.state = NextState.YES;
				System.out.println(MapState.state);
			}
			// is choose map 2;
			if(isChooseMap(e, map2)) {
				map2.applyMapState();
				game.getPlaying().createMap();
				NextState.state = NextState.YES;
				System.out.println(MapState.state);
			}
			// is choose next button,
			if(isIn(e,next)) {
				System.out.println("next");
				next.applyGameState();
				MenuState.state = MenuState.MENU2;
			}
			break;
		case MENU2:
			// is choose animal 1;
			if(isChooseAnimal(e, ani1)) {
				ani1.applyAnimalState();
				game.getPlaying().createAnimal();
				back.setLocationRight();
				PlayState.state = PlayState.YES;
				System.out.println(AnimalState.MOUSE);
			}
			// is choose animal 2;
			if(isChooseAnimal(e, ani2)) {
				ani2.applyAnimalState();
				game.getPlaying().createAnimal();
				back.setLocationRight();
				PlayState.state = PlayState.YES;
				System.out.println(AnimalState.CAT);
			}
			// is choose animal 3;
			if(isChooseAnimal(e, ani3)) {
				ani3.applyAnimalState();
				game.getPlaying().createAnimal();
				back.setLocationRight();
				PlayState.state = PlayState.YES;
				System.out.println(AnimalState.DOG);
			}
			// is choose play button;
			if(isIn(e,play)) {
				game.getPlaying().getAnimal().resetPos();
				play.applyGameState();
			}
			// is choose back button;
			if(isIn(e,back)) {
				System.out.println("back");
				MenuState.state = MenuState.MENU1;
			}
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	} 
}
