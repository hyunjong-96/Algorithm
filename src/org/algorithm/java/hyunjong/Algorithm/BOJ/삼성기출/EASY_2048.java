package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
처음에는 냅다 브루트포스로 구현을 풀려고했었는데 아무리 생각해도 좋은 생각이 안떠올랐다.
Stack을 사용하는 것을 보고 딱 깨닮았다. 그리고 Heap이 좀더 구현하는데 편한것같아서 Heap으로 구현
Heap을 사용해서 축에서 쏠리는 값들을 저장한후 다음으로 올 값이 현재 값과 동일하다면 새로온 배열에 해당 축의 순서대로 저장.
새로운 배열에 저장할때 해당 값을 ans값과 비교하며 큰값을 저장해준다.
새로운 배열을 모두 완성했다면 dfs를 통해 count+1값과 새로운 배열을 넘겨서 상하좌우로 움직였을때를 모든 경우를 확인한다.
 */
public class EASY_2048 {
	static int N;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = Integer.MIN_VALUE;
		dfs(1, board);
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	static void dfs(int count, int[][] board) {
		/*
		시작 카운트를 1로 했기때문에 count가 6이상이 되게 되면 dfs 반환.
		 */
		if (count > 5) {
			return;
		}

		/*
		위로 움직이는 경우 각 x축을 기준으로 y축의 0부터 N-1까지 비교하며 0이 아닌 값들을 모두 Heap에 저장
		Heap에 저장한 후 앞의 값을 꺼내가며 다음 값이 존재할때 해당 값과 동일하다면
		새로운 배열에 해당 x축의 y 좌표에 넣어주면서 결괏값을 ans와 비교하여 큰 값을 저장해준다.
		그 후 Heap이 비게 되면 위로 움직였을때 그 다음으로 움직일 방향의 케이스를 탐색할 dfs를 count+1와 새로운 배열을 넣어서 실행.
		 */
		//위
		Queue<Integer> upQueue = new LinkedList<>();
		int[][] upBoard = new int[N][N];
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (board[y][x] == 0)
					continue;
				upQueue.add(board[y][x]);
			}

			int index = 0;
			while (!upQueue.isEmpty()) {
				int num = upQueue.poll();
				if (upQueue.size() > 0 && upQueue.peek() == num) {
					upBoard[index][x] = num + upQueue.poll();
				} else {
					upBoard[index][x] = num;
				}
				ans = Math.max(ans, upBoard[index][x]);
				index++;
			}
		}
		dfs(count + 1, upBoard);

		//왼
		Queue<Integer> leftQueue = new LinkedList<>();
		int[][] leftBoard = new int[N][N];
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (board[y][x] == 0)
					continue;
				leftQueue.add(board[y][x]);
			}

			int index = 0;
			while (!leftQueue.isEmpty()) {
				int num = leftQueue.poll();
				if (leftQueue.size() > 0 && leftQueue.peek() == num) {
					leftBoard[y][index] = num + leftQueue.poll();
				} else {
					leftBoard[y][index] = num;
				}
				ans = Math.max(ans, leftBoard[y][index]);
				index++;
			}
		}
		dfs(count + 1, leftBoard);

		//아래
		Queue<Integer> bottomQueue = new LinkedList<>();
		int[][] bottomBoard = new int[N][N];
		for (int x = 0; x < N; x++) {
			for (int y = N - 1; y >= 0; y--) {
				if (board[y][x] == 0)
					continue;
				bottomQueue.add(board[y][x]);
			}

			int index = N - 1;
			while (!bottomQueue.isEmpty()) {
				int num = bottomQueue.poll();
				if (bottomQueue.size() > 0 && bottomQueue.peek() == num) {
					bottomBoard[index][x] = num + bottomQueue.poll();
				} else {
					bottomBoard[index][x] = num;
				}
				ans = Math.max(ans, bottomBoard[index][x]);
				index--;
			}
		}
		dfs(count + 1, bottomBoard);

		//오
		Queue<Integer> rightQueue = new LinkedList<>();
		int[][] rightBoard = new int[N][N];
		for (int y = 0; y < N; y++) {
			for (int x = N - 1; x >= 0; x--) {
				if (board[y][x] == 0)
					continue;
				rightQueue.add(board[y][x]);
			}

			int index = N - 1;
			while (!rightQueue.isEmpty()) {
				int num = rightQueue.poll();
				if (rightQueue.size() > 0 && rightQueue.peek() == num) {
					rightBoard[y][index] = num + rightQueue.poll();
				} else {
					rightBoard[y][index] = num;
				}
				ans = Math.max(ans, rightBoard[y][index]);
				index--;
			}
		}
		dfs(count + 1, rightBoard);
	}
}
