package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.ArrayList;
import java.util.List;

/*
주어진 격자를 저장한 배열 char[][] grid

격자마다 격자로 들어온 방향을 저장하는 배열 boolean[][][] visit
[0] = 밑에서 위로(아래), [1] = 왼쪽에서 오른쪽으로(왼쪽),
[2] = 위에서 밑으로(위), [3] = 오른쪽에서 왼쪽으로(오른쪽) 방분 여부 체크

이동하는 방향으로 좌표 이동 int[] dy, int[] dx
0 = 밑에서 위로, 1 = 왼쪽에서 오른쪽으로, 2 = 위에서 밑으로, 3 = 오른쪽에서 왼쪽으로

격자로 들어온 방향에서 L이면 (d+3)%4, R이면 (d+1)%4 으로 이동할 방향을 정해준다.
예를 들어 (0,0)에서 아래쪽으로 이동하면 d는 0이고 해당 격자가 R이라면 (d+3)%4 = 3으로 왼쪽 방향으로 이동해야한다.
(0,0)에서 아래쪽으로 이동했는데 격자가 L이라면 (d+1)%4 = 1으로 오른쪽 방향으로 이동해야한다.

그리고 이동된 좌표를 갱신한다.
row = (row+dy[d]+R)%R, col = (col+dx[d]+C)%C

visit[row][col][d] 방향으로 해당 격자에 접근 했을때 이미 접근했다면 사이클이 생기는 것이기 떄문에
반복을 중단하고 count를 반환한다.

한번 격자에 접근한 방향으로 접근하게 되면 사이클과 마찬가지이기 때문에 격자로 접근하지 않은 방향에서 사이클 여부를 판단한다.

-배운점
특정 좌표에서 움직였을때 범위를 벗어난 경우 반대편 좌표로 이동하기 위해서는 (원래좌표 + 이동 방향 + 범위 길이)%범위길이
연산시, 이동했을 경우 -1이 나오든, 범위 길이의 좌표가 나와도 반대편 좌표로 이동된다.

이동 방향을 시계방향으로 선언했을 때, 이동할 수 있는 방향이 4방향이고
해당 방향에서 왼쪽으로 이동할때는 (d+1)%4
해당 방향에서 오른쪽으로 이동할때는 (d+3)%4
연산시, 이동할 방향의 좌표를 구할수 있는 식을 구할 수 있다.


https://jisunshine.tistory.com/175

 */
public class 빛의경로사이클 {
	public static void main(String[] args) {
		String[] grid = {"R", "R"};
		int[] result = solution(grid);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	static int R;
	static int C;
	//아래,왼쪽,위,오른쪽
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static boolean[][][] visit;

	static int[] solution(String[] grid) {
		R = grid.length;
		C = grid[0].length();

		char[][] g = new char[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				g[i][j] = grid[i].charAt(j);
			}
		}

		List<Integer> answerList = new ArrayList<>();

		//위,왼쪽,아래,오른쪽
		visit = new boolean[R][C][4];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				for (int d = 0; d < 4; d++) {
					if (!visit[i][j][d]) {
						answerList.add(start(g, i, j, d));
					}
				}
			}
		}

		return answerList.stream().sorted().mapToInt(Integer::new).toArray();
	}

	static public int start(char[][] grid, int row, int col, int d) {
		int count = 0;

		while (true) {
			if (visit[row][col][d])
				break;

			visit[row][col][d] = true;
			count++;

			if (grid[row][col] == 'L') {
				d = (d + 3) % 4;
			} else if (grid[row][col] == 'R') {
				d = (d + 1) % 4;
			}

			row = (row + dy[d] + R) % R;
			col = (col + dx[d] + C) % C;
		}

		return count;
	}
}
