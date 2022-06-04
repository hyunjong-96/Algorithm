package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 원판돌리기 {
	static int N;
	static int M;
	static int T;
	static int[][] circles;
	static int[][] infos;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,-1,0,1};
	static int DELETE = 100000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		circles = new int[N][M];
		infos = new int[T][3];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<M;j++){
				circles[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0;i<T;i++){
			st = new StringTokenizer(br.readLine());
			infos[i][0] = Integer.parseInt(st.nextToken());
			infos[i][1] = Integer.parseInt(st.nextToken());
			infos[i][2] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		for(int i = 0;i<T;i++){
			turn(i);
			answer = count();
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int count(){
		int sum=0;
		boolean flag = false;

		boolean[][] visit = new boolean[N][M];

		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(!visit[i][j] && circles[i][j] != DELETE){
					boolean result = bfs(i,j, visit);

					if(result){
						flag = true;
					}
				}
			}
		}

		int numberCount = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(circles[i][j] != DELETE){
					sum += circles[i][j];
					numberCount++;
				}
			}
		}

		if(!flag){
			double avg = (double)sum/numberCount;
			sum = 0;

			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(circles[i][j] != DELETE){
						if(circles[i][j] < avg){
							circles[i][j] += 1;
						}else if(circles[i][j] > avg){
							circles[i][j] -= 1;
						}
						sum += circles[i][j];
					}
				}
			}
		}

		return sum;
	}

	static boolean bfs(int y, int x ,boolean[][] visit){
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{y,x});
		visit[y][x] = true;

		boolean flag = false;
		int targetNumber = circles[y][x];

		while(!queue.isEmpty()){
			int[] current = queue.poll();

			for(int i=0;i<4;i++){

				int ny = (current[0]+dy[i]);
				int nx = (current[1]+dx[i])%M;
				if(nx < 0) nx = M-1;

				if(ny>=0 && nx>=0 && ny<N && nx<M && !visit[ny][nx] && circles[ny][nx] != DELETE && circles[ny][nx] == targetNumber){
					flag = true;
					circles[current[0]][current[1]] = DELETE;
					circles[ny][nx] = DELETE;
					queue.offer(new int[]{ny,nx});
					visit[ny][nx] = true;
				}
			}
		}

		return flag;
	}

	static void turn(int turn){
		int[] info = infos[turn];
		int x = info[0];
		int d = info[1];
		int k = info[2];

		//x의 배열인 원판 찾기
		for(int i=0;i<N;i++){
			if((i+1)%x != 0) continue;

			int[] circle = new int[M];

			for(int j=0;j<M;j++){
				int number = circles[i][j];
				if(d == 0){
					int rightMove = (j+k)%M;
					circle[rightMove] = number;
				}else{
					int leftMove = j-k < 0 ? M + (j - k) : j-k;
					circle[leftMove] = number;
				}
			}

			circles[i] = circle;
		}
	}
}
