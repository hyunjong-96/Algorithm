package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
브루트포스 알고리즘을 사용하는 문제
기준 사람의 몸무게와 키 둘 다 크다면 rank를 한단계씩 더해줌을 반복
 */
public class 덩치 {
	static class Body {
		int weight;
		int height;

		public Body(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Body[] B = new Body[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			B[i] = new Body(weight, height);
		}

		for (int i = 0; i < N; i++) {
			int rank = 1;
			for(int j = 0;j<N;j++){
				if(B[i].weight < B[j].weight && B[i].height < B[j].height){
					rank ++;
				}
			}
			sb.append(rank).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
