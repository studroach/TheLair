package TheLair;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import jig.ResourceManager;

public class TransitionState  extends BasicGameState{
	
	private int timer;
	LairGame lg;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		//
		
	}

	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		timer = 3000;
		lg = (LairGame)game;
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		if(lg.dead) {
			g.drawImage(ResourceManager.getImage(LairGame.LOSE_RSC), lg.ScreenWidth/2 - 252, lg.ScreenHeight/2 - 129);
		}else {
			g.drawImage(ResourceManager.getImage(LairGame.WIN_RSC), lg.ScreenWidth/2 - 181, lg.ScreenHeight/2 - 178);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		timer -= delta;
		if (timer <= 0) {
			System.exit(0);
		}
	}

	@Override
	public int getID() {
		return 4;
	}

}
