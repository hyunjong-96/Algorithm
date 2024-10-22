package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.io.*;

public class 하노이탑이동순서 {

	static int count;
	public static void main(String[] args) throws IOException {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//
		// int N = Integer.parseInt(br.readLine());
		//
		// Deque<int[]> dq = new LinkedList<>();
		// hanoi(dq, N, 1, 2, 3);
		//
		// StringBuilder sb = new StringBuilder();
		// sb.append(dq.size()).append("\n");
		// while(!dq.isEmpty()){
		// 	int[] info = dq.poll();
		// 	sb.append(info[0]).append(" ").append(info[1]).append("\n");
		// }
		// bw.write(sb.toString());
		// bw.flush();
		// bw.close();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		count = 0;
		StringBuilder sb = new StringBuilder();
		hanoi(sb, N, 1, 2, 3);

		StringBuilder resultSb = new StringBuilder();
		resultSb.append(count).append("\n");
		resultSb.append(sb);

		bw.write(resultSb.toString());
		bw.flush();
		bw.close();
	}

	public static void hanoi(StringBuilder sb, int N, int start, int mid, int to){
		if(N==1){
			setBlock(sb, start, to);
			return;
		}

		hanoi(sb, N-1, start, to, mid);
		setBlock(sb, start, to);
		hanoi(sb, N-1, mid, start, to);
	}

	public static void setBlock(StringBuilder sb, int start, int to){
		sb.append(start).append(" ").append(to).append("\n");
		count++;
	}
	// public static void hanoi(Deque<int[]> dq, int N, int start, int mid, int to) {
	// 	if (N == 1) {
	// 		dq.offer(new int[]{start, to});
	// 		return;
	// 	}
	//
	// 	/*
	// 	N원판을 제외한 N-1개의 원판을 목적지가 아닌 다른 탑에 저장
	// 	start : 출발지, to : 목적지 외의 탑, mid : 목적지
	// 	 */
	// 	hanoi(dq, N - 1, start, to, mid);
	//
	// 	/*
	// 	N-1개의 원판을 목적지가 아닌 다른 탑에 저장했기때문에 N원판 하나만 남고
	// 	N원판을 목적지에 저장
	// 	 */
	// 	dq.offer(new int[]{start, to});
	//
	// 	/*
	// 	목적지가 아닌 탑에 저장된 원판들을 목적지로 이동
	// 	mid : 출발지, start : 목적지 외의 탑, to : 목적지
	// 	 */
	// 	hanoi(dq, N - 1, mid, start, to);
	// }
}
