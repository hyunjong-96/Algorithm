package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
public class 그림{
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,-1,0,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][] check = new boolean[N][M];
		int drawCount = 0;
		int maxSize = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(check[i][j] || map[i][j] != 1) continue;

				int size = BFS(map, check, i, j, N, M);
				maxSize = Math.max(size, maxSize);
				drawCount++;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(drawCount).append("\n").append(maxSize);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int BFS(int[][] map, boolean[][] check, int y, int x, int N, int M){
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{y,x});
		int size = 0;
		while(!queue.isEmpty()){
			int[] current = queue.poll();

			if(check[current[0]][current[1]]) continue;
			check[current[0]][current[1]] = true;
			size++;
			for(int d=0;d<4;d++){
				int ny = current[0]+dy[d];
				int nx = current[1]+dx[d];
				if(ny>=0 && nx>=0 && ny<N && nx<M && map[ny][nx] == 1 && !check[ny][nx]){
					queue.offer(new int[]{ny,nx});
				}
			}
		}

		return size;
	}
}
