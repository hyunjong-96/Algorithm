package org.algorithm.java.hyunjong.Algorithm.카카오;

import java.util.LinkedList;
import java.util.Queue;

public class 컬러링북 {
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] result = solution(m,n,picture);
		for(int r : result){
			System.out.println(r);
		}
	}

	static int[] dx = {0,-1,0,1};
	static int[] dy = {-1,0,1,0};
	static boolean[][] visit;
	static int ans;
	static int M;
	static int N;
	static int[][] picture;

	/*
	컬러링북은 bfs로 풀수 있는 문제.
	picutre에서 0값을 제외한 값의 좌표를 bfs해서 인접한 색의 좌표를 모두 방문하여 area를 구하여 반환.
	그리고 위의 조건을 만족했을때 numberOfArea를 하나씩 카운트 해서 같은 색을 가지며 인접한 좌표의 그룹의 갯수를 구함.
	 */
	static public int[] solution(int m, int n, int[][] picture_arr) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		M = m;
		N = n;
		picture = picture_arr;
		visit = new boolean[m][n];
		ans = 0;
		for(int i=0;i<m*n;i++){
			if(picture[i/n][i%n] != 0 && !visit[i/n][i%n]){
				visit[i/n][i%n] = true;
				maxSizeOfOneArea = Math.max(bfs(i/n,i%n,picture[i/n][i%n]),maxSizeOfOneArea);
				numberOfArea++;
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	static int bfs(int y, int x, int color){
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(y,x));

		int area=1;
		while(!queue.isEmpty()){
			Point p = queue.poll();

			for(int i=0;i<4;i++){
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(nx>=0&&ny>=0&&nx<N&&ny<M && !visit[ny][nx] && picture[ny][nx] == color){
					visit[ny][nx] = true;
					queue.add(new Point(ny,nx));
					area++;
				}
			}
		}
		return area;
	}
}

class Point{
	int y;
	int x;
	public Point(int y,int x){
		this.y = y;
		this.x = x;
	}
}
