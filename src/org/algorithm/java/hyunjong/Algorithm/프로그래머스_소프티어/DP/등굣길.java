package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.DP;

import java.util.LinkedList;
import java.util.Queue;

/*
2차원 배열에 최소거리 키워드를 보자마자 bfs로 풀어야지 했는데 최소거리를 가지는 경로 갯수도 있어서 조금 까다로운 bfs인줄알았다.
결과는 정확성에서 1개 시간초과, 효율성 0점...
시간 초과는 예상했다. 격자의 최대 크기가 100*100인데다가 방문처리도 하지못하고 break도 못거는 코드로 구현을 했으니..
문제 분류인 DP로 어떻게 푸나 궁금했다.
개념은 생각보다 간단했다.
BFS로 인접한 좌표(아래, 오른쪽)를 접근하면서 현재 좌표에는 해당 좌표로 접근할수 있는 경로 갯수를 저장해주는것이다.
예를 들어 map[i][j]좌표의 값을 구할때 해당 좌표로 접근가능한 좌표는 map[i-1][j]와 map[i][j-1]의 좌표이다.
그 두 좌표에 저장되어있는 접근 경로 갯수를 합해서 더해주면된다. DP인것이다.
이때 접근하는 좌표값이 -1(웅덩이)이라면 다른 한쪽의 좌표값만 넣어주면된다. 해당 좌표에 접근하는 경로가 두가지 뿐이므로
한쪽 경로가 웅덩이로 막혀있다면 무조건 다른 한쪽은 뚤려있게 되어있기 때문이다.
예를 들어 출발좌표(1,1)에서 인접 좌표인 아래와 오른쪽 좌표가 0이라고할때, map[1][2]와 map[2][1]은 1로 저장하고
map[2][2]의 좌표는 왼쪽에서 map[2][1]에서 1, 위쪽에서 map[1][2]에서 1로 동시에 접근이 가능하기 떄문에 2를 저장해준다.
그리고 map[n][m]의 좌표의 값을 반환하면된다.

그리고 내가 실수하고 있었던 부분이 나는 항상 좌표를 (y,x)로 생각하고 푸는데 해당 문제에서 puddles에서 제공하는 좌표는 (x,y)여서 배열범위를 벗어났었다.
문제에 학교좌표가 (m,n)이라고 했으므로 제공하는 좌표의 값에대한 힌트가 있었다. 문제를 꼼꼼히 읽어보자.
 */
public class 등굣길 {
	public static void main(String[] args) {
		int[][] puddles = {{2, 1}, {2, 2}, {2, 3}, {4, 2}, {4, 3}, {4, 4}, {6, 2}, {6, 3}};
		System.out.println(solution(7,4,puddles));
	}
	static int[][] map;
	static int M;
	static int N;
	static int mod = 1000000007;

	static int[] dx = {0,1};
	static int[] dy = {1,0};
	static public int solution(int m, int n, int[][] puddles) {
		//map = new int[N][M];
		M = m;
		N = n;
		map = new int[n+1][m+1];
		//puddles좌표를 -1로 초기화
		for(int i=0;i<puddles.length;i++){
			int x = puddles[i][0];
			int y = puddles[i][1];
			map[y][x] = -1;
		}
		bfs();

		return map[n][m]%mod;
	}


	//bfs를 통해 현재 좌표에서 위,왼쪽 map[j-1][i], map[j][i-1]값의 합을 map[j][i]에 저장한다.
	//만약 위나 왼쪽 좌표의 값이-1(웅덩이)라면 -1이 아닌 값만 더해준다.
	static void bfs(){
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(1,1));
		map[1][1] = 1;

		while(!queue.isEmpty()){
			Point current = queue.poll();

			if(current.y == N && current.x == M){
				break;
			}

			for(int i=0;i<2;i++){
				int ny = current.y+dy[i];
				int nx = current.x+dx[i];
				if(ny>0 && nx>0 && ny<=N && nx<=M && map[ny][nx] == 0){
					int leftPoint = map[ny][nx-1]%mod;
					int upPoint = map[ny-1][nx]%mod;

					if(leftPoint == -1){
						map[ny][nx] = upPoint;
					}else if(upPoint == -1){
						map[ny][nx] = leftPoint;
					}else{
						map[ny][nx] = (upPoint+leftPoint)%mod;
					}
					queue.add(new Point(ny,nx));
				}
			}
		}
	}

	static class Point{
		int y;
		int x;
		public Point(int y,int x){
			this.y= y;
			this.x= x;
		}
	}
	//시간초과 코드
	// static int[][] map;
	// static boolean[][] visit;
	// static int shortDistanceCount;
	// static int M;
	// static int N;
	// static int mod = 1000000007;
	//
	// static int[] dx = {0,1};
	// static int[] dy = {1,0};
	// static int solution(int m,int n, int[][] puddles) {
	// 	M = m;
	// 	N = n;
	// 	// map = new int[n + 1][m + 1];
	// 	map = new int[n+1][m+1];
	// 	visit = new boolean[n + 1][m + 1];
	// 	for (int i = 0; i < puddles.length; i++) {
	// 		int x = puddles[i][0];
	// 		int y = puddles[i][1];
	// 		map[y][x] = 1;
	// 	}
	//
	// 	shortDistanceCount = 0;
	// 	bfs();
	// 	return shortDistanceCount % mod;
	// }
	//
	// static void bfs() {
	// 	Queue<Point> queue = new LinkedList<>();
	// 	queue.add(new Point(1, 1, 0));
	// 	visit[0][0] = true;
	// 	boolean flag = false;
	// 	long shortDistance = 0;
	// 	shortDistanceCount = 0;
	// 	while (!queue.isEmpty()) {
	// 		Point current = queue.poll();
	//
	// 		if (current.y == N && current.x == M) {
	// 			if (!flag) {
	// 				flag = true;
	// 				shortDistance = current.distance;
	// 				shortDistanceCount++;
	// 				shortDistanceCount = shortDistanceCount % mod;
	// 			} else if (flag && current.distance == shortDistance) {
	// 				shortDistanceCount++;
	// 				shortDistanceCount = shortDistanceCount % mod;
	// 			}
	// 		}
	// 		//아래, 오른쪽
	// 		for (int i = 0; i < 2; i++) {
	// 			int ny = current.y + dy[i];
	// 			int nx = current.x + dx[i];
	// 			if (ny <= N && nx <= M && map[ny][nx] != 1) {
	// 				visit[ny][nx] = true;
	// 				queue.add(new Point(ny, nx, (current.distance + 1) % mod));
	// 			}
	// 		}
	// 	}
	// }
	//
	// static class Point {
	// 	int y;
	// 	int x;
	// 	int distance;
	//
	// 	public Point(int y, int x, int distance) {
	// 		this.y = y;
	// 		this.x = x;
	// 		this.distance = distance;
	// 	}
	// }
}
