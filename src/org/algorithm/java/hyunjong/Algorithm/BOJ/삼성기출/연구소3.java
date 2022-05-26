package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소3 {
	static int N;
	static int M;
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static List<Virus> virusList;
	static Virus[] activeVirus;
	static int spaceCount;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		virusList = new ArrayList<>();
		activeVirus = new Virus[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					spaceCount++;
				else if (map[i][j] == 2)
					virusList.add(new Virus(i, j));
			}
		}

		if (spaceCount == 0) {
			answer = 0;
		} else {
			answer = Integer.MAX_VALUE;
			choiceVirus(0, 0);
			answer = answer == Integer.MAX_VALUE ? -1 : answer;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int spreadVirus() {
		Queue<Virus> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];

		for (Virus v : activeVirus) {
			queue.add(new Virus(v.y,v.x));
			visit[v.y][v.x] = true;
		}
		int time = 0;
		int subSpaceCount = spaceCount;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Virus current = queue.poll();

				for(int j=0;j<4;j++){
					int ny = current.y+dy[j];
					int nx = current.x+dx[j];

					if(ny>=0 && nx>=0 && ny<N && nx<N && !visit[ny][nx] && (map[ny][nx]==0 || map[ny][nx]==2)){
						visit[ny][nx] = true;
						queue.add(new Virus(ny,nx));
						if(map[ny][nx] == 0) subSpaceCount--;
					}
				}
			}
			time++;

			if(subSpaceCount == 0){
				return time;
			}
		}
		return -1;
	}

	static void choiceVirus(int idx, int dept) {
		if (dept == M) {
			int takeTime = spreadVirus();
			if(takeTime != -1){
				answer = Math.min(answer, takeTime);
			}
			return;
		}

		for (int i = idx; i < virusList.size(); i++) {
			activeVirus[dept] = virusList.get(i);
			choiceVirus(i+1, dept+1);
		}
	}

	static class Virus {
		int y;
		int x;

		public Virus(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
