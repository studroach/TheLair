package TheLair;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.EmptyTransition;
import org.newdawn.slick.state.transition.HorizontalSplitTransition;

import jig.ResourceManager;

public class StartUpState extends BasicGameState{

	private int timer;
	LairGame lg;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		//
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		timer = 3000;
		lg = (LairGame)game;
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.drawImage(ResourceManager.getImage(LairGame.SPLASH_RSC),
				lg.ScreenWidth/2 - 215, lg.ScreenHeight/2 - 146);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		timer -= delta;
		if (timer <= 0) {
			lg.enterState(LairGame.LEVEL1STATE, new EmptyTransition(), new HorizontalSplitTransition() );
		}
	}

	@Override
	public int getID() {
		return 0;
	}

}
