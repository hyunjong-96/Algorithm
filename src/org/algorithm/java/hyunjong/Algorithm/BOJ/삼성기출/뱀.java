package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
Dequeue를 이용한 BFS로 구현했다.
뱀이 이동할때 처음에 들어갈 dq의 값에 좌표(0,0)과 오른쪽 방향인 0을 넣어주었다.
방향은 방향 배열을 사용하여 0 : 오른쪽, 1 : 아래, 2: 왼쪽, 3 : 위의 방향으로 두어 계산.
뱀이 해당 방향으로 한칸 이동했을때
보드 배열의 범위를 넘어가거나 뱀의 몸통을 만났을때 (보드 배열 1) 현재 시간에서 +1을 해주고 BFS를 종료한다.
그렇지 않다면
이동한 좌표값에 사과가 있다면(보드 배열 2)해당 좌표에 1을 추가후 dq에 해당 좌표와 방향을 넣어준다.
이때 방향을 넣어줄때 해당 초 이후에 방향을 트는 값이 있다면 방향을 틀었을때의 다음 좌표와 틀은 방향을 넣어준다.
트는 값이 없다면 다음 좌표와 현재 방향을 동일하게 넣어준다.
이를 반복하면 값이 나오게 된다.
 */
public class 뱀 {
	static int N;
	static int K;
	static int[][] board;

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	static char[] direction = new char[10001];
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			/*
			문제에서 주어지는 사과의 좌표는 보드 배열(1,1)이 시작점이지만
			내가 구현한것은 보드 배열(0,0)에서 시작하므로 사과 좌표를 -1만큼 뺴주고 시작한다.
			 */
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			board[y][x] = 2;
		}

		int directionNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < directionNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			/*
			방향을 트는 시간이 주어졌을때 direction배열에 해당 시간 값에 들어온 방향을 넣어준다.
			 */
			int second = Integer.parseInt(st.nextToken());
			char d = st.nextToken().charAt(0);
			direction[second] = d;
		}

		ans = 0;
		board[0][0] = 1;
		bfs();
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	//오 : 0, 아래 : 1, 왼 : 2, 위 : 3
	static void bfs() {
		Deque<Head> dq = new LinkedList<>();
		dq.addLast(new Head(0, 0, 0));

		int count = 0;
		while (!dq.isEmpty()) {
			Head h = dq.peekLast();

			int nY = h.y;
			int nX = h.x;
			int nD = h.d;
			/*
			현재 시간에서 방향을 트는 값이 존재한다면
			D일때는 현재 방향에서 방향배열의 오른쪽으로 index를 한칸 이동해준다.
			index가 3일때는 0으로 이동해야하므로 (방향+5)%4를 통해 올바른 방향을 가리키도록 함
			L일때는 현재 방향에서 방향배열의 왼쪽으로 index를 한칸 이동해준다.
			index가 0일때는 3으로 이동해야하므로 (방향+3)%4를 통해 방향 설정.
			그 외의 값은 현재 방향으로 이동
			 */
			if (direction[count] == 'D') {
				nD = (h.d + 5) % 4;
				nY += dy[nD];
				nX += dx[nD];
			} else if (direction[count] == 'L') {
				nD = (h.d + 3) % 4;
				nY += dy[nD];
				nX += dx[nD];
			} else {
				nY += dy[nD];
				nX += dx[nD];
			}

			//다음 이동할 좌표가 배열의 범위를 벗어나게 되면 현재 시간에서 +1을 하고 BFS종료
			if (nX < 0 || nY < 0 || nX >= N | nY >= N) {
				ans = count + 1;
				return;
			}
			//다음으로 이동했을때 뱀의 몸통을 만났다면 마친가지로 현재 시간 +1을 한 후 BFS종료
			if (board[nY][nX] == 1) {
				ans = count + 1;
				return;
			}

			//사과를 발견했으면 해당 위치를 1로 바꿔주고 dq에 머리 추가
			//빈 땅이라면 dq에 머리를 추가후 dq앞에있는 꼬리 제거
			if (board[nY][nX] == 2) {
				board[nY][nX] = 1;
				dq.addLast(new Head(nY, nX, nD));
			} else {
				board[nY][nX] = 1;
				dq.addLast(new Head(nY, nX, nD));
				Head tail = dq.pollFirst();
				board[tail.y][tail.x] = 0;
			}
			count++;
		}
	}

	static class Head {
		int y;
		int x;
		int d;

		public Head(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
}
