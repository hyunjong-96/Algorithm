package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 상어초등학교 {
	static int N;
	static int[][] classRoom;
	static int[][] sharks;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		classRoom = new int[N][N];
		sharks = new int[(int)Math.pow(N, 2) + 1][5];
		for (int i = 1; i <= (int)Math.pow(N, 2); i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j <= 4; j++) {
				sharks[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		for (int s = 1; s < sharks.length; s++) {
			setRoom(sharks[s]);
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				answer += getSatisfy(i,j);
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int getSatisfy(int y, int x) {
		int satisfy = 0;
		int likeCount = 0;

		int num = classRoom[y][x];
		int[] shark;
		for(int s=1;s<sharks.length;s++){
			if(sharks[s][0] == num){
				shark = sharks[s];
				for (int i = 0; i < 4; i++) {
					int ny = y + dy[i];
					int nx = x + dx[i];
					if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
						for (int j = 1; j <= 4; j++) {
							if (classRoom[ny][nx] == shark[j]) {
								likeCount++;
								break;
							}
						}
					}
				}
				break;
			}
		}

		if (likeCount == 0) {
			satisfy = 0;
		} else if (likeCount == 1) {
			satisfy = 1;
		} else if (likeCount == 2) {
			satisfy = 10;
		} else if (likeCount == 3) {
			satisfy = 100;
		} else {
			satisfy = 1000;
		}

		return satisfy;
	}

	static void setRoom(int[] shark) {
		PriorityQueue<Room> pq = new PriorityQueue<>();

		//y축
		for (int i = 0; i < N; i++) {
			//x축
			for (int j = 0; j < N; j++) {
				//빈자리라면
				if (classRoom[i][j] == 0) {
					int blankCount = 4;
					int likeCount = 0;
					//인접한 칸
					for (int d = 0; d < 4; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if (ny >= 0 && nx >= 0 && ny < N && nx < N) {
							//좋아하는 친구
							for (int l = 1; l <= 4; l++) {
								if (classRoom[ny][nx] == shark[l]) {
									likeCount++;
									break;
								}
							}
							if (classRoom[ny][nx] != 0)
								blankCount--;
						} else {
							blankCount--;
						}
					}
					pq.offer(new Room(likeCount, blankCount, i, j));
				}
			}
		}

		Room r = pq.poll();
		classRoom[r.row][r.colum] = shark[0];
	}

	static class Room implements Comparable<Room> {
		int like;
		int blank;
		int row;
		int colum;

		public Room(int like, int blank, int row, int colum) {
			this.like = like;
			this.blank = blank;
			this.row = row;
			this.colum = colum;
		}

		@Override
		public int compareTo(Room o1) {
			int result = o1.like - this.like;
			if (result == 0) {
				result = o1.blank - this.blank;
				if (result == 0) {
					result = this.row - o1.row;
					if (result == 0) {
						result = this.colum - o1.colum;
					}
				}
			}

			return result;
		}
	}
}
