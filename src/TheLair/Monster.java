package TheLair;

import jig.Entity;
import jig.ResourceManager;
import jig.Vector;

public class Monster extends Entity{

	private Vector velocity;
	public float vx;
	public float vy;
	public int xTile;
	public int yTile;
	public int health;
	public int attackCoolDown;
	public boolean isAlive;
	
	public Monster(float x, float y) {
		super(x, y);
		addImageWithBoundingBox(ResourceManager.getImage(LairGame.BAT_RSC));
		velocity = new Vector(0, 0);
		health = 20;
		attackCoolDown = 0;
		isAlive = true;
	}
	
	public void setVelocity(Vector v) {
		velocity = v;
	}
	
	public void setVX(float x) {
		vx = x;
	}
	
	public void setVY(float y) {
		vy = y;
	}
	
	public void findTile() {
		xTile = (int)((getX() - (getX()%48)) / 48);
		yTile = (int)((getY() - (getY()%48)) / 48);
	}
	
	public void update(final int delta) {
		velocity = new Vector(vx, vy);
		translate(velocity.scale(delta));
		attackCoolDown -= 10;
	}
	
	public void move(Level level) {
		int dir = 0;
		int lowest = 99;
		
		
		if(level.path[yTile][xTile][0] < lowest) {
			dir = 0;
			lowest = level.path[yTile][xTile][0];
		}
		
		if(xTile != 0 && yTile != 0) {
			if(level.path[yTile-1][xTile-1][0] < lowest) {
				dir = 1;
				lowest = level.path[yTile-1][xTile-1][0];
			}
		}
		if(xTile != 15 && yTile != 0) {
			if(level.path[yTile-1][xTile+1][0] < lowest) {
				dir = 2;
				lowest = level.path[yTile-1][xTile+1][0];
			}
		}
		if(xTile != 0 && yTile != 15) {
			if(level.path[yTile+1][xTile-1][0] < lowest) {
				dir = 3;
				lowest = level.path[yTile+1][xTile-1][0];
			}
		}
		if(xTile != 15 && yTile != 15) {
			if(level.path[yTile+1][xTile+1][0] < lowest) {
				dir = 4;
				lowest = level.path[yTile+1][xTile+1][0];
			}
		}
		if(yTile != 0) {
			if(level.path[yTile-1][xTile][0] < lowest) {
				dir = 5;
				lowest = level.path[yTile-1][xTile][0];
			}
		}
		if(xTile != 0) {
			if(level.path[yTile][xTile-1][0] < lowest) {
				dir = 6;
				lowest = level.path[yTile][xTile-1][0];
			}
		}
		if(xTile != 15) {
			if(level.path[yTile][xTile+1][0] < lowest) {
				dir = 7;
				lowest = level.path[yTile][xTile+1][0];
			}
		}
		if(yTile != 15) {
			if(level.path[yTile+1][xTile][0] < lowest) {
				dir = 8;
				lowest = level.path[yTile+1][xTile][0];
			}
		}
		
		if(dir == 1) {
			setVX((float)-0.1);
			setVY((float)-0.1);
		}else if(dir == 2) {
			setVX((float)0.1);
			setVY((float)-0.1);
		}else if(dir == 3) {
			setVX((float)-0.1);
			setVY((float)0.1);
		}else if(dir == 4) {
			setVX((float)0.1);
			setVY((float)0.1);
		}else if(dir == 5) {
			setVX((float)0);
			setVY((float)-0.1);
		}else if(dir == 6) {
			setVX((float)-0.1);
			setVY((float)0);
		}else if(dir == 7) {
			setVX((float)0.1);
			setVY((float)0);
		}else if(dir == 8) {
			setVX((float)0);
			setVY((float)0.1);
		}else {
			setVX((float)0);
			setVY((float)0);
		}
		
	}

	public double distance(Player player) {
		return(Math.sqrt(Math.pow(player.xTile - xTile, 2) + Math.pow((double)(player.yTile - yTile), 2)));
	}
	
}
