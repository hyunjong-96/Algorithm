package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
주사위를 어떻게 구현하느 냐가 이 문제의 핵심이것같다.
물론 나는 다른 사람의 방법을 보고 풀수있었다
주사위는 1~6까지의 index를 가지고 주사위를 어느 방향으로 이동하냐에 따라 각 index의 값을 변경해준다.
ex) 남쪽으로 이동 int tmp = dice[1], dice[1] = dice[2], dice[2] = dice[6], dice[6] = dice[5], dice[5] = tmp
이렇게 이동할때 마다 주사위의 값이 어디로 위치하느냐로 변경해주면 dice[1]은 위쪽, dice[6]은 아래쪽을 항상 바라보게 된다.
 */
public class 주사위굴리기 {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dice = new int[7];
		int[] move = new int[K];
		st = new StringTokenizer(br.readLine(), " ");
		for (int k = 0; k < K; k++) {
			move[k] = Integer.parseInt(st.nextToken());
		}

		int ny = X;
		int nx = Y;
		for (int k : move) {
			//방향 배열에서 각 index를 문제에서 주어진 방향 값의 -1로 설정해주었기 떄문에 k-1로 비교해준다.
			//문제 배열의 범위에서 벗어나게 되면 해당 움직임은 무시되어야한다.
			if (nx + dx[k-1] < 0 || ny + dy[k-1] < 0 || nx + dx[k-1] >= M || ny + dy[k-1] >= N)
				continue;

			nx += dx[k-1];
			ny += dy[k-1];

			int tmp = dice[1];
			switch (k) {
					//동쪽
				case 1:
					dice[1] = dice[4]; dice[4] = dice[6]; dice[6] = dice[3]; dice[3] = tmp;
					break;
					//서쪽
				case 2:
					dice[1] = dice[3]; dice[3] = dice[6]; dice[6] = dice[4]; dice[4] = tmp;
					break;
					//북쪽
				case 3:
					dice[1] = dice[5]; dice[5] = dice[6]; dice[6] = dice[2]; dice[2] = tmp;
					break;
					//남쪽
				case 4:
					dice[1] = dice[2]; dice[2] = dice[6]; dice[6] = dice[5]; dice[5] = tmp;
					break;
			}
			//문제 배열의 값이 0이라면 주사위의 밑부분의 값을 복사
			if(map[ny][nx] == 0){
				map[ny][nx] = dice[6];
				//문자 배열의 값이0이 아니라면 주사위 밑부분에 배열값을 복사한후 문제 배열의 값을 0으로 변경
			}else{
				dice[6] = map[ny][nx];
				map[ny][nx] = 0;
			}

			sb.append(dice[1]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
