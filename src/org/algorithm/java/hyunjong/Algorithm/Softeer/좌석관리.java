package org.algorithm.java.hyunjong.Algorithm.Softeer;

import java.util.*;
import java.io.*;

public class 좌석관리 {
	static int N;
	static int M;
	static int[][] restaurant;
	static Map<Integer, int[]> eatPos;
	static boolean[] isAlreadyEat;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		restaurant = new int[N + 1][M + 1];
		eatPos = new HashMap<>();
		isAlreadyEat = new boolean[10001];
		// PriorityQueue<Seat> restaurant = initRestaurant(N, M);

		StringBuilder sb = new StringBuilder();
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			String work = st.nextToken();
			int id = Integer.parseInt(st.nextToken());

			if (work.equals("In")) {
				//먹고있음
				if (eatPos.containsKey(id)) {
					sb.append(String.valueOf(id)).append(" already seated.");
				}
				//이미 먹음
				else if (isAlreadyEat[id]) {
					sb.append(String.valueOf(id)).append(" already ate lunch.");
				} else {
					// Seat seat = restaurant.poll();
					int[] seat = getPos();
					//자리가 없음
					if (seat[0] == 0 && seat[1] == 0) {
						sb.append("There are no more seats.");
					}
					//자리 있음
					else {
						eatPos.put(id, new int[] {seat[0], seat[1]});
						restaurant[seat[0]][seat[1]] = id;
						sb.append(String.valueOf(id))
							.append(" gets the seat (")
							.append(seat[0])
							.append(", ")
							.append(seat[1])
							.append(").");
					}
				}
			} else {
				//먹고 있음
				if (eatPos.containsKey(id)) {
					int[] seat = eatPos.get(id);

					restaurant[seat[0]][seat[1]] = 0;
					eatPos.remove(id);
					isAlreadyEat[id] = true;

					sb.append(String.valueOf(id))
						.append(" leaves from the seat (")
						.append(seat[0])
						.append(", ")
						.append(seat[1])
						.append(").");
				}
				//아직 안먹음
				else if (!isAlreadyEat[id]) {
					sb.append(String.valueOf(id)).append(" didn't eat lunch.");
				}
				//이미 먹음
				else
					sb.append(String.valueOf(id)).append(" already left seat.");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int[] getPos() {

		if (eatPos.isEmpty())
			return new int[] {1, 1};
		int maxY = 0;
		int maxX = 0;
		double maxD = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				int minX = 0;
				int minY = 0;
				double minD = Double.MAX_VALUE;
				if (restaurant[i][j] != 0 || !distanceGap(i, j))
					continue;
				for (int id : eatPos.keySet()) {
					int[] pos = eatPos.get(id);

					// double a = Math.pow(pos[0] - i, 2);
					// double b = Math.pow(pos[1] - j, 2);
					// double d = Math.sqrt(a + b);
					double d = Math.sqrt(Math.pow(pos[0]-i,2)+Math.pow(pos[1]-j,2));

					if (minD > d) {
						minX = i;
						minY = j;
						minD = d;
					}

				}

				if (minD != Double.MAX_VALUE && maxD < minD) {
					maxX = minX;
					maxY = minY;
					maxD = minD;
				}
			}
		}

		return new int[] {maxX, maxY};
	}

	static boolean distanceGap(int x, int y) {
		if (x - 1 > 0 && restaurant[x - 1][y] != 0)
			return false;
		if (x + 1 <= N && restaurant[x + 1][y] != 0)
			return false;
		if (y - 1 > 0 && restaurant[x][y - 1] != 0)
			return false;
		if (y + 1 <= M && restaurant[x][y + 1] != 0)
			return false;

		return true;
	}
}