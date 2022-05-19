package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 낚시왕 {
	static int R;
	static int C;
	static Shark[][] see;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		see = new Shark[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				see[i][j] = null;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			switch (d) {
				case 1:
					d = 0;
					break;
				case 2:
					d = 2;
					break;
				case 3:
					d = 3;
					break;
				case 4:
					d = 1;
					break;
			}
			s = convertSpeed(s, d);
			see[y][x] = new Shark(y, x, s, z, d);
		}

		answer = 0;
		for (int h = 0; h < C; h++) {
			//낚시
			fishing(h);
			//상어이동
			sharkMove();
		}
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void fishing(int h) {
		for (int i = 0; i < R; i++) {
			if (see[i][h] != null) {
				answer += see[i][h].size;
				see[i][h] = null;
				break;
			}
		}
	}

	static void sharkMove() {
		Shark[][] copySee = new Shark[R][C];
		List<Shark> moveSharkList = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (see[i][j] != null) {
					int move = see[i][j].speed;
					int distance = see[i][j].distance;
					int ny = i;
					int nx = j;
					//상하 이동
					if(distance == 0 || distance == 2){
						while(move-- > 0){
							ny += dy[distance];
							if(ny<0 || ny>=R){
								ny -= dy[distance];
								distance = (distance+2)%4;
								ny += dy[distance];
							}
						}
					}
					//좌우 이동
					else{
						while(move-- > 0){
							nx += dx[distance];
							if(nx<0 || nx>=C){
								nx -= dx[distance];
								distance = (distance+2)%4;
								nx += dx[distance];
							}
						}
					}

					 moveSharkList.add(new Shark(ny, nx, see[i][j].speed, see[i][j].size, distance));
				}
			}
		}

		for(Shark s : moveSharkList){
			if(copySee[s.y][s.x] != null){
				if(copySee[s.y][s.x].size < s.size){
					copySee[s.y][s.x] = s;
				}
			}else{
				copySee[s.y][s.x] = s;
			}
		}
		see = copySee;
	}

	static int convertSpeed(int speed, int distance){
		if(distance == 0 || distance == 2){
			return speed % ((R*2)-2);
		}else{
			return speed % ((C*2)-2);
		}
	}

	static class Shark {
		int y;
		int x;
		int speed;
		int size;
		int distance;

		public Shark(int y, int x, int speed, int size, int distance) {
			this.y = y;
			this.x = x;
			this.speed = speed;
			this.size = size;
			this.distance = distance;
		}
	}

}
