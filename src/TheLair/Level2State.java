package TheLair;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import jig.ResourceManager;

public class Level2State extends BasicGameState {
	
	int clock = 0;
	boolean interact, locked;
	LairGame lg;
	int leverCountdown = 0;
	Monster bat1;
	Monster bat2;
	
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game) {
		container.setSoundOn(true);
		lg = (LairGame)game;
		bat1 = new Monster(96, 288);
		bat2 = new Monster(624, 624);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		lg.level.drawRoom(2, g);
		lg.level.drawObjects(2, g);
		//shadows
		lg.level.darken(g);
		
		lg.player.render(g);
		if(bat1.isAlive) {
			bat1.render(g);
		}
		if(bat2.isAlive) {
			bat2.render(g);
		}
		lg.player.findTile();
		//g.drawString("PlayerXY: " + lg.player.xTile + ", " + lg.player.yTile, 10, 30);
		g.drawString("KEYS: " + lg.player.keyChain(), 650, 10);
		if(interact) {
			if(locked) {
				g.setColor(Color.red);
				if(lg.player.getX() > 675) {
					g.drawString("[LOCKED]", lg.player.getX() - 48, lg.player.getY() - 48);
				}else {
					g.drawString("[LOCKED]", lg.player.getX() + 24, lg.player.getY() - 24);
				}
				g.setColor(Color.white);
			}else if(lg.player.getX() > 675) {
				g.drawString("Press [E]", lg.player.getX() - 48, lg.player.getY() - 48);
			}else {
				g.drawString("Press [E]", lg.player.getX() + 24, lg.player.getY() - 24);
			}
		}
		g.drawString("HP", lg.ScreenWidth/2 - 110, 10);
		g.drawString("Lives", lg.ScreenWidth/2 - 220, 10);
		g.drawImage(ResourceManager.getImage(LairGame.HPBAR_RSC), lg.ScreenWidth/2 - 80, 10);
		for(int i = 0; i < lg.player.health; i++) {
			g.drawImage(ResourceManager.getImage(LairGame.HP_RSC), (lg.ScreenWidth/2) - 77 + (i * 4), 13);
		}
		for(int i = 0; i < lg.player.lives; i++) {
			g.drawImage(ResourceManager.getImage(LairGame.HEART_RSC), (lg.ScreenWidth/2) - 170 + (i * 17), 10);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

		Input input = container.getInput();
		clock++;
		boolean W = true, A = true, S = true, D = true;
		interact = false;
		locked = false;
		
		if(leverCountdown != 0) {
			leverCountdown = leverCountdown - 50;
		}
		
		//wall collisions
		//basically just checks the 4 surrounding tiles for a wall and disables movement in that direction if found
		if(lg.player.yTile != 0) {
			if((lg.level.lvl2[lg.player.yTile - 1][lg.player.xTile] > 2 && lg.level.lvl2[lg.player.yTile - 1][lg.player.xTile] < 6)
					|| lg.level.lvl2[lg.player.yTile - 1][lg.player.xTile] == 1 || lg.level.lvl2[lg.player.yTile - 1][lg.player.xTile] == 0) {
				if((lg.player.yTile * 48) + 8 > lg.player.getY()) {
					W = false;
				}
			}
		}else {
			W = false;
		}
		if(lg.player.xTile != 0) {
			if((lg.level.lvl2[lg.player.yTile][lg.player.xTile - 1] > 2 && lg.level.lvl2[lg.player.yTile][lg.player.xTile - 1] < 6)
					|| lg.level.lvl2[lg.player.yTile][lg.player.xTile - 1] == 1 || lg.level.lvl2[lg.player.yTile][lg.player.xTile - 1] == 0) {
				if((lg.player.xTile * 48) + 20 > lg.player.getX()) {
					A = false;
				}
			}
		}else {
			A = false;
		}
		if(lg.player.yTile != 15) {	
			if((lg.level.lvl2[lg.player.yTile + 1][lg.player.xTile] > 2 && lg.level.lvl2[lg.player.yTile + 1][lg.player.xTile] < 6)
					|| lg.level.lvl2[lg.player.yTile + 1][lg.player.xTile] == 1 || lg.level.lvl2[lg.player.yTile + 1][lg.player.xTile] == 0) {
				if((lg.player.yTile * 48) + 24 < lg.player.getY()) {
					S = false;
				}
			}
		}else {
			S = false;
		}
		if(lg.player.xTile != 15) {	
			if((lg.level.lvl2[lg.player.yTile][lg.player.xTile + 1] > 2 && lg.level.lvl2[lg.player.yTile][lg.player.xTile + 1] < 6)
					|| lg.level.lvl2[lg.player.yTile][lg.player.xTile + 1] == 1 || lg.level.lvl2[lg.player.yTile][lg.player.xTile + 1] == 0) {
				if((lg.player.xTile * 48) + 32 < lg.player.getX()) {
					D = false;
				}
			}
		}else {
			D = false;
		}
		
		//movement to winning square
		if(lg.player.xTile == 0 && lg.player.yTile == 4 && lg.player.getX() > 24) {
			A = true;
		}
			
		//object interactions
		for(int i = 0; i < 4; i++) {
			//check if object is in vicinity
			if((lg.level.level2Objects[i].x > lg.player.xTile - 2 && lg.level.level2Objects[i].x < lg.player.xTile + 2)
					&& (lg.level.level2Objects[i].y > lg.player.yTile - 2 && lg.level.level2Objects[i].y < lg.player.yTile + 2)) {
				
				if(lg.level.level2Objects[i].type == 1 && lg.level.level2Objects[i].state != 0) {
					//door V
					interact = true;
					//this makes doors "solid"
					if(lg.player.getX() > (lg.level.level2Objects[i].x * 48) && lg.player.getX() < (lg.level.level2Objects[i].x * 48) + 48) {
						if(lg.player.getX() < (lg.level.level2Objects[i].x * 48) + 24) {
							D = false;
						}else if(lg.player.getX() > (lg.level.level2Objects[i].x * 48) + 24) {
							A = false;
						}
					}
					//this makes doors open
					if(input.isKeyDown(Input.KEY_E)) {
						if(lg.level.level2Objects[i].state == 1) {
							lg.level.level2Objects[i].state = 0;
						}else if(lg.level.level2Objects[i].state == 2) {
							boolean unlock = false;
							for(int j = 0; j < 4; j++) {
								if(lg.player.keys[j] == lg.level.level2Objects[i].link) {
									unlock = true;
									break;
								}
							}
							if(unlock) {
								lg.level.level2Objects[i].state = 1;
							}else {
								locked = true;
							}
						}
					}
					
				}else if(lg.level.level2Objects[i].type == 2 && lg.level.level2Objects[i].state != 0) {
					//door H
					interact = true;
					//this makes doors "solid"
					if(lg.player.getY() > (lg.level.level2Objects[i].y * 48) && lg.player.getY() < (lg.level.level2Objects[i].y * 48) + 48) {
						if(lg.player.getY() < (lg.level.level2Objects[i].y * 48) + 24) {
							S = false;
						}else if(lg.player.getY() > (lg.level.level2Objects[i].y * 48) + 24) {
							W = false;
						}
					}
					//this makes doors open
					if(input.isKeyDown(Input.KEY_E)) {
						if(lg.level.level2Objects[i].state == 1) {
							lg.level.level2Objects[i].state = 0;
						}else if(lg.level.level2Objects[i].state == 2) {
							boolean unlock = false;
							for(int j = 0; j < 4; j++) {
								if(lg.player.keys[j] == lg.level.level2Objects[i].link) {
									unlock = true;
									break;
								}
							}
							if(unlock) {
								lg.level.level2Objects[i].state = 1;
							}else {
								locked = true;
							}
						}
					}
					
				}else if(lg.level.level2Objects[i].type == 3) {
					//chest
					if(lg.level.level2Objects[i].state == 1) {
						if(input.isKeyDown(Input.KEY_E)) {
							lg.level.level2Objects[i].state = 0;
							lg.player.keys[lg.player.keySlot] = lg.level.level2Objects[i].link;
							lg.player.keySlot++;
						}
						interact = true;
					}
					
				}else if(lg.level.level2Objects[i].type == 4) {
					//lever
					interact = true;
					if(lg.level.level2Objects[i].state == 1) {
						if(input.isKeyDown(Input.KEY_E) && leverCountdown == 0) {
							lg.level.level2Objects[i].lever(lg, 1);
							lg.level.level2Objects[i].state = 0;
							leverCountdown = 500;
						}
					}else if(lg.level.level2Objects[i].state == 0) {
						if(input.isKeyDown(Input.KEY_E) && leverCountdown == 0) {
							lg.level.level2Objects[i].lever(lg, 0);
							lg.level.level2Objects[i].state = 1;
							leverCountdown = 500;
						}
					}
				}
				
			}
		}
		
		//movement
		if (input.isKeyDown(Input.KEY_W) && W) {
			lg.player.setVY((float)(-.2));
		}
		if (input.isKeyDown(Input.KEY_S) && S) {
			lg.player.setVY((float)(.2));
		}
		if (input.isKeyDown(Input.KEY_A) && A) {
			lg.player.setVX((float)(-.2));
		}
		if (input.isKeyDown(Input.KEY_D) && D) {
			lg.player.setVX((float)(.2));
		}
		
		//pathing
		lg.level.resetPath();
		lg.level.fillPathing(lg.player.xTile, lg.player.yTile, 2, true);
		
		//monsters
		if(bat1.health < 1) {
			bat1.isAlive = false;
		}
		if(bat1.isAlive) {
			bat1.findTile();
			bat1.move(lg.level);
			if(bat1.attackCoolDown < 0 && bat1.distance(lg.player) < 1) {
				lg.player.health -= 10;
				bat1.attackCoolDown = 800;
			}
		}
		if(bat2.health < 1) {
			bat2.isAlive = false;
		}
		if(bat2.isAlive) {
			bat2.findTile();
			bat2.move(lg.level);
			if(bat2.attackCoolDown < 0 && bat2.distance(lg.player) < 1) {
				lg.player.health -= 10;
				bat2.attackCoolDown = 800;
			}
		}
			
		//fighting back
		if(bat1.distance(lg.player) < 1.5 && input.isKeyDown(Input.KEY_SPACE) && lg.player.killCoolDown < 0) {
			bat1.health -= 10;
			lg.player.killCoolDown = 800;
		}
		if(bat2.distance(lg.player) < 1.5 && input.isKeyDown(Input.KEY_SPACE) && lg.player.killCoolDown < 0) {
			bat2.health -= 10;
			lg.player.killCoolDown = 800;
		}
		
		//next level
		if(lg.player.xTile == 0 && lg.player.yTile == 4 && lg.player.getX() < 24) {
			lg.player.resetKeys();
			game.enterState(LairGame.LEVEL3STATE);
		}
		
		if(lg.player.health < 1) {
			lg.player.lives--;
			lg.player.health = 40;
		}
		if(lg.player.lives == 0) {
			lg.dead = true;
			game.enterState(LairGame.TRANSITION_STATE);
		}
		
		lg.player.update(delta);
		bat1.update(delta);
		bat2.update(delta);
		lg.player.setVX(0);
		lg.player.setVY(0);
	}

	@Override
	public int getID() {
		return 2;
	}

}
