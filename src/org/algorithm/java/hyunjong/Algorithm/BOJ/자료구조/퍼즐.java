package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

//배열을 2차원 배열이 아닌 String타입으로 변경하여 중복되는 수의 경우 map을 통해 방지한다.
//bfs를 통해 수의 배치를 나타내는 String을 저장하여 중복되지 않은 경우의 배치를 map에 저장하면서 종료조건에 맞는지 확인한다.
//String에서 0의 위치는 indexOf를 통해 찾고 0의 위치에서 인접한 수를 찾기 위해 y = index/3, x = index%3로 변경하여 인접한 수를 변경해준다.
//배열에서 각 수 위치의 모든 경우의수를 파악하려하고 특정 수의 위치를 찾아 배열이 변경되는 경우라면 String으로 배열을 만들어 생각해보자
public class 퍼즐 {
	static Map<String, Integer> map = new HashMap<>();

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};

	static String answerBoard = "123456780";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				int element = Integer.parseInt(st.nextToken());
				sb.append(element);
			}
		}

		String board = sb.toString();
		map.put(board, 0);
		int answer = bfs(board);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int bfs(String board) {
		Queue<String> queue = new LinkedList<>();

		queue.offer(board);

		while (!queue.isEmpty()) {
			String current = queue.poll();
			int pos = current.indexOf('0');
			int y = pos / 3;
			int x = pos % 3;
			int move = map.get(current);

			if(current.equals(answerBoard)) return move;

			for (int d = 0; d < 4; d++) {
				int ny = y + dy[d];
				int nx = x + dx[d];

				if (ny >= 0 && nx >= 0 && ny < 3 && nx < 3) {
					int changeNumPos = ny*3+nx;
					char changeNum = current.charAt(changeNumPos);
					String changeBoard = current.replace('0','R');
					changeBoard = changeBoard.replace(changeNum, '0');
					changeBoard = changeBoard.replace('R', changeNum);

					if(!map.containsKey(changeBoard)){
						map.put(changeBoard, move+1);
						queue.offer(changeBoard);
					}
				}
			}
		}
		return -1;
	}
}
