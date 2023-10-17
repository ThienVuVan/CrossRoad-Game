package state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static utilz.constants.MenuTypes.*;
import static utilz.constants.ButtonTypes.*;
import controller.Game;
import entities.Background;
import entities.MenuButton;
import handle.State;
import utilz.stateConstants.GameState;
import utilz.stateConstants.MenuState;

import static utilz.constants.OverComponent.*;

public class Over extends State implements Statemethods{
	
	private Background backgroundOver;
	private MenuButton back, exit, scoredisplay;
	
	private int max;
	FileReader fr = null;
	BufferedReader br = null;
	private boolean isOpen = true;
	Font font = new Font("Consolas", Font.BOLD, 50);
	
	public Over(Game game) throws IOException {
		super(game);
		initclasses();
		try {
			FileReader fr = new FileReader("D:\\Java\\CrossRoad\\src\\utilz\\scoreList");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				max = Integer.parseInt(line);
			}
		}catch(IOException e) {
			System.out.println("can not read file");
		}finally {
			if(br != null) {
				br.close();
			}
			if(fr != null) {
				fr.close();
			}
			System.out.println(max);
		}
	}

	private void initclasses() {
		backgroundOver = new Background(0,0,OVER,0,0);
		back = new MenuButton(335, 450, BACKMENU, GameState.MENU);
		exit = new MenuButton(535, 450, EXIT, GameState.EXIT);
		scoredisplay = new MenuButton(185, 110, SCOREDISPLAY, GameState.MENU);
	}

	@Override
	public void update() {
		back.update();
		exit.update();
		try {
			updateMaxScore();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void updateMaxScore() throws IOException {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			int score = getGame().getPlaying().getScore().getScore();
			if( score > max && isOpen) {
				System.out.println("open");
				fw = new FileWriter("D:\\Java\\CrossRoad\\src\\utilz\\scoreList", true);
				bw = new BufferedWriter(fw);
				bw.newLine();
				bw.write(String.valueOf(score));
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(bw != null) {
				bw.close();
			}
			if(fw != null) {
				fw.close();
			}
			isOpen = false;
		}
	}

	@Override
	public void draw(Graphics g) {
		backgroundOver.render(g);
		scoredisplay.draw(g);
		back.draw(g);
		exit.draw(g);
		g.setFont(font);
		g.setColor(Color.BLACK);
		int score = getGame().getPlaying().getScore().getScore();
		g.drawString(String.valueOf(score)  , 550, 175);
		g.drawString(String.valueOf(max), 550, 275);
		if(score > max) {
			g.drawString(String.valueOf(score), 550, 360);
		}else {
			g.drawString("No", 550, 360);
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(isIn(e, back)) {
			MenuState.state = MenuState.MENU1;
			back.applyGameState();
			getGame().getPlaying().getScore().resetScore();
			getGame().getPlaying().getLevel().resetUPS();
		}
		if(isIn(e, exit)) {
			exit.applyGameState();
		}
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
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
