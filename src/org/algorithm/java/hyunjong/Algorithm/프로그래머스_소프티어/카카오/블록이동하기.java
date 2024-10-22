package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

import java.util.LinkedList;
import java.util.Queue;

public class 블록이동하기 {
	public static void main(String[] args) {
		int[][] board = {{0, 0, 0, 0, 1, 0}, {0, 0, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
		System.out.println(solution(board));

	}

	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,-1,0,1};
	static int solution(int[][] board){
		return move(board);
	}

	static int move(int[][] board){
		Queue<Robot> queue = new LinkedList<>();
		queue.offer(new Robot(0,0,0,1,0,0));

		int N = board.length;
		boolean[][][] visit = new boolean[N][N][2];

		while(!queue.isEmpty()){
			Robot robot = queue.poll();
			int time = robot.time;
			int state = robot.state;
			int y1 = robot.y1;
			int x1 = robot.x1;
			int y2 = robot.y2;
			int x2 = robot.x2;

			System.out.println("y1 : "+y1+" x1 : "+x1+" y2 : "+y2+" x2 : "+x2+" time : "+time+" state : "+state);
			if(visit[y1][x1][state] && visit[y2][x2][state]) continue;
			if(y1==N-1&&x1==N-1 || y2==N-1&&x2==N-1) return time;
			visit[y1][x1][state] = true;
			visit[y2][x2][state] = true;

			//상하좌우
			for(int i=0;i<4;i++){
				int ny1 = y1+dy[i];
				int nx1 = x1+dx[i];
				int ny2 = y2+dy[i];
				int nx2 = x2+dx[i];
				int nstate = state;

				if(checkRange(ny1,nx1,board) && checkRange(ny2,nx2,board)){
					queue.add(new Robot(ny1,nx1,ny2,nx2,time+1,state));
				}
			}

			//회전
			//세로상태일때는 위가 y1,x1, 아래가 y2,x2
			//가로상태일때는 왼쪽이 y1,x1, 오른쪽이 y2,x2
			if(state==0 && checkRange(y1+1,x1,board)&&checkRange(y1+1,x1+1,board)){
				queue.add(new Robot(y2,x2,y1+1,x1+1,time+1,1));
			}
			if(state== 0&&checkRange(y2+1,x2,board)&&checkRange(y2+1,x2-1,board)){
				queue.add(new Robot(y1,x1,y2+1,x2-1,time+1,1));
			}
			if(state==0&&checkRange(y1-1,x1,board)&&checkRange(y1-1,x1+1,board)){
				queue.add(new Robot(y1-1,x1+1,y2,x2,time+1,1));
			}
			if(state==0&&checkRange(y2-1,x2,board)&&checkRange(y2-1,x2-1,board)){
				queue.add(new Robot(y2-1,x2-1,y1,x1,time+1,1));
			}
			if(state==1&&checkRange(y1,x1+1,board)&&checkRange(y1+1,x1+1,board)){
				queue.add(new Robot(y2,x2,y1+1,x1+1,time+1,0));
			}
			if(state==1&&checkRange(y1,x1-1,board)&&checkRange(y1+1,x1-1,board)){
				queue.add(new Robot(y1+1,x1-1,y2,x2,time+1,0));
			}
			if(state==1&&checkRange(y2,x2+1,board)&&checkRange(y2-1,x2+1,board)){
				queue.add(new Robot(y1,x1,y2-1,x2+1,time+1,0));
			}
			if(state==1&&checkRange(y2,x2-1,board)&&checkRange(y2-1,x2-1,board)){
				queue.add(new Robot(y2-1,x2-1,y1,x2,time+1,0));
			}
		}
		return 0;
	}

	static boolean checkRange(int y, int x, int[][] board){
		int N = board.length;
		return y >= 0 && x >= 0 && y < N && x < N && board[y][x] == 0;
	}


	static class Robot{
		int y1;
		int x1;
		int y2;
		int x2;
		int time;
		int state;
		public Robot(int y1, int x1, int y2, int x2, int time, int state){
			this.y1=y1;
			this.x1=x1;
			this.y2=y2;
			this.x2=x2;
			this.time=time;
			this.state=state;
		}
	}
}
