package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 달팽이 {
	/*
	(N/2,N/2)좌표부터 한칸부터 시작하여 같은 크기의 움직임으로 각 방향으로 두번씩이동한다.
	ex) 위쪽으로 한칸, 오른쪽으로 한칸 / 아래쪽으로 두칸, 왼쪽으로 두칸 / 위쪽으로 세칸, 오른쪽으로 세칸 ...
	이동하면서 N^2의 값을 넘어가고 반복문을 도는 순간 반복 중지
	이때 [N][N]의 배열에 모든 값이 저장되어진다.

	그리고 조건으로 받은 찾으려는 값을 배열을 돌면서 찾아서 반환한다.
	 */
	//상,우,하,좌
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int R = Integer.parseInt(br.readLine());

		int[][] snail = new int[N][N];
		Integer y = N / 2;
		Integer x = N / 2;

		//달팽이 회전 메소드
		makeSnail(snail, y, x, (int)Math.pow(N, 2));

		//찾으려는 값의 좌표
		int[] pos = findTarget(snail, R, N);

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				sb.append(snail[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(pos[0]).append(" ").append(pos[1]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int[] findTarget(int[][] snail, int target, int N){
		int[] answer = new int[2];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(snail[i][j] == target){
					answer[0]=i+1;
					answer[1]=j+1;
					break;
				}
			}
		}
		return answer;
	}

	static void makeSnail(int[][] snail, Integer y, Integer x, int target) {
		int move = 1;
		int num = 2;
		int index = 0;
		//1의 값은 배열의 가운데 위치에 먼저 선언한다
		//그리고 나서 한칸씩 이동시키면서 값을 채워넣어준다.
		snail[y][x] = 1;
		while (true) {
			//같은 크기로 2개의 방향이 움직인다.
			for(int i=0;i<2;i++){
				//해당 크기의 이동만큼 해당 방향에서 이동한다.
				for(int m=0;m<move;m++){
					//N^2의 값을 넘어가면 더이상 배열에 값을 채울 수 없으므로 반복 중지
					if (num > target)
						return;
					int ny = y+dy[index];
					int nx = x+dx[index];
					snail[ny][nx] = num++;

					y = ny;
					x = nx;
				}
				//이동할 방향 변경
				index = (index+1)%4;
			}
			//2개의 방향을 해당 크기만큼 이동했다면 이동 크기를 하나 증가
			move++;
		}
	}
}
