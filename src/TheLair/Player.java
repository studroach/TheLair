package TheLair;

import jig.Entity;
import jig.ResourceManager;
import jig.Vector;

public class Player extends Entity{
	
	private Vector velocity;
	private float vx;
	private float vy;
	public int xTile;
	public int yTile;
	public int[] keys = new int[6];
	public int keySlot;
	public int health;
	public int lives;
	public int killCoolDown;
	
	public Player(float x, float y) {
		super(x, y);
		addImageWithBoundingBox(ResourceManager.getImage(LairGame.PLAYER_STATIC_RSC));
		velocity = new Vector(0, 0);
		keySlot = 0;
		resetKeys();
		health = 40;
		lives = 3;
		killCoolDown = 0;
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
		killCoolDown -= 10;
	}
	
	public void resetKeys() {
		for(int i = 0; i < 6; i++) {
			keys[i] = 0;
		}
		keySlot = 0;
	}
	
	public String keyChain() {
		String chain = "";
		for(int i = 0; i < 6; i++) {
			if(keys[i] != 0) {
				if(i == 0) {
					chain += keys[i];
				}else {
					chain += ("|" + keys[i]);
				}
			}
		}
		return chain;
	}
}
