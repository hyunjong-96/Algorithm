package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 스티커붙이기 {
	static int[][] notebook;
	static int[][] sticker;
	static int N;
	static int M;
	static int R;
	static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		notebook = new int[N][M];

		while (K-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			sticker = new int[R][C];

			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			out:
			for (int r = 0; r < 4; r++) {
				for (int i = 0; i <= N - R; i++) {
					for (int j = 0; j <= M - C; j++) {
						if (isAttachable(i, j))
							break out;
					}
				}
				rotate();
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (notebook[i][j] == 1)
					answer++;
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void rotate() {
		int[][] tmp = new int[C][R];
		for (int c = 0; c < C; c++) {
			for (int r = 0; r < R; r++) {
				tmp[c][r] = sticker[R - 1 - r][c];
			}
		}

		sticker = tmp;

		int swap = R;
		R = C;
		C = swap;
	}

	static boolean isAttachable(int startR, int startC) {
		for (int stickerR = 0; stickerR < R; stickerR++) {
			for (int stickerC = 0; stickerC < C; stickerC++) {
				if (notebook[startR + stickerR][startC + stickerC] == 1 && sticker[stickerR][stickerC] == 1)
					return false;
			}
		}

		attach(startR, startC);

		return true;
	}

	static void attach(int r, int c) {
		for (int sR = 0; sR < R; sR++) {
			for (int sC = 0; sC < C; sC++) {
				if (sticker[sR][sC] == 1)
					notebook[r + sR][c + sC] = 1;
			}
		}
	}
}
