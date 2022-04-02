package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
2차원 배열에서의 최소 거리를 구하는 문제로 보아 BFS로 푸는 구현문제라고 생각했다.
조건을 만드는데 많은 애를 먹었었다.
처음에 board를 받을때 빨간공(R)과 파란공(B)의 좌표를 초기화 한후
BFS 초기에 빨란공과 파란공의 좌표와 이동 거리의 정보를 저장하는 class를 만든다.
(R,B의 위치는 동시간대에 위치해있기 때문에 하나의 클래스에서 다뤄주기로 했다)

상하좌우를 움직이면서 벽이 나타날때까지 이동을 한다.
여기서 두가지 케이스가 발생하는데
1. 이동하면서 구멍(O)를 발견하는 경우
2. R과 B의 동선이 겹쳐서 같은 좌표에 위치하는 경우
1의 경우는 구멍을 지났을때 반복문을 빠져나와 빨간공이 나온경우와 파란공이 나온경우를 다뤄준다
1에서 파란공이 먼저 구멍을 빠져나온 경우는 실패한 경우이니 continue를 통해 해당 움직임을 무시하고 다음 움직임으로 이동
빨간공이 먼저 구멍을 빠져나온 경우 구멍에 빠지기 바로 전의 빨간공의 거리 정보에 1을 더해주고 ans에 저장

2의 경우는 상하좌우 각각의 케이스에 따라 공의 위치를 재조정해준다.
각 케이스의 조건은 코드를 보면서 확인.

그리고 가장 까다로웠던 조건인 방문여부이다.
처음에는 방문여부 없이 구현을 헀는데 시간이 너무 오래걸려서 어떻게 구현해야하나 생각하다가
다른 풀이를 확인해보니까 4차원 배열을 사용했었다.(생각하지도 못했다ㅋㅋ)

visit[ry][rx][by][bx]의 배열이 있을때 0번쨰와 1번째의 배열정보는 빨간공의 y축과 x축
그리고 2번째와 3번째의 배열정보는 파란공의 y축과 x축의 저장여부를 초기화한다.
빨간공과 파란공이 이동했을때 2차원배열로 따로따로 다루는것보다 4차원배열로 다루는게 자세히 이해는 하지 못했지만 표면적으로는 이해할수있어 구현할수있었다.
이를 통해 빨간공과 파란공의 위치가 전에 방문했었던 적이 있었다면 큐에 넣어주지 않아 시간을 줄일수 있었다.

마지막으로 문제의 조건에서 10번 이하로 움직였을때 빨간공이 구멍에 도달하지 못했다면 -1을 출력해야한다.
초기에 ans을 -1로 설정해두었기 때문에 currentPoint.distance >= 10일때 빨간공이 구멍이 도달했을때는 11이상의 움직임을 가져야하기 때문에
return으로 bfs를 끝내준다.(currentPoint.distance > 10으로 조건을 설정해놔서 꽤나 시간을 낭비했다.)

 */
public class 구술탈출2 {
	static int N, M;
	static char[][] board;
	static int ans;

	static int[] RPoint = new int[2];    //y,x
	static int[] BPoint = new int[2];    //y,x
	static boolean[][][][] visit;

	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[10][10][10][10];
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (row[j] == 'R') {
					RPoint[0] = i;
					RPoint[1] = j;
				} else if (row[j] == 'B') {
					BPoint[0] = i;
					BPoint[1] = j;
				}
				board[i][j] = row[j];
			}
		}

		ans = -1;
		bfs();

		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(RPoint[0], RPoint[1], BPoint[0], BPoint[1], 0));

		visit[RPoint[0]][RPoint[1]][BPoint[0]][BPoint[1]] = true;

		while (!queue.isEmpty()) {
			Point currentPoint = queue.poll();

			/*
			현재의 상황에서 거리가 10이라면 다음 움직임을 가졌을때 11이 되기때문에 어쨌든 조건을 오버하는것이기 떄문에
			bfs를 끝낸다.
			 */
			if(currentPoint.distance >= 10){
				return;
			}

			for (int i = 0; i < 4; i++) {
				int rny = currentPoint.ry;
				int rnx = currentPoint.rx;
				int bny = currentPoint.by;
				int bnx = currentPoint.bx;

				/*
				다음 좌표값을 현재 공의 좌표를 설정해놓고 해당 방향으로 이동했을때
				벽으로 이동할때까지 좌표를 이동시켜준다.
				 */
				while (board[rny + dy[i]][rnx + dx[i]] != '#') {
					rny += dy[i];
					rnx += dx[i];

					//공을 이동시킬때 'O'을 발견하게 되면 이동 중지.
					if (board[rny][rnx] == 'O') {
						break;
					}

				}
				//빨간공과 동일
				while (board[bny + dy[i]][bnx + dx[i]] != '#') {
					bny += dy[i];
					bnx += dx[i];

					if (board[bny][bnx] == 'O') {
						break;
					}
				}

				/*
				만약 파란공이 구멍에 떨어진 케이스라면 해당 케이스 무시
				 */
				if(board[bny][bnx] == 'O'){
					continue;
				}
				/*
				빨간공만 구멍에 떨어진 케이스라면 BFS끝
				 */
				if(board[rny][rnx] == 'O'){
					ans = currentPoint.distance+1;
					return;
				}

				/*
				빨간공과 파란공이 겹쳤을경우
				위로 이동했을때는 y이 더 큰 공의 y좌표를 +1
				왼쪽으로 이동했을때는 x가 더 큰 공의 x좌표를 +1
				아래로 이동했을때는 y가 더 작은 공의 y좌표를 -1
				오른쪽으로 이동했을때는 x가 더 작은 공의 x좌표를 -1
				 */
				if (rny == bny && rnx == bnx) {
					if (i == 0) {
						if (currentPoint.ry < currentPoint.by) {
							bny++;
						} else {
							rny++;
						}
					} else if (i == 1) {
						if (currentPoint.rx < currentPoint.bx) {
							bnx++;
						} else {
							rnx++;
						}
					} else if (i == 2) {
						if (currentPoint.ry < currentPoint.by) {
							rny--;
						} else {
							bny--;
						}
					} else {
						if (currentPoint.rx < currentPoint.bx) {
							rnx--;
						} else {
							bnx--;
						}
					}
				}

				/*
				각 공의 좌표가 방문하지 않았던 좌표라면
				큐에 넣어줘서 다음 움직임을 수행해준다.
				 */
				if (!visit[rny][rnx][bny][bnx]) {
					visit[rny][rnx][bny][bnx] = true;
					queue.add(new Point(rny, rnx, bny, bnx, currentPoint.distance + 1));
				}
			}
		}
	}

	static class Point {
		int ry;
		int rx;
		int by;
		int bx;
		int distance;

		public Point(int ry, int rx, int by, int bx, int distance) {
			this.ry = ry;
			this.rx = rx;
			this.by = by;
			this.bx = bx;
			this.distance = distance;
		}
	}
}
