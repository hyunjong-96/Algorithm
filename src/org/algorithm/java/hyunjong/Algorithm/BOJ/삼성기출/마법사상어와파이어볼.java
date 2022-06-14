package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 마법사상어와파이어볼 {
	static int N;
	static int M;
	static int K;
	static List<Fire>[][] map;

	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new List[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			map[r][c].add(new Fire(m, d, s));
		}

		while (K-- > 0) {
			move();
		}
		int answer = check();

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int check() {
		int sumM = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j].isEmpty()) {
					for (Fire fire : map[i][j]) {
						sumM += fire.m;
					}
				}
			}
		}
		return sumM;
	}

	static void moveFire(int r, int c, Fire fire, List<Fire>[][] cloneMap) {
		int ny = r;
		int nx = c;
		for (int i = 1; i <= fire.s; i++) {
			ny = (ny + dy[fire.d]) % N;
			nx = (nx + dx[fire.d]) % N;


			if (ny < 0) {
				ny = N - 1;
			}
			if (nx < 0) {
				nx = N - 1;
			}
		}

		cloneMap[ny][nx].add(fire);
	}

	static void separateFire(int r, int c, List<Fire>[][] cloneMap) {
		int totalM = 0;
		int totalS = 0;
		int totalSize = cloneMap[r][c].size();

		int evenCount = 0;
		int oddCount = 0;
		for (Fire fire : cloneMap[r][c]) {
			totalM += fire.m;
			totalS += fire.s;

			if(fire.d % 2 ==0) evenCount++;
			else oddCount++;
		}

		cloneMap[r][c].clear();

		int m = totalM / 5;
		int s = totalS / totalSize;

		if (m == 0)
			return;

		if (evenCount == 0 || oddCount == 0) {
			for (int i = 0; i < 4; i++) {
				cloneMap[r][c].add(new Fire(m, 2 * i, s));
			}
		} else {
			for (int i = 0; i < 4; i++) {
				cloneMap[r][c].add(new Fire(m, 1 + 2 * i, s));
			}
		}
	}

	static void move() {
		List<Fire>[][] cloneMap = cloneMap();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j].isEmpty()) {
					int size = map[i][j].size();
					for (int f = 0; f < size; f++) {
						Fire fire = map[i][j].get(f);
						moveFire(i, j, fire, cloneMap);
					}
					map[i][j].clear();
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloneMap[i][j].size() >= 2) {
					separateFire(i, j, cloneMap);
				}
			}
		}

		map = cloneMap;
	}

	static List<Fire>[][] cloneMap() {
		List<Fire>[][] cloneMap = new List[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cloneMap[i][j] = new ArrayList<>();
			}
		}

		// for(int i=0;i<N;i++){
		// 	for(int j=0;j<N;j++){
		// 		for(Fire fire : map[i][j]){
		// 			map[i][j].add(new Fire(fire.m, fire.d, fire.s));
		// 		}
		// 	}
		// }

		return cloneMap;
	}

	static class Fire {
		int m;
		int d;
		int s;

		public Fire(int m, int d, int s) {
			this.m = m;
			this.d = d;
			this.s = s;
		}
	}
}
