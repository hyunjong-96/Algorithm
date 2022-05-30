package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 새로운게임2 {
	static int N;
	static int K;
	static int[][] map;
	static List<Unit>[][] unitMap;
	static Unit[] units;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		unitMap = new ArrayList[N][N];
		units = new Unit[K];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				unitMap[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			if (d == 1) {
				d = 3;
			} else if (d == 2) {
				d = 1;
			} else if (d == 3) {
				d = 0;
			} else {
				d = 2;
			}
			units[i] = new Unit(y, x, i, d);
			unitMap[y][x].add(units[i]);

		}

		int turn = 0;
		int result = -1;
		while (turn++ <= 1000) {
			if(!move(turn)){
				result = turn;
				break;
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	static boolean move(int turn) {
		for (int i = 0; i < K; i++) {
			Unit current = units[i];
			int y = current.y;
			int x = current.x;
			int ny = current.y+dy[current.direction];
			int nx = current.x+dx[current.direction];

			//파란색 || 벽
			if(ny<0 || nx<0 || ny>=N || nx>=N || map[ny][nx] == 2){
				int reverseDirection = (current.direction+2)%4;
				int reverseY = y+dy[reverseDirection];
				int reverseX = x+dx[reverseDirection];
				current.direction = reverseDirection;

				if(reverseY>=0 && reverseX>=0 && reverseY<N && reverseX<N && map[reverseY][reverseX]!=2){
					i--;
					continue;
				}
			}
			//빨간색 || 흰색
			else{
				List<Unit> group = new ArrayList<>();
				boolean flag = false;

				//현재 말 위치에 있는 말들
				for(int j=0;j<unitMap[y][x].size();j++){
					Unit unit = unitMap[y][x].get(j);

					if(unit.num == current.num){
						flag = true;
						unit.y = ny;
						unit.x = nx;
						group.add(unit);
						unitMap[y][x].remove(unit);
						j--;
						continue;
					}

					if(flag){
						unit.y = ny;
						unit.x = nx;
						group.add(unit);
						unitMap[y][x].remove(unit);
						j--;
					}
				}

				if(map[ny][nx]==0){
					for(int k=0;k<group.size();k++){
						unitMap[ny][nx].add(group.get(k));
					}
				}else if(map[ny][nx]==1){
					for(int k=group.size()-1;k>=0;k--){
						unitMap[ny][nx].add(group.get(k));
					}
				}

				if(unitMap[ny][nx].size()>=4){
					return false;
				}
			}
		}
		return true;
	}

	static class Unit {
		int y;
		int x;
		int num;
		int direction;

		public Unit(int y, int x, int num, int direction) {
			this.y = y;
			this.x = x;
			this.num = num;
			this.direction = direction;
		}
	}
}
