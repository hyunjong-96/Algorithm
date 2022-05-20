package org.algorithm.java.hyunjong.Algorithm.BOJ.삼성기출;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 이차원배열과연산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] A = new int[100][100];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int R = 3;
		int C = 3;
		int answer = -1;

		for (int time = 0; time <= 100; time++) {
			if (A[r - 1][c - 1] == k) {
				answer = time;
				break;
			}

			if (R >= C) {
				int[][] copyA = new int[100][100];
				for (int i = 0; i < R; i++) {
					HashMap<Integer, Integer> numMap = new HashMap<>();
					List<Number> rowList = new ArrayList<>();
					for (int j = 0; j < 100 && j < C; j++) {
						if (A[i][j] == 0)
							continue;

						// if(numMap.containsKey(A[i][j])){
						// 	numMap.put(A[i][j], numMap.get(A[i][j])+1);
						// }else{
						// 	numMap.put(A[i][j], 1);
						// }
						numMap.put(A[i][j], numMap.getOrDefault(A[i][j], 0) + 1);
					}

					for (Integer key : numMap.keySet()) {
						rowList.add(new Number(key, numMap.get(key)));
					}
					Collections.sort(rowList);

					int idx = 0;
					for (int n = 0; n < 100 && n < rowList.size() * 2; n++) {
						copyA[i][n] = rowList.get(idx).num;
						n++;
						copyA[i][n] = rowList.get(idx).count;
						idx++;
					}

					C = Math.max(C, Math.min(rowList.size() * 2, 100));
				}
				A = copyA;

			} else {
				int[][] copyA = new int[100][100];
				for (int i = 0; i < C; i++) {
					HashMap<Integer, Integer> numMap = new HashMap<>();
					List<Number> colList = new ArrayList<>();
					for (int j = 0; j < R; j++) {
						if (A[j][i] == 0)
							continue;

						// if(numMap.containsKey(A[i][j])){
						// 	numMap.put(A[i][j], )
						// }else{
						//
						// }
						numMap.put(A[j][i], numMap.getOrDefault(A[j][i], 0) + 1);
					}

					for (Integer key : numMap.keySet()) {
						colList.add(new Number(key, numMap.get(key)));
					}
					Collections.sort(colList);

					int idx = 0;
					for (int n = 0; n < 100 & n < colList.size() * 2; n++) {
						copyA[n][i] = colList.get(idx).num;
						n++;
						copyA[n][i] = colList.get(idx).count;
						idx++;
					}

					R = Math.max(R, Math.min(colList.size() * 2, 100));
				}
				A = copyA;
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void rowSort() {

	}

	static class Number implements Comparable<Number> {
		int num;
		int count;

		public Number(int num, int count) {
			this.num = num;
			this.count = count;
		}

		@Override
		public int compareTo(Number o) {
			int result = this.count - o.count;
			if (result == 0) {
				result = this.num - o.num;
			}

			return result;
		}
	}
}
