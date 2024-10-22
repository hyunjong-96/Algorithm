package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.LinkedList;
import java.util.Queue;

public class 개입맵최단거리 {
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,-1,0,1};
	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps));
	}

	static int solution(int[][] maps){
		return bfs(maps);
	}

	static int bfs(int[][] maps){
		int N = maps.length;
		int M = maps[0].length;
		int n = N-1;
		int m = M-1;

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visit = new boolean[N][M];

		queue.offer(new int[]{0,0,1});
		visit[0][0] = true;

		while(!queue.isEmpty()){
			int[] current = queue.poll();
			int y = current[0];
			int x = current[1];
			int count = current[2];

			if(y==n && x==m) return count;

			for(int d=0;d<4;d++){
				int ny = y+dy[d];
				int nx = x+dx[d];
				if(ny>=0&&nx>=0&&ny<N&&nx<M&&maps[ny][nx]!=0&&!visit[ny][nx]){
					queue.offer(new int[]{ny,nx,count+1});
					visit[ny][nx] = true;
				}
			}
		}

		return -1;
	}
}
