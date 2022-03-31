package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
문제를 이해하는 데 많은 시간이 걸렸다.
(R,C)과 D방향을 시작으로 왼,아래,오,위 순서로 청소 가능한 방향을 찾는다.
청소 가능한 방향을 찾는 반복문 내부에서는 해당 방향으로 nDir을 바꿔가며 (nextY, nextX)가 0인지를 확인한다.
청소가 가능한 구역(0)이라면 dfs로 nextX, nextY, nDir를 보내 청소를 시작한다.
청소가능한 구역으로 이동했기 때문에 해당 청소구역으로 이동하는 dfs가 마치게 되면 return을 해줘야한다.(핵심)
만약 해당 방향을 모두 탐색했을 때 청소가능한 구역이 없다면 로봇의 방향은 해당 구역이 들어왔을때의 방향을 향하고있다.(핵심)
그렇기 때문에 dfs로 바라보는 방향을 기준으로 후진을 한다.(핵심)
여기서 후진을 했을때 벽(1)이라면 return을 해주고 빈 공간(청소는 했지만 빈공간 -1)이라면 다시 4방향으로 재 탐색한다.(핵심)
 */
public class 로봇청소기 {
	static int N;
	static int M;
	static int R;
	static int C;
	static int D;

	static int[][] room;

	// 위, 오, 아래, 왼
	static int[] dX = {0, 1, 0, -1};
	static int[] dY = {-1, 0, 1, 0};

	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];

		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		count = 0;
		dfs(C, R, D);

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}

	static void dfs(int x, int y, int dir) {
		//해당 구역으로 왔을때 벽이라면 반환(후진했을때 벽인 경우)
		if (room[y][x] == 1) {
			return;
		}
		//해당 구역으로 왔을때 빈공간에 청소를 하지 않은 곳이라면 청소 횟수를 카운트하고 청소를 했을음 표시한다
		if (room[y][x] == 0) {
			count++;
			room[y][x] = -1;
		}

		int nDir = dir;
		for (int i = 0; i < 4; i++) {
			nDir = (nDir + 3) % 4;	//현재 바라보는 왼쪽의 방향의 좌표를 알려줄 index 구하기
			int nextX = x + dX[nDir];
			int nextY = y + dY[nDir];

			if (nextX > 0 && nextY > 0 && nextX < M - 1 && nextY < N - 1) {
				if (room[nextY][nextX] == 0) {	//4방향으로 탐색 중 청소가능한 구역을 발견
					dfs(nextX, nextY, nDir);	//해당 구역의 방향으로 변경된 값을 가지고 dfs
					return;	//청소가능한 구역으로 갔기 떄문에 이후 다른 방향이나 후진했을떄의 코드를 막기위함(핵심)
				}
			}
		}
		dfs(x - dX[nDir], y - dY[nDir], dir);	//4가지 방향을 모두 탐색했을때에 못찾은경우 후진
	}
}
