package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.*;

/*
게임판에서 유효한 결과의 최종상태의 경우의 수는 아래와 같다.
	1. X의 개수가 5개, O의 개수가 4개 일때, O가 3칸을 완성하지 않은 경우
	2. X,O의 총 개수가 9개가 아니고 X의 개수가 O의 개수보다 1개 많을 때, X가 3칸을 연속으로 차지하고 O가 3칸을 연속으로 차지하지 않아야한다.
	3. X,O의 총 개수가 9개가 아니고 X의 개수가 O의 개수와 동일할때, X가 3칸을 연속으로 차지하지않아야하고 O가 3칸을 연속으로 차지하지 않아야한다.
		OOOXXX... 의 경우 invalud가 되어야한다.
	이 외의 경우는 모두 최종상태가 될 수 없다.

3개가 연속으로 차지하는지 여부는 3*3의 게임판이기 때문에
가로 확인 map[i][0] == hourse && map[i][1] == hourse && map[i][2] == hourse 가 모두 참일 경우,
세로 확인 map[0][i] == hourse && map[1][i] == hourse && map[2][i] == hourse 가 모두 참일 경우,
대각선 map[0][0] == hourse && map[1][1] == hourse && map[2][2] == hourse가 모두 참일 경우,
	map[0][2] == hourse && map[1][1] == hourse && map[2][0] == hourse가 모두 참일 경우
	이 4개의 조건 중 하나라도 만족한다면 3개가 연속으로 차지하는 말의 결과가 된다.토

최종상태가 valid인 경우를 찾는데 오래걸린 문제
 */
public class 틱택토 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		while (true) {
			String str = br.readLine();
			if (str.equals("end"))
				break;

			String[] mapStr = str.split("");
			Character[][] map = new Character[3][3];
			int mapIndex = 0;
			int xCount = 0;
			int oCount = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					char hourse = mapStr[mapIndex++].charAt(0);
					map[i][j] = hourse;
					if (hourse == 'O')
						oCount++;
					else if (hourse == 'X')
						xCount++;
				}
			}

			boolean isValid = checkMap(map, xCount, oCount);
			String result = isValid ? "valid" : "invalid";
			sb.append(result).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static boolean checkMap(Character[][] map, int xCount, int oCount) {
		if (xCount == 5 && oCount == 4 && !isBingGo(map, 'O')) {
			return true;
		} else if (xCount == oCount + 1) {
			return isBingGo(map, 'X') && !isBingGo(map, 'O');
		} else if (xCount == oCount) {
			return !isBingGo(map, 'X') && isBingGo(map, 'O');
		}
		return false;
	}

	static boolean isBingGo(Character[][] map, char hourse) {

		//가로
		for (int i = 0; i < 3; i++) {
			if (map[i][0] == hourse && map[i][1] == hourse && map[i][2] == hourse)
				return true;
		}

		//세로
		for (int i = 0; i < 3; i++) {
			if (map[0][i] == hourse && map[1][i] == hourse && map[2][i] == hourse)
				return true;
		}

		//대각선
		if (map[0][0] == hourse && map[1][1] == hourse && map[2][2] == hourse)
			return true;
		if (map[0][2] == hourse && map[1][1] == hourse && map[2][0] == hourse)
			return true;

		return false;
	}
}
