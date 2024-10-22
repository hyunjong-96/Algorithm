package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설 {
	public static void main(String[] args) {

	}

	static int N;
	static int cost;
	static int[][][] distanceBoard;
	static boolean[][][] visit;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};

	static public int solution(int[][] board) {
		N = board.length;
		distanceBoard = new int[N][N][4];
		visit = new boolean[N][N][4];
		cost = Integer.MAX_VALUE;
		build(board);

		for(int i=0;i<4;i++){
			if(distanceBoard[N-1][N-1][i] == 0) continue;
			cost = Math.min(cost,distanceBoard[N-1][N-1][i]);
		}
		return cost;
	}

	static void build(int[][] board) {
		Queue<Road> queue = new LinkedList<>();
		queue.offer(new Road(0,0,0,-1));
		visit[0][0][0] = true;
		visit[0][0][1] = true;
		visit[0][0][2] = true;
		visit[0][0][3] = true;

		while(!queue.isEmpty()){
			Road r = queue.poll();

			if(r.y == N-1 && r.x == N-1){
				continue;
			}

			for(int i=0;i<4;i++){
				int ny = r.y+dy[i];
				int nx = r.x+dx[i];

				if(ny>=0 && nx>=0 && ny<N && nx<N && board[ny][nx] != 1){
					int newCost = r.cost;

					if(r.distance == -1 || r.distance == i){
						newCost += 100;
					}else{
						newCost += 600;
					}

					if(!visit[ny][nx][i] || distanceBoard[ny][nx][i]>=newCost){
						// System.out.println("ny : "+ny+" nx : "+nx+ " i : "+i +" / newCost : "+newCost);
						distanceBoard[ny][nx][i] = newCost;
						visit[ny][nx][i] = true;
						queue.offer(new Road(ny,nx,newCost,i));
					}
				}
			}
		}
	}

	static class Road {
		int y;
		int x;
		int cost;
		// int straight;
		// int corner;
		int distance;

		public Road(int y, int x, int cost, int distance) {
			this.y = y;
			this.x = x;
			this.cost = cost;
			this.distance = distance;
		}
	}
}
