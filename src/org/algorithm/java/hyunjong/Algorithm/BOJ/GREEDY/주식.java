package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
뒤에서 부터 최대값이 있다면 최대값보다 작은 값은 최대값-작은값의 차이로 최대를 만들어야한다.
1 1 9 1 8 이라면 첫번째, 두번째인 1과 세번째의 9의 차이가 각 8이고, 네번쨰의 1과 마지막의 8의 차이가 7로 최대이기 때문에 23이 최대이게된다.
뒤에서 부터 최대값을 가지고 최대값보다 작은 값의 차이를 합해주고 최대값보다 더 큰 값이 나오게 되면 최대값을 교체하여 반복한다..
 */
public class 주식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			int[] graph = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0;i<N;i++){
				graph[i] = Integer.parseInt(st.nextToken());
			}

			long answer = 0;

			int max = 0;
			for(int i=graph.length-1;i>=0;i--){
				if(graph[i] > max) max = graph[i];
				else{
					answer += max - graph[i];
				}
			}

			sb.append(answer);
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
