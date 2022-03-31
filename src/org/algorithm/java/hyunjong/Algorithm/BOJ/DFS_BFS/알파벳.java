package org.algorithm.java.hyunjong.Algorithm.BOJ.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
모든 좌표를 상하좌우로 이동하되 방문했었던 알파벳의 좌표는 이동할수 없다는 조건이 있다.
dfs로 0,0 부터 위의 조건을 확인하면서 이동하고 최대한 이동할수 있는 곳으로 이동했을때의 count값 중 큰 값을 반환하면된다.
처음에는 알파벳을 비교하려고 dfs를 호출할때 해당 좌표의 알파벳을 추가시킨 문자열을 argument값으로 넣어줘서 비교를 했다.
그러니 문자열에서 해당 알파벳을 비교하는 시간과 재귀함수 호출시 생성되는 문자열 때문에 정말 아슬아슬하게 통과가 되었다.
코드를 최적화 시키기 위해서 방문한 알파벳 문자열을 argument로 보내는 대신 전역변수 길이 visit배열을 만들어서
방문한적없는 알파벳 좌표로 이동했을때 해당 알파벳의 아스키코드를 활용해서 처리해주었다.
이렇게 하니 20배 넘은 메모리 최적화와 30배 정도의 시간을 절약할수 있었다.
 */
public class 알파벳 {
	static int R;
	static int C;
	static char[][] board;
	static boolean[] visit;

	static int[] dX = {0, 0, -1, 1};
	static int[] dY = {-1, 1, 0, 0};

	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		visit = new boolean[26];
		for (int i = 0; i < R; i++) {
			char[] rowArr = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				board[i][j] = rowArr[j];
			}
		}

		max = 1;
		visit[board[0][0]-'A'] = true;
		dfs(0, 0, max);

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}

	static void dfs(int x, int y, int count) {
		// if (s.contains(String.valueOf(board[y][x]))) {
		// 	return;
		// }
		// if(visit[board[y][x]-'A']){
		// 	return;
		// }
		// s = s + board[y][x];

		for (int i = 0; i < 4; i++) {
			int nX = x + dX[i];
			int nY = y + dY[i];

			if (nX >= 0 & nY >= 0 & nX < C & nY < R) {
				if(!visit[board[nY][nX]-'A']){
					visit[board[nY][nX]-'A'] = true;
					dfs(nX, nY, count+1);
					visit[board[nY][nX]-'A'] = false;
					/*
					해당 다음 좌표에서 재귀 함수가 끝났다면 방문여부를 반납하여 다음 이동할 좌표를 검색할때
					영향이 미치지 않게 한다.(핵심)
					 */
				}
			}
		}
		max = Math.max(max, count);
	}
}
