package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
처음에 구현했을때는 bfs로 x좌표, y좌표, 좌표까지의 count, 벽 파괴 여부 네 가지를 가지고 있는 클래스를 넣어서
좌표가 N-1, M-1에 도달했을때 결과값을 도출하는 것으로 구현을 했었는데
많은 반례에서 벽을 한번 부수었을때와 한 번도 부수지 않았을 때의 수가 존재했었다
5 5
0 0 0 0 1
1 1 1 0 1
0 0 0 0 1
0 1 1 1 1
0 0 0 1 0 인 배열인 경우 (1, 0) 좌표에서 벽을 부수고 (4,4)를 가는 경우가 최단거리이지만 (4,3)에서 하나의 벽이 더있기 떄문에
-1을 출력하게 된다.
성공 케이스는 벽을 부수지않고 0인 곳으로 갔다가 (4,3)지점에서 벽을 부수고 가는 방법이 가장 최단거리이다.
이를 구현하기 위해서는 방문여부를 벽을 부수었을때 방문여부와 벽을 부수지않았을때 방문여부로 나누어 만들어야한다.

때문에 visit[0][y][x]와 visit[1][y][x]를 만들어줘야한다. 즉, 3차원 배열을 사용해주어야한다.
visit[0][y][x]는 벽을 부수지 않았을 경우의 좌표 방문여부, visit[1][y][x]는 벽을 부수었을 경우의 좌표 방문여부를 표시해준다.

만약 다음 좌표를 방문했을때 벽을 부수지 않았고 벽을 부수지않은 경우에 방문하지 않은곳, 그리고 방문 좌표가 이동할수 있는곳(0)인 경우
visit[0][nY][nX] = true로 표시해주고 new Point(nX,nY,count+1,false)로 벽을 파괴하지 않음으로 인스턴스 생성후 큐에 넣어준다.

다음 좌표를 방문했을때 벽을 부수지 않았고 이동할수 없는 1일때는 벽을 부수어 줘야 하기 때문에
visit[1][nY][nX] = true로 표시해주고 new Point(nX,nY,count_1,true)로 벽을 파괴 여부와 함께 인스턴스 생성후 큐에 넣어준다.

마지막으로 다음 좌표를 방문했을 때 벽을 부수었었고 벽을 부수었던 경로로 접근하지 않은 좌표이고 이동할수 있는 좌표라면
visit[1][nY][nX] = true, new Point(nX,nY,count+1, true)로 벽 파괴 여부와 함께 벽 파괴 경로의 방문여부를 체크해준다.

이런 조건으로 반복하게 되면 (1,0)에서 벽을 부수었을때 (4,4)로의 접근은 불가능하다.
하지만 벽을 부수지 않고 (4,3)으로 이동한후 (4,3)의 벽을 파괴하고 (4,4)로의 접근은 가능해지게 된다.

이해하면 바로 구현이 가능해지지만 처음에 이해하는데 조금 시간이 걸렸다.
그리고 조건을 잘 선언해줘서 구현해야한다.
 */
public class 벽부수고이동하기 {
	static int N;
	static int M;
	static int ans;

