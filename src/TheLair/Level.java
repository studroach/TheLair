package TheLair;

import org.newdawn.slick.Graphics;

import jig.ResourceManager;

public class Level {
	
	int[][][] path = new int[16][16][2];
	int[][] pathBuffer = new int[255][2];
	int bufferCount;
	int bufferPlace;
	
	int[][] lvl1 = {{5, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3},
					{3, 2, 2, 2, 2, 2, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2},
					{2, 2, 2, 2, 2, 2, 4, 2, 2, 2, 2, 2, 2, 2, 2, 5},
					{5, 2, 2, 2, 2, 2, 4, 2, 2, 2, 3, 3, 5, 3, 3, 4},
					{4, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 4, 2, 2, 4},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 1, 1, 4},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 2, 2, 4},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 3, 2, 2, 4},
					{4, 2, 5, 3, 3, 3, 5, 2, 2, 0, 2, 2, 2, 2, 2, 4},
					{4, 2, 4, 2, 2, 2, 4, 2, 2, 0, 2, 2, 2, 2, 2, 4},
					{4, 2, 3, 2, 3, 2, 4, 2, 2, 0, 1, 1, 2, 2, 2, 4},
					{4, 2, 2, 2, 2, 2, 4, 2, 2, 0, 2, 2, 2, 2, 2, 4},
					{4, 2, 3, 3, 3, 3, 3, 2, 2, 0, 1, 1, 2, 2, 2, 4},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4},
					{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}};
	
	int[][] lvl2 = {{5, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5},
					{3, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4},
					{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 5, 3, 1, 4},
					{3, 3, 3, 3, 3, 5, 2, 2, 2, 5, 3, 3, 3, 2, 2, 4},
					{2, 2, 2, 2, 2, 4, 2, 2, 2, 4, 2, 2, 2, 2, 2, 4},
					{5, 2, 2, 2, 2, 4, 2, 2, 2, 4, 2, 2, 2, 2, 2, 4},
					{4, 2, 2, 2, 2, 4, 2, 2, 2, 4, 2, 2, 5, 2, 2, 4},
					{4, 2, 2, 2, 2, 3, 3, 2, 3, 3, 2, 2, 4, 2, 2, 4},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 2, 2, 4},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 2, 2, 4},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 2, 2, 4},
					{4, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 4},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4},
					{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}};
	
	int[][] lvl3 = {{5, 3, 3, 3, 3, 5, 3, 3, 3, 3, 5, 3, 3, 3, 3, 5},
					{4, 2, 2, 1, 1, 4, 2, 2, 2, 2, 4, 2, 2, 2, 2, 4},
					{4, 2, 2, 0, 0, 4, 2, 2, 2, 2, 4, 2, 3, 3, 3, 5},
					{3, 1, 1, 0, 0, 4, 2, 2, 2, 2, 4, 2, 2, 2, 2, 4},
					{2, 2, 2, 2, 0, 3, 3, 3, 2, 3, 3, 2, 3, 3, 3, 5},
					{5, 2, 1, 1, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 5},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 5},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4},
					{4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4},
					{4, 2, 5, 3, 3, 3, 5, 3, 5, 1, 1, 1, 1, 1, 1, 4},
					{4, 2, 4, 2, 2, 2, 4, 2, 4, 0, 0, 0, 0, 0, 0, 3},
					{4, 2, 3, 2, 5, 2, 3, 2, 4, 0, 0, 0, 2, 0, 0, 2},
					{4, 2, 2, 2, 4, 2, 2, 2, 4, 0, 0, 0, 1, 0, 0, 5},
					{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}};
	
	int[][] lvl1Obj =  {{6,1,1,1,0},
						{15,2,1,2,2},
						{13,5,3,1,1},
						{5,10,3,1,2},
						{2,12,1,2,1},
						{10,12,4,1,1}};
	
	int[][] lvl2Obj =  {{0,4,1,1,0},
						{7,4,4,1,2},
						{7,7,2,2,1},
						{2,13,3,1,1}};
			
	int[][] lvl3Obj =  {{1,1,3,1,1},
						{1,5,2,2,1},
						{3,4,4,1,3},
						{4,12,3,1,2},
						{6,14,3,1,3},
						{7,2,3,1,5},
						{7,12,3,1,4},
						{8,4,2,2,4},
						{9,2,3,1,6},
						{12,1,1,2,2},
						{12,3,1,2,3},
						{12,5,1,2,5},
						{12,7,1,2,6},
						{14,1,4,1,4},
						{14,3,4,1,5},
						{14,5,4,1,6},
						{14,7,4,1,7},
						{15,13,1,1,0}};
	
	Objects[] level1Objects = new Objects[6];
	Objects[] level2Objects = new Objects[4];
	Objects[] level3Objects = new Objects[18];
	
	public Level() {
		for(int i = 0; i < 6; i++) {
			level1Objects[i] = new Objects(lvl1Obj[i][0],lvl1Obj[i][1],lvl1Obj[i][2],lvl1Obj[i][3],lvl1Obj[i][4]);
		}
		for(int i = 0; i < 4; i++) {
			level2Objects[i] = new Objects(lvl2Obj[i][0],lvl2Obj[i][1],lvl2Obj[i][2],lvl2Obj[i][3],lvl2Obj[i][4]);
		}
		for(int i = 0; i < 18; i++) {
			level3Objects[i] = new Objects(lvl3Obj[i][0],lvl3Obj[i][1],lvl3Obj[i][2],lvl3Obj[i][3],lvl3Obj[i][4]);
		}
		resetPath();
	}
	
	public void drawRoom(int lvl, Graphics g) {
		int temp[][];
		if(lvl == 1) {
			temp = lvl1;
		}else if(lvl == 2) {
			temp = lvl2;
		}else if(lvl == 3) {
			temp = lvl3;
		}else {
			return;
		}
		
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				if(temp[i][j] == 0) {
					g.drawImage(ResourceManager.getImage(LairGame.HOLE_RSC), j*48, i*48);
				}else if(temp[i][j] == 1) {
					g.drawImage(ResourceManager.getImage(LairGame.HOLE_TOP_RSC), j*48, i*48);
				}else if(temp[i][j] == 2) {
					//do random tile
					g.drawImage(ResourceManager.getImage(LairGame.TILE1_RSC), j*48, i*48);
				}else if(temp[i][j] == 3) {
					g.drawImage(ResourceManager.getImage(LairGame.WALLH_RSC), j*48, i*48);
				}else if(temp[i][j] == 4) {
					g.drawImage(ResourceManager.getImage(LairGame.WALLV_RSC), j*48, i*48);
				}else if(temp[i][j] == 5) {
					g.drawImage(ResourceManager.getImage(LairGame.WALLT_RSC), j*48, i*48);
				}
				
			}
		}
		
	}
	
	public void drawObjects(int lvl, Graphics g) {
		Objects[] temp;
		int length;
		if(lvl == 1) {
			temp = level1Objects;
			length = 6;
		}else if(lvl == 2) {
			temp = level2Objects;
			length = 4;
		}else if(lvl == 3) {
			temp = level3Objects;
			length = 18;
		}else {
			return;
		}
		for(int i = 0; i < length; i++) {
			if(temp[i].type == 1 && temp[i].state != 0) {
				g.drawImage(ResourceManager.getImage(LairGame.DOORV_RSC), temp[i].x * 48, (temp[i].y * 48) - 18);
			}else if(temp[i].type == 2 && temp[i].state != 0) {
				g.drawImage(ResourceManager.getImage(LairGame.DOORH_RSC), temp[i].x * 48, temp[i].y * 48);
			}else if(temp[i].type == 3) {
				if(temp[i].state == 1) {
					g.drawImage(ResourceManager.getImage(LairGame.CHEST_RSC), temp[i].x * 48, temp[i].y * 48);
				}else if(temp[i].state == 0) {
					g.drawImage(ResourceManager.getImage(LairGame.CHEST_OPEN_RSC), temp[i].x * 48, temp[i].y * 48);
				}
					
			}else if(temp[i].type == 4) {
				if(temp[i].state == 1) {
					g.drawImage(ResourceManager.getImage(LairGame.LEVER_RSC), temp[i].x * 48, temp[i].y * 48);
				}else if(temp[i].state == 0) {
					g.drawImage(ResourceManager.getImage(LairGame.LEVER_ON_RSC), temp[i].x * 48, temp[i].y * 48);
				}
					
			}
		}
	}
	
	public void fillPathing(int x, int y, int lvl, boolean isFirst) {
		int[][] temp;
		if(lvl == 1) {
			temp = lvl1;
		}else if(lvl == 2) {
			temp = lvl2;
		}else if(lvl == 3) {
			temp = lvl3;
		}else {
			temp = lvl1;
		}
		
		if(isFirst) {
			path[y][x][0] = 0;
			path[y][x][1] = 1;
		}else {
			bufferPlace++;
		}
		
		if(y != 15) {
			if(path[y+1][x][1] == 0 && temp[y+1][x] < 3) {
				path[y+1][x][0] = path[y][x][0] + 1;
				path[y+1][x][1] = 1;
				pathBuffer[bufferCount][0] = x;
				pathBuffer[bufferCount][1] = y+1;
				bufferCount++;
			}else if(path[y+1][x][1] == 0 && temp[y+1][x] > 2) {
				if(path[y][x][0] + 1 < 6) {
					path[y+1][x][0] = 100;
				}else {
					path[y+1][x][0] = 99;
				}
				path[y+1][x][1] = 1;
			}
		}
		if(y != 0) {
			if(path[y-1][x][1] == 0 && temp[y-1][x] < 3) {
				path[y-1][x][0] = path[y][x][0] + 1;
				path[y-1][x][1] = 1;
				pathBuffer[bufferCount][0] = x;
				pathBuffer[bufferCount][1] = y-1;
				bufferCount++;
			}else if(path[y-1][x][1] == 0 && temp[y-1][x] > 2) {
				if(path[y][x][0] + 1 < 6) {
					path[y-1][x][0] = 100;
				}else {
					path[y-1][x][0] = 99;
				}
				path[y-1][x][1] = 1;
			}
		}
		if(x != 15) {
			if(path[y][x+1][1] == 0 && temp[y][x+1] < 3) {
				path[y][x+1][0] = path[y][x][0] + 1;
				path[y][x+1][1] = 1;
				pathBuffer[bufferCount][0] = x+1;
				pathBuffer[bufferCount][1] = y;
				bufferCount++;
			}else if(path[y][x+1][1] == 0 && temp[y][x+1] > 2) {
				if(path[y][x][0] + 1 < 6) {
					path[y][x+1][0] = 100;
				}else {
					path[y][x+1][0] = 99;
				}
				path[y][x+1][1] = 1;
			}
		}
		if(x != 0) {
			if(path[y][x-1][1] == 0 && temp[y][x-1] < 3) {
				path[y][x-1][0] = path[y][x][0] + 1;
				path[y][x-1][1] = 1;
				pathBuffer[bufferCount][0] = x-1;
				pathBuffer[bufferCount][1] = y;
				bufferCount++;
			}else if(path[y][x-1][1] == 0 && temp[y][x-1] > 2) {
				if(path[y][x][0] + 1 < 6) {
					path[y][x-1][0] = 100;
				}else {
					path[y][x-1][0] = 99;
				}
				path[y][x-1][1] = 1;
			}
		}
		
		if(bufferPlace != bufferCount) {
			fillPathing(pathBuffer[bufferPlace][0], pathBuffer[bufferPlace][1], lvl, false);
		}else {
			for(int i = 0; i < 16; i++) {
				for(int j = 0; j < 16; j++) {
					if(path[i][j][0] == 0 && path[i][j][1] == 0) {
						path[i][j][0] = 99;
					}
				}
			}
		}
		
	}
	
	public void resetPath() {
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				path[i][j][0] = 0;
				path[i][j][1] = 0;
			}
		}
		for(int i = 0; i < 255; i++) {
			pathBuffer[i][0] = 0;
			pathBuffer[i][1] = 0;
		}
		bufferCount = 0;
		bufferPlace = 0;
	}
	
	public void darken(Graphics g) {
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				if(path[j][i][0] > 5 && path[j][i][0] != 100) {
					g.drawImage(ResourceManager.getImage(LairGame.SHADOW_RSC), i*48, j*48);
				}
			}
		}
	}
}


















