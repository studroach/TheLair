package TheLair;

public class Objects {
	int x;
	int y;
	int type;
	int state;
	int link;
	int[] area1 = {13, 6, 14, 6};
	int[] fill1 = {1, 1};
	int[] area2 = {14, 2};
	int[] fill2 = {1};
	int[] area3 = {1, 7, 2, 7, 3, 7, 4, 7, 1, 8, 2, 8, 3, 8, 4, 8, 5, 8, 6, 8, 7, 8, 8, 8};
	int[] fill3 = {1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1};
	int[] area4 = {1, 3};
	int[] fill4 = {1};
	int[] area5 = {14, 13, 12, 14, 13, 14, 14, 14};
	int[] fill5 = {0, 1, 0, 0};
	int[] area6 = {12, 11, 13, 11, 13, 12};
	int[] fill6 = {1, 1, 0};
	int[] area7 = {12, 13};
	int[] fill7 = {0};
	int[] area8 = {10, 11, 10, 12, 10, 13, 11, 13};
	int[] fill8 = {1, 0, 0, 0};
	
	public Objects(int ix, int iy, int itype, int istate, int ilink) {
		x = ix;
		y = iy;
		type = itype;
		state = istate;
		link = ilink;
	}
	
	public void lever(LairGame lg, int direction) {
		if(link == 1) {
			for(int i = 0; i < 4; i+=2) {
				if(direction == 1) {
					lg.level.lvl1[area1[i+1]][area1[i]] = 2;
				}else if(direction == 0) {
					lg.level.lvl1[area1[i+1]][area1[i]] = fill1[i/2];
				}
			}
		}else if(link == 2) {
			for(int i = 0; i < 2; i+=2) {
				if(direction == 1) {
					lg.level.lvl2[area2[i+1]][area2[i]] = 2;
				}else if(direction == 0) {
					lg.level.lvl2[area2[i+1]][area2[i]] = fill2[i/2];
				}
			}
			for(int i = 0; i < 24; i+=2) {
				if(direction == 0) {
					lg.level.lvl2[area3[i+1]][area3[i]] = 2;
				}else if(direction == 1) {
					lg.level.lvl2[area3[i+1]][area3[i]] = fill3[i/2];
				}
			}
		}else if(link == 3) {
			for(int i = 0; i < 2; i+=2) {
				if(direction == 1) {
					lg.level.lvl3[area4[i+1]][area4[i]] = 2;
				}else if(direction == 0) {
					lg.level.lvl3[area4[i+1]][area4[i]] = fill4[i/2];
				}
			}
		}else if(link == 4) {
			for(int i = 0; i < 8; i+=2) {
				if(direction == 1) {
					lg.level.lvl3[area5[i+1]][area5[i]] = 2;
				}else if(direction == 0) {
					lg.level.lvl3[area5[i+1]][area5[i]] = fill5[i/2];
				}
				if(lg.level.level3Objects[15].state == 1 && direction == 0) {
					lg.level.lvl3[14][12] = 1;
				}else if(lg.level.level3Objects[15].state == 0 && direction == 0) {
					lg.level.lvl3[14][12] = 0;
				}
			}
		}else if(link == 5) {
			for(int i = 0; i < 6; i+=2) {
				if(direction == 1) {
					lg.level.lvl3[area6[i+1]][area6[i]] = 2;
				}else if(direction == 0) {
					lg.level.lvl3[area6[i+1]][area6[i]] = fill6[i/2];
				}
			}
		}else if(link == 6) {
			for(int i = 0; i < 2; i+=2) {
				if(direction == 0) {
					lg.level.lvl3[area7[i+1]][area7[i]] = 2;
				}else if(direction == 1) {
					lg.level.lvl3[area7[i+1]][area7[i]] = fill7[i/2];
				}
				if(direction == 1 && lg.level.level3Objects[13].state == 1) {
					lg.level.lvl3[14][12] = 0;
				}else if(direction == 0 && lg.level.level3Objects[13].state == 1) {
					lg.level.lvl3[14][12] = 1;
				}
			}
		}else if(link == 7) {
			for(int i = 0; i < 8; i+=2) {
				if(direction == 1) {
					lg.level.lvl3[area8[i+1]][area8[i]] = 2;
				}else if(direction == 0) {
					lg.level.lvl3[area8[i+1]][area8[i]] = fill8[i/2];
				}
			}
		}
	}
}
