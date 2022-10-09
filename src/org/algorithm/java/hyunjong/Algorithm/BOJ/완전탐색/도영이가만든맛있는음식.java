package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
완전탐색을 통해 각 재료의 신맛,쓴맛이 담긴 materials배열을 중복없이 재료 조합을 선택하여 맛 차이가 최소인 경우를 찾음
 */
public class 도영이가만든맛있는음식 {
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] materials = new int[N][2];

		for(int i=0;i<N;i++){
			String[] taste = br.readLine().split(" ");
			materials[i][0] = Integer.parseInt(taste[0]);
			materials[i][1] = Integer.parseInt(taste[1]);
		}

		answer = Integer.MAX_VALUE;
		findBestCollaboration(materials, 0, 1, 0, N, 0);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void findBestCollaboration(int[][] materials, int idx, int S, int B, int N, int depth){
		if(depth != 0){
			answer = Math.min(answer, Math.abs(S-B));
		}
		if(depth >= N) return;

		for(int i=idx;i<N;i++){
			findBestCollaboration(materials, i+1, S*materials[i][0], B+materials[i][1], N, depth+1);
		}

	}
}
