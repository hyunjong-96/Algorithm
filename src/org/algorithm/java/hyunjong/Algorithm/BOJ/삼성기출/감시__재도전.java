package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 감시__재도전 {
	static int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	static int[][][] cctvs = {
		{},
		{{0}, {1}, {2}, {3}},
		{{0, 2}, {1, 3}},
		{{0, 3}, {0, 1}, {1, 2}, {2, 3}},
		{{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {0, 2, 3}},
		{{0, 1, 2, 3}}
	};
	static List<int[]> cctvPos;
	static int N;
	static int M;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		cctvPos = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					cctvPos.add(new int[] {i, j});
				}
			}
		}

		answer = Integer.MAX_VALUE;
		turnCCTV(map, 0, cctvPos.size());

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void turnCCTV(int[][] map, int cctvIdx, int limit){
		if(cctvIdx == limit){
			int viewCount = 0;
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(map[i][j]==0) viewCount++;
				}
			}
			answer = Math.min(answer, viewCount);
			return;
		}

		int cctv = map[cctvPos.get(cctvIdx)[0]][cctvPos.get(cctvIdx)[1]];
		for(int[] cctvDirection : cctvs[cctv]){
			int[][] cloneMap = getCloneMap(map);
			detecting(cloneMap, cctvDirection, cctvIdx);
			turnCCTV(cloneMap, cctvIdx+1, limit);
		}
	}

	static void detecting(int[][] map, int[] cctvDirection, int cctvIdx){

		for(int d : cctvDirection){
			int ny = cctvPos.get(cctvIdx)[0];
			int nx = cctvPos.get(cctvIdx)[1];
			while(ny>=0 && nx>=0 && ny<N && nx<M && map[ny][nx] != 6){
				if(map[ny][nx] == 0) map[ny][nx] = -1;
				ny += direction[d][0];
				nx += direction[d][1];
			}
		}
	}

	static int[][] getCloneMap(int[][] map){
		int[][] cloneMap = new int[N][M];

		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				cloneMap[i][j] = map[i][j];
			}
		}

		return cloneMap;
	}
}
