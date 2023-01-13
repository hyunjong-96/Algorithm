package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class EASY_2048_RE {
	static int answer = 0;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		answer = 0;
		move(map, 0);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void move(int[][] map, int depth) {
		if (depth == 5) {
			int maxValue = findMax(map);
			answer = Math.max(maxValue, answer);
			return;
		}

		int[][] upMap = moveUp(map);
		move(upMap, depth + 1);

		int[][] downMap = moveDown(map);
		move(downMap, depth + 1);

		int[][] leftMap = moveLeft(map);
		move(leftMap, depth + 1);

		int[][] rightMap = moveRight(map);
		move(rightMap, depth + 1);

	}

	static int[][] moveUp(int[][] map) {

		int[][] newMap = new int[N][N];

		for (int x = 0; x < N; x++) {
			Deque<Block> dq = new ArrayDeque<>();
			for (int y = 0; y < N; y++) {

				// int inValue = map[y][x];

				// while(!dq.isEmpty() && dq.peekLast() == inValue){
				// 	dq.pollLast();
				// 	inValue *= 2;
				// }
				// dq.offerLast(inValue);
				if (!dq.isEmpty() && map[y][x] != 0 && dq.peekLast().num == map[y][x] && !dq.peekLast().crash) {
					dq.pollLast();
					dq.offerLast(new Block(map[y][x] * 2, true));
				} else if(map[y][x] != 0){
					dq.offerLast(new Block(map[y][x], false));
				}
			}

			int y = 0;
			while (!dq.isEmpty()) {
				newMap[y++][x] = dq.pollFirst().num;
			}
		}

		return newMap;
	}

	static int[][] moveDown(int[][] map) {

		int[][] newMap = new int[N][N];

		for (int x = 0; x < N; x++) {
			Deque<Block> dq = new ArrayDeque<>();
			for (int y = N - 1; y >= 0; y--) {
				if (!dq.isEmpty() && map[y][x] != 0 && dq.peekLast().num == map[y][x] && !dq.peekLast().crash) {
					dq.pollLast();
					dq.offerLast(new Block(map[y][x] * 2, true));
				} else if(map[y][x] != 0){
					dq.offerLast(new Block(map[y][x], false));
				}
			}

			int y = N - 1 ;
			while (!dq.isEmpty()) {
				newMap[y--][x] = dq.pollFirst().num;
			}
		}

		return newMap;
	}

	static int[][] moveLeft(int[][] map) {

		int[][] newMap = new int[N][N];

		for (int y = 0; y < N; y++) {
			Deque<Block> dq = new ArrayDeque<>();
			for (int x = 0; x < N; x++) {
				if (!dq.isEmpty() && map[y][x] != 0 && dq.peekLast().num == map[y][x] && !dq.peekLast().crash) {
					dq.pollLast();
					dq.offerLast(new Block(map[y][x] * 2, true));
				} else if(map[y][x] != 0){
					dq.offerLast(new Block(map[y][x], false));
				}
			}

			int x = 0;
			while (!dq.isEmpty()) {
				newMap[y][x++] = dq.pollFirst().num;
			}
		}

		return newMap;
	}

	static int[][] moveRight(int[][] map) {

		int[][] newMap = new int[N][N];

		for (int y = 0; y < N; y++) {
			Deque<Block> dq = new ArrayDeque<>();
			for (int x = N - 1; x >= 0; x--) {
				if (!dq.isEmpty() && map[y][x] != 0 && dq.peekLast().num == map[y][x] && !dq.peekLast().crash) {
					dq.pollLast();
					dq.offerLast(new Block(map[y][x] * 2, true));
				} else if(map[y][x] != 0){
					dq.offerLast(new Block(map[y][x], false));
				}
			}

			int x = N - 1;
			while (!dq.isEmpty()) {
				newMap[y][x--] = dq.pollFirst().num;
			}
		}

		return newMap;
	}

	static int findMax(int[][] map) {
		int maxValue = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maxValue = Math.max(maxValue, map[i][j]);
			}
		}

		return maxValue;
	}

	static class Block{
		int num;
		boolean crash;
		public Block(int num, boolean isCrash){
			this.num = num;
			crash = isCrash;
		}
	}
}
