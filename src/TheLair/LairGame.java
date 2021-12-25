package TheLair;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import jig.Entity;
import jig.ResourceManager;

public class LairGame extends StateBasedGame{
	
	public static final int STARTUPSTATE = 0;
	public static final int LEVEL1STATE = 1;
	public static final int LEVEL2STATE = 2;
	public static final int LEVEL3STATE = 3;
	public static final int TRANSITION_STATE = 4;
	
	public static final String TILE1_RSC = "resource/Tile1.png";
	public static final String TILE2_RSC = "resource/Tile2.png";
	public static final String TILE3_RSC = "resource/Tile3.png";
	public static final String TILE4_RSC = "resource/Tile4.png";
	public static final String WALLV_RSC = "resource/WallV.png";
	public static final String WALLH_RSC = "resource/WallH.png";
	public static final String WALLT_RSC = "resource/WallT.png";
	public static final String HOLE_RSC = "resource/Hole.png";
	public static final String HOLE_TOP_RSC = "resource/HoleTop.png";
	public static final String DOORV_RSC = "resource/DoorV.png";
	public static final String DOORH_RSC = "resource/DoorH.png";
	public static final String CHEST_RSC = "resource/Chest.png";
	public static final String CHEST_OPEN_RSC = "resource/ChestOpen.png";
	public static final String LEVER_RSC = "resource/Lever.png";
	public static final String LEVER_ON_RSC = "resource/LeverOn.png";
	public static final String SPLASH_RSC = "resource/Splash.png";
	public static final String PLAYER_STATIC_RSC = "resource/PlayerStatic.png";
	public static final String PLAYER_MOVING_RSC = "resource/PlayerMoving.png";
	public static final String IDLE_RSC = "resource/Idle.png";
	public static final String PLAYERA_RSC = "resource/PlayerA.png";
	public static final String PLAYERS_RSC = "resource/PlayerS.png";
	public static final String PLAYERD_RSC = "resource/PlayerD.png";
	public static final String PLAYERW_RSC = "resource/PlayerW.png";
	public static final String HEART_RSC = "resource/Heart.png";
	public static final String HP_RSC = "resource/HP.png";
	public static final String HPBAR_RSC = "resource/HPBar.png";
	public static final String SHADOW_RSC = "resource/Shadow.png";
	public static final String WIN_RSC = "resource/Win.png";
	public static final String LOSE_RSC = "resource/Lose.png";
	public static final String BAT_RSC = "resource/Bat.png";
	
	public final int ScreenWidth;
	public final int ScreenHeight;
	public boolean dead = false;
	
	Level level;
	Player player;
	
	public LairGame(String name, int x, int y) {
		super(name);
		ScreenHeight = y;
		ScreenWidth = x;
		
		Entity.setCoarseGrainedCollisionBoundary(Entity.AABB);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		addState(new StartUpState());
		addState(new Level1State());
		addState(new Level2State());
		addState(new Level3State());
		addState(new TransitionState());
		
		ResourceManager.loadImage(TILE1_RSC);
		ResourceManager.loadImage(TILE2_RSC);
		ResourceManager.loadImage(TILE3_RSC);
		ResourceManager.loadImage(TILE4_RSC);
		ResourceManager.loadImage(WALLV_RSC);
		ResourceManager.loadImage(WALLH_RSC);
		ResourceManager.loadImage(WALLT_RSC);
		ResourceManager.loadImage(HOLE_TOP_RSC);
		ResourceManager.loadImage(HOLE_RSC);
		ResourceManager.loadImage(DOORH_RSC);
		ResourceManager.loadImage(DOORV_RSC);
		ResourceManager.loadImage(LEVER_RSC);
		ResourceManager.loadImage(LEVER_ON_RSC);
		ResourceManager.loadImage(CHEST_RSC);
		ResourceManager.loadImage(CHEST_OPEN_RSC);
		ResourceManager.loadImage(SPLASH_RSC);
		ResourceManager.loadImage(PLAYER_STATIC_RSC);
		ResourceManager.loadImage(PLAYER_MOVING_RSC);
		ResourceManager.loadImage(IDLE_RSC);
		ResourceManager.loadImage(PLAYERA_RSC);
		ResourceManager.loadImage(PLAYERS_RSC);
		ResourceManager.loadImage(PLAYERD_RSC);
		ResourceManager.loadImage(PLAYERW_RSC);
		ResourceManager.loadImage(HEART_RSC);
		ResourceManager.loadImage(HP_RSC);
		ResourceManager.loadImage(HPBAR_RSC);
		ResourceManager.loadImage(SHADOW_RSC);
		ResourceManager.loadImage(WIN_RSC);
		ResourceManager.loadImage(LOSE_RSC);
		ResourceManager.loadImage(BAT_RSC);
		
		level = new Level();
		player = new Player(24, 168);
		
	}

	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new LairGame("THE LAIR", 768, 768));
			app.setDisplayMode(768, 768, false);
			app.setVSync(true);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}
	
}
