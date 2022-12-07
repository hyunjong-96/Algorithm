package org.algorithm.java.hyunjong.Algorithm;
import java.io.*;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;
public class A{
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,-1,0,1};
	public static void main(String[] args) throws IOException{
		Set<Integer> set = new HashSet<>();
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// int N = Integer.parseInt(st.nextToken());
		// int M = Integer.parseInt(st.nextToken());
		// int[][] map = new int[N][M];
		//
		// for(int i=0;i<N;i++){
		// 	String[] row = br.readLine().split("");
		// 	for(int j=0;j<M;j++){
		// 		map[i][j] = Integer.parseInt(row[j]);
		// 	}
		// }
		//
		// int answer = bfs(map, N, M);

		// bw.write(String.valueOf(answer));
		// bw.flush();
		// bw.close();
	}

	static int bfs(int[][] map, int N, int M){
		//0:y 1:x 2:d
		Queue<int[]> queue = new LinkedList<>();
		// boolean[][] check = new boolean[N][M];

		queue.offer(new int[]{0,0,1});
		map[0][0] = -1;

		while(!queue.isEmpty()){
			int[] current = queue.poll();
			if(current[0]==N-1 && current[1]==M-1) return current[2];

			// check[current[0]][current[1]]=true;

			for(int i=0;i<4;i++){
				int ny = current[0]+dy[i];
				int nx = current[1]+dx[i];
				if(ny>=0&&nx>=0&&ny<N&&nx<M&&map[ny][nx]==1){
					queue.offer(new int[]{ny,nx,current[2]+1});
					map[ny][nx] = -1;
				}
			}
		}
		return -1;
	}
}