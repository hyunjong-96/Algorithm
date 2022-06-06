package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 청년상어 {
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};

	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] map = new int[4][4];
		// List<Fish> fishList = new ArrayList<>();
		Fish[] fishes = new Fish[17];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 4; j++) {
				int number = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken()) - 1;

				map[i][j] = number;
				fishes[number] = new Fish(number, i, j, d, false, false);
			}
		}

		Fish eatFish = fishes[map[0][0]];
		eatFish.isDie = true;
		map[0][0] = -1;
		Fish[] cloneFishes = fishClone(fishes);
		int[][] cloneMap = mapClone(map);

		answer = 0;

		hunt(0, 0, eatFish.d, eatFish.number, cloneMap, cloneFishes);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void moveFish(int[][] map, Fish[] fishes) {
		for (int s=1;s<17;s++) {
			Fish currentFish = fishes[s];
			if(currentFish.isDie) continue;
			int currentY = currentFish.y;
			int currentX = currentFish.x;
			for (int i = 0; i < 8; i++) {
				int nd = (currentFish.d + i)%8;
				int ny = currentFish.y + dy[nd];
				int nx = currentFish.x + dx[nd];

				if (ny < 4 && nx < 4 && ny >= 0 && nx >= 0 && map[ny][nx] != -1) {
					if (map[ny][nx] == 0) {
						map[currentY][currentX] = 0;
						map[ny][nx] = currentFish.number;
						currentFish.y = ny;
						currentFish.x = nx;
					} else {
						Fish changeFish = fishes[map[ny][nx]];

						changeFish.y = currentY;
						changeFish.x = currentX;
						currentFish.y = ny;
						currentFish.x = nx;

						map[currentY][currentX] = changeFish.number;
						map[ny][nx] = currentFish.number;

					}
					currentFish.d = nd;
					break;
				}
			}
		}
	}

	static void hunt(int sy, int sx, int sd, int eat, int[][] map, Fish[] fishes) {
		answer = Math.max(answer, eat);

		//물고기 움직임
		moveFish(map, fishes);

		//상어 움직임
		//해당 방향으로 이동가능한 3가지의 좌표로 dfs한다.
		//다른 재귀에 영향을 주지 않도록 map과 fishList는 clone해서 변경된 정보를 갱신후 dfs한다.
		for (int i = 1; i < 4; i++) {
			int nsy = sy+dy[sd]*i;
			int nsx = sx+dx[sd]*i;
			if(nsy<4 && nsx<4 && nsx>=0 && nsy>=0 && map[nsy][nsx] != 0){
				Fish eatFish = fishes[map[nsy][nsx]];
				int nsd = eatFish.d;

				int[][] cloneMap = mapClone(map);
				Fish[] cloneFishes = fishClone(fishes);
				cloneMap[sy][sx] = 0;
				cloneMap[nsy][nsx] = -1;
				cloneFishes[eatFish.number].isDie = true;

				hunt(nsy, nsx, nsd, eat+eatFish.number, cloneMap, cloneFishes);
			}
		}
	}

	static int[][] mapClone(int[][] map){
		int[][] cloneMap = new int[4][4];

		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				cloneMap[i][j] = map[i][j];
			}
		}

		return cloneMap;
	}

	static Fish[] fishClone(Fish[] fish){
		Fish[] cloneFish = new Fish[17];

		for(int i=1;i<17;i++){
			Fish f = fish[i];
			cloneFish[i] = new Fish(f.number, f.y, f.x, f.d, f.isDie, f.isShark);
		}

		return cloneFish;
	}

	static class Fish {
		int number;
		int y;
		int x;
		int d;
		boolean isDie;
		boolean isShark;

		public Fish(int number, int y, int x, int d, boolean isDie, boolean isShark) {
			this.number = number;
			this.y = y;
			this.x = x;
			this.d = d;
			this.isDie = isDie;
			this.isShark = isShark;
		}
	}
}
