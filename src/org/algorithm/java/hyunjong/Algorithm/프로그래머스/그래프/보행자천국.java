package org.algorithm.java.hyunjong.Algorithm.프로그래머스.그래프;

class 보행자천국 {
	static int MOD = 20170805;
	static int[][] city_map;
	static int M;
	static int N;
	static int answer;
	static int[][] dir = {{0,1},{1,0}};
	static int[][][] count;
	static public int solution(int m, int n, int[][] cityMap) {
		city_map = cityMap;
		M = m;
		N = n;
		answer = 0;
		count = new int[m][n][2];
		count[m-1][n-1][0]=1;
		count[m-1][n-1][1]=1;
		drive(0,0,0);
		// for(int i=0;i<2;i++){
		//     drive(0,0,i);
		// }
		return count[0][0][0]+count[0][0][1];
	}

	static int drive(int y, int x, int d){
		// System.out.println("currentY : "+y+" / currentX : "+x+" / currentDir : "+d+ " / answer : "+answer);
		if(city_map[y][x] == 2 && count[y][x][d]!=0) return count[y][x][d];
		if(y==M-1 && x==N-1) return 1;
		if(count[y][x][0] != 0 && count[y][x][1] != 0) return count[y][x][0]+count[y][x][1];
		// if(count[y][x][d]!=0){
		//     // answer = (answer+1)%MOD;
		//     System.out.println(y+", "+x+" available!");
		//     return count[y][x][d];
		// }


		if(city_map[y][x]==2){
			int nextY = y + dir[d][0];
			int nextX = x + dir[d][1];

			// boolean isAvailable = false;
			if(nextY<M && nextX<N && city_map[nextY][nextX] != 1){
				// if(drive(nextY, nextX, d)) isAvailable = true;
				count[y][x][d] += drive(nextY, nextX, d);
			}
			// check[y][x] = isAvailable;
		}
		else if(city_map[y][x]==0){
			// boolean isAvailable = false;
			for(int i=0;i<2;i++){
				int nextD = (d+i)%2;
				int nextY = y + dir[nextD][0];
				int nextX = x + dir[nextD][1];

				// System.out.println("nextY : "+nextY+" / nextX : "+nextX+" / nextD : "+nextD);
				if(nextY<M && nextX<N && city_map[nextY][nextX] != 1) {
					// if(drive(nextY, nextX, nextD)) isAvailable = true;
					count[y][x][nextD] += drive(nextY, nextX, nextD);
				}
			}
			// check[y][x] = isAvailable;
		}

		return count[y][x][0]+count[y][x][1];
	}

	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		int[][] cityMap = {{0,0,0},{0,0,0},{0,0,0}};
		System.out.println(solution(m,n,cityMap));
	}
}