package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {
	static int[][] see;
	static int[] shark;
	static int N;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		see = new int[N][N];
		//0 : y, 1: x , 2 : 크기
		shark = new int[3];

		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++){
				see[i][j] = Integer.parseInt(st.nextToken());
				if(see[i][j] == 9){
					shark[0] = i;
					shark[1] = j;
					shark[2] = 2;
					see[i][j] = 0;
				}
			}
		}

		int answer = 0;
		//0:y, 1:x, 2:distance
		Move moveInfo;
		int eatCount = 0;
		while(true){
			int y = shark[0];
			int x = shark[1];
			int size = shark[2];
			moveInfo = hunt(y,x,size);

			if(moveInfo == null) break;

			see[moveInfo.y][moveInfo.x] = 0;
			shark[0] = moveInfo.y;
			shark[1] = moveInfo.x;
			if(++eatCount == size){
				shark[2] = size+1;
				eatCount=0;
			}
			answer += moveInfo.distance;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static Move hunt(int y, int x, int size){
		Queue<Move> moveQueue = new LinkedList<>();
		PriorityQueue<Move> fishPQ = new PriorityQueue<>();

		boolean[][] visit = new boolean[N][N];
		visit[y][x] = true;

		moveQueue.offer(new Move(y,x,0));
		while(!moveQueue.isEmpty()){
			Move current = moveQueue.poll();

			for(int i=0;i<4;i++){
				int ny = current.y+dy[i];
				int nx = current.x+dx[i];

				if(ny>=0 && nx>=0 && ny<N && nx<N && !visit[ny][nx] && see[ny][nx] <= size){
					if(see[ny][nx] !=0 && see[ny][nx] < size){
						fishPQ.offer(new Move(ny,nx,current.distance+1));
					}else{
						moveQueue.offer(new Move(ny,nx,current.distance+1));
					}
					visit[ny][nx] = true;
				}
			}
		}
		if(!fishPQ.isEmpty()) {
			int fishPQSize = fishPQ.size();
			Move current = fishPQ.poll();
			for(int i=1;!fishPQ.isEmpty() && i<fishPQSize;i++){
				Move compareMove = fishPQ.poll();

				if(current.distance < compareMove.distance) break;
				if(current.y>compareMove.y) current = compareMove;
				else if(current.y == compareMove.y){
					if(current.x > compareMove.x) current = compareMove;
				}
			}
			return current;
		}else{
			return null;
		}
	}

	static class Move implements Comparable<Move>{
		int y;
		int x;
		int distance;
		public Move(int y, int x, int distance){
			this.y = y;
			this.x = x;
			this.distance = distance;
		}

		@Override
		public int compareTo(Move o){
			return this.distance - o.distance;
		}
	}
}