	static int[][] map;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static boolean[][][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[2][N][M];
		for (int i = 0; i < N; i++) {
			String row = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = row.charAt(j)-'0';
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
		visit[0][0][0] = true;	//벽 파괴x 방문여부 초기화
		visit[1][0][0] = true;	//벽 파괴o 방문여부 초기화
		queue.add(new Point(0, 0, 1, false));	//처음에는 벽을 파괴하지 않았음과 시작 좌표를 큐에 넣어준다.

		while (!queue.isEmpty()) {
			Point currentPoint = queue.poll();

			//(N-1, M-1)의 좌표에 접근했을때만 ans를 재선언해준다.
			if (currentPoint.x == M - 1 && currentPoint.y == N - 1) {
				ans = currentPoint.count;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nX = currentPoint.x + dx[i];
				int nY = currentPoint.y + dy[i];

				if (nX >= 0 && nY >= 0 && nX < M && nY < N) {
					if (map[nY][nX] == 0) {	//다음 좌표가 벽없이 이동가능할때
						/*
						벽 파괴 전적이 없고 벽을 파괴하지 않은 경로로 방문 경험이 없다면
						벽을 파괴x 전적의 방문여부를 재선언
						그리고 다음 좌표와 파괴하지 않음을 가지고 큐에 넣어준다.
						 */
						if (!currentPoint.isBreak && !visit[0][nY][nX]) {
							visit[0][nY][nX] = true;
							queue.add(new Point(nX, nY, currentPoint.count + 1, false));
						}
						/*
						만약 벽파괴 전적이 있고 다음 좌표가 파괴 전적 경로에서 접근한 적이 없다면
						벽 파괴 전적의 방문 재선언 후 벽 파괴 경험과 다음 좌표를 가지고 큐에 넣어준다.
						 */
						else if (currentPoint.isBreak && !visit[1][nY][nX]) {
							visit[1][nY][nX] = true;
							queue.add(new Point(nX, nY, currentPoint.count + 1, true));
						}
					}
					/*
					다음 좌표가 1일때
					벽을 파괴하지 않았을 경우에만 접근이 가능하므로
					해당 조건을 만족하면 다음 좌표부터는 파괴 경험 경로의 방문여부만 확인할수 있게 된다.
					 */
					else if (map[nY][nX] == 1) {
						if (!currentPoint.isBreak) {
							visit[1][nY][nX] = true;
							queue.add(new Point(nX, nY, currentPoint.count + 1, true));
						}
					}
				}
			}
		}
	}

	static class Point {
		int x;
		int y;
		int count;
		boolean isBreak;

		public Point(int x, int y, int count, boolean isBreak) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.isBreak = isBreak;
		}
	}

	// public static void main(String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 	StringBuilder sb = new StringBuilder();
	//
	// 	StringTokenizer st = new StringTokenizer(br.readLine());
	// 	N = Integer.parseInt(st.nextToken());
	// 	M = Integer.parseInt(st.nextToken());
	// 	map = new int[N][M];
	// 	visit = new boolean[N][M];
	// 	for (int i = 0; i < N; i++) {
	// 		String row = br.readLine();
	// 		for (int j = 0; j < M; j++) {
	// 			map[i][j] = row.charAt(j)-'0';
	// 		}
	// 	}
	//
	// 	visit[0][0] = true;
	// 	ans = Integer.MAX_VALUE;
	// 	dfs(0, 0, 1, false);
	//
	// 	if(ans == Integer.MAX_VALUE){
	// 		sb.append(-1);
	// 	}else{
	// 		sb.append(ans);
	// 	}
	// 	bw.write(sb.toString());
	// 	bw.flush();
	// 	bw.close();
	// }
	//
	// static void dfs(int x, int y, int count, boolean isBreak) {
	// 	if (x == M-1 && y == N-1) {
	// 		ans = Math.min(ans, count);
	// 		return;
	// 	}
	//
	// 	for (int i = 0; i < 4; i++) {
	// 		int nX = x + dx[i];
	// 		int nY = y + dy[i];
	//
	// 		if (nX >= 0 && nY >= 0 && nX < M && nY < N) {
	// 			if (isBreak && map[nY][nX] == 0 && !visit[nY][nX]) {
	// 				visit[nY][nX] = true;
	// 				dfs(nX, nY, count + 1, true);
	// 				visit[nY][nX] = false;
	// 			} else if (!isBreak && !visit[nY][nX]) {
	// 				visit[nY][nX] = true;
	// 				if (map[nY][nX] == 0) {
	// 					dfs(nX, nY, count + 1, false);
	// 				} else {
	// 					dfs(nX, nY, count + 1, true);
	// 				}
	// 				visit[nY][nX] = false;
	// 			}
	// 		}
	// 	}
	// }
}
