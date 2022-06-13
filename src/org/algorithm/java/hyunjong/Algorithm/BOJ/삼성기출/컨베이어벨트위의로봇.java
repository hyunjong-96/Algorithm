package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇 {
	static int N;
	static int K;
	static int[] belt;
	static int[] durability;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[N*2];
		durability = new int[N*2];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 2*N; i++) {
			durability[i] = Integer.parseInt(st.nextToken());
		}

		int answer = move();

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int move() {
		int turn = 1;

		while (true) {

			moveBelt();

			moveRobot();

			setRobot();

			if (check())
				break;

			turn++;
		}

		return turn;
	}

	static void moveBelt() {
		int b = belt[2*N - 1];
		int d = durability[2*N - 1];
		for (int i = 2*N - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
			durability[i] = durability[i - 1];
		}
		belt[0] = b;
		durability[0] = d;
		belt[N - 1] = 0;
	}

	static void moveRobot() {
		for (int i = N - 1; i > 0; i--) {
			if (belt[i - 1] == 0)
				continue;
			if (belt[i] == 0 && durability[i] > 0) {
				belt[i] = belt[i - 1];
				belt[i - 1] = 0;
				durability[i]--;
			}
		}
		belt[N-1] = 0;
		// belt[0] = 0;
	}

	static void setRobot() {
		if (belt[0] == 0 && durability[0] > 0) {
			belt[0] = 1;
			durability[0]--;
		}
	}

	static boolean check() {
		int count = 0;
		for (int d : durability) {
			if (d == 0) {
				count++;
			}
		}

		return count >= K;
	}
}
