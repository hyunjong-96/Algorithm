package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 레이스 {
	static int N;
	static int M;
	static int K;
	static int[] places;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		places = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			places[i] = Integer.parseInt(st.nextToken());
		}

		int[] answer = setDistance();
		StringBuilder sb = new StringBuilder();
		for(int d : answer){
			sb.append(d);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int[] setDeployment(int gap) {
		int limit = 0;
		int[] deployment = new int[K];
		int idx = 0;

		int count=0;

		for (int i = 0; i < K; i++) {
			if (limit <= places[i]) {
				count++;
				limit = places[i] + gap;
				deployment[idx++] = 1;
				if(count==M){
					for(int j = idx;j<K;j++){
						deployment[j] = 0;
					}
					break;
				}
			} else {
				deployment[idx++] = 0;
			}
		}

		if(count == M){
			return deployment;
		}
		return null;
	}

	static int[] setDistance() {
		int start = 0;
		int end = N;
		int[] answer = new int[K];
		while (start <= end) {
			int mid = (start + end) / 2;

			int[] deployment = setDeployment(mid);

			// int count = 0;
			// for (int d : deployment) {
			// 	if (d == 1)
			// 		count++;
			// }

			// if (count >= M) {
			// 	start = mid + 1;
			// 	if (count == M) {
			// 		answer = deployment;
			// 	}
			// } else {
			// 	end = mid - 1;
			// }
			if(deployment != null){
				start = mid+1;
				answer = deployment;
			}else{
				end = mid-1;
			}
		}

		return answer;
	}
}
