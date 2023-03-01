package org.algorithm.java.hyunjong.Algorithm.BOJ.백트래킹;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class 다이어트 {
	static int N;
	static int[] minpfsv;
	static int[][] pfsv;
	static int answerCost;
	static List<Integer> answerList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		minpfsv = new int[4];
		pfsv = new int[N + 1][5];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++)
			minpfsv[i] = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pfsv[i][0] = p;
			pfsv[i][1] = f;
			pfsv[i][2] = s;
			pfsv[i][3] = v;
			pfsv[i][4] = c;
		}

		answerCost = Integer.MAX_VALUE;
		answerList = new ArrayList<>();
		selectPFSV(1, new int[4], 0, new ArrayList<>());

		StringBuilder sb = new StringBuilder();
		if (answerCost == Integer.MAX_VALUE) {
			sb.append(String.valueOf(-1));
		} else {
			sb.append(String.valueOf(answerCost)).append("\n");
			Collections.sort(answerList);
			for (int i = 0; i < answerList.size(); i++) {
				sb.append(answerList.get(i)).append(" ");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void selectPFSV(int idx, int[] cost, int totalCost, List<Integer> foodList) {
		if (isValid(cost)) {
			if (answerCost > totalCost) {
				answerCost = totalCost;
				answerList = new ArrayList<>(foodList);
			}
		}
		if (idx > N)
			return;

		for (int i = idx; i <= N; i++) {
			for (int j = 0; j < 4; j++)
				cost[j] += pfsv[i][j];
			foodList.add(i);
			selectPFSV(i + 1, cost, totalCost + pfsv[i][4], foodList);
			// foodList.remove(i);
			foodList.remove((Integer)i);
			for (int j = 0; j < 4; j++)
				cost[j] -= pfsv[i][j];
		}
	}

	static boolean isValid(int[] cost) {
		for (int i = 0; i < 4; i++) {
			if (cost[i] < minpfsv[i]) {
				return false;
			}
		}
		return true;
	}
}
