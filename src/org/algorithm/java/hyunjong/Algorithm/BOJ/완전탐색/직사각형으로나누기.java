package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
3개의 직사각형으로 나누는 방법
1. 모두 세로
2. 모두 가로
3. 왼쪽 하나 세로 오른쪽 두개 가로
4. 왼쪽 두개 가로 하나 세로
5. 위쪽 하나 가로 아래 두개 가로
6. 위쪽 두개 가로 아래 하나 가로
 */
public class 직사각형으로나누기 {
	static int[][] map;
	static long[][] sum;

	static long max;
	static long w1;
	static long w2;
	static long w3;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];    //직사각형 각각의 자연수 저장
		sum = new long[N + 1][M + 1];    //해당 index까지의 합 저장

		for (int i = 1; i <= N; i++) {
			String[] stArray = br.readLine().split("");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(stArray[j-1]);
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + map[i][j];
			}
		}

		//1번 방법
		max = Integer.MIN_VALUE;
		for (int y = 1; y <= N - 2; y++) {
			for (int y2 = y + 1; y2 <= N - 1; y2++) {
				w1 = sum(1, 1, M, y);
				w2 = sum(1, y + 1, M, y2);
				w3 = sum(1, y2 + 1, M, N);

				getMax();
			}
		}

		//2번 방법
		for (int x = 1; x <= M - 2; x++) {
			for (int x2 = x + 1; x2 <= M - 1; x2++) {
				w1 = sum(1, 1, x, N);
				w2 = sum(x + 1, 1, x2, N);
				w3 = sum(x2+1, 1, M, N);

				getMax();
			}
		}

		//3번 방법
		for (int x = 1; x <= M - 1; x++) {
			for (int y = 1; y <= N - 1; y++) {
				w1 = sum(1, 1, x, N);
				w2 = sum(x + 1, 1, M, y);
				w3 = sum(x + 1, y + 1, M, N);

				getMax();
			}
		}

		//4번 방법
		for (int x = 1; x <= M - 1; x++) {
			for (int y = 1; y <= N - 1; y++) {
				w1 = sum(1, 1, x, y);
				w2 = sum(1, y + 1, x, N);
				w3 = sum(x + 1, 1, M, N);

				getMax();
			}
		}

		//5번 방법
		for (int y = 1; y <= N - 1; y++) {
			for (int x = 1; x <= M - 1; x++) {
				w1 = sum(1, 1, M, y);
				w2 = sum(1, y + 1, x, N);
				w3 = sum(x + 1, y + 1, M, N);

				getMax();
			}
		}

		//6번 방법
		for (int x = 1; x <= M - 1; x++) {
			for (int y = 1; y <= N - 1; y++) {
				w1 = sum(1, 1, x, y);
				w2 = sum(x + 1, 1, M, y);
				w3 = sum(1, y + 1, M, N);

				getMax();
			}
		}
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}

	//넓이 구하기 : https://log-laboratory.tistory.com/128
	static private long sum(int x1, int y1, int x2, int y2) {
		return sum[y2][x2] - sum[y2][x1 - 1] - sum[y1 - 1][x2] + sum[y1 - 1][x1 - 1];
	}

	static void getMax() {
		if (max < w1 * w2 * w3) {
			max = w1 * w2 * w3;
		}
	}
}
