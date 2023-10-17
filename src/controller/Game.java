package controller;

import java.awt.Graphics;
import java.io.IOException;
import state.*;
import utilz.stateConstants.GameState;
import view.*;

public class Game implements Runnable {
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS = 120;
	private int UPS = 200;
	
	private Playing playing;
	private Menu menu;
	private Over over;

	public Game() {
		initClasses();
		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.setFocusable(true);
		startGameLoop();
	}
	
	private void initClasses() {
		menu = new Menu(this);
		playing = new Playing(this);
		try {
			over = new Over(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void update() {
		switch(GameState.state) {
		case MENU:
			menu.update();
			break;
		case PLAYING:
			playing.update();
			break;
		case OVER:
			over.update();
			break;
		case EXIT:
			System.exit(FPS);
		default:
			break;
		}
	}
	
	public void render(Graphics g) {
		switch(GameState.state) {
		case MENU:
			menu.draw(g);
			break;
		case PLAYING:
			playing.draw(g);
			break;
		case OVER:
			over.draw(g);
			break;
		case EXIT:
			System.exit(FPS);
		default:
			break;
		}
	}

	@Override
	public void run() {
		double timePerFrame = 1000000000.0 / FPS;
		double timePerUpdate = 1000000000.0 / UPS;
		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();
		long previousTime = System.nanoTime();
		double deltaU = 0;
		double deltaF = 0;
		
		while(true) {
			timePerUpdate = 1000000000.0 / UPS;
			long currentTime = System.nanoTime();
			deltaF += (currentTime - previousTime) / timePerFrame;
			deltaU += (currentTime - previousTime) / timePerUpdate;
			previousTime = currentTime;
			
			// to update things in frame;
			if(deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}
			
			// to repain frame;
			if(deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				deltaF--;
			}
		
			if(System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS : " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
//	public void windowFocusLost() {
//	if(GameState.state == GameState.PLAYING) {
//		playing.getAnimal().resetDirBooleans();
//	}
//}

	public Menu getMenu() {
		return menu;
	}
	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public Thread getGameThread() {
		return gameThread;
	}

	public void setGameThread(Thread gameThread) {
		this.gameThread = gameThread;
	}

	public Playing getPlaying() {
		return playing;
	}
	public Over getOver() {
		return over;
	}

	public int getUPS() {
		return UPS;
	}

	public void setUPS(int uPS) {
		UPS = uPS;
	}
	
}
