package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
통나무는 배열의 첫번째와 마지막 통나무가 인접해있기 때문에 원형으로 정렬되어있다.
인접한 나무와의 차이가 최소가 되기 위해서는 인접한 나무가 최대한 차이가 되서는 안된다.
그러기 위해서 가운데가 가장 큰 값으로 양옆으로 점점 줄어들도록 정렬하게 되면 서로 인접한(첫 값과 마지막 값도) 나무들의 차이가 최소가 된다.
 */
public class 통나무건너뛰기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for (int i = 0; i < N; i++) {
				pq.offer(Integer.parseInt(st.nextToken()));
			}

			int[] woods = new int[N];
			woods[N/2] = pq.poll();
			int left = N/2-1;
			int right = N/2+1;

			while(!pq.isEmpty()){
				if(right <N) woods[right++] = pq.poll();
				if(left >= 0) woods[left--] = pq.poll();
				// if(left>=0){
				// 	woods[left--] = pq.poll();
				// }
				//
				// if(!pq.isEmpty() && right<N)
				// 	woods[right++] = pq.poll();
			}

			int max=0;
			for(int i=0;i<N;i++){
				max = Math.max(max, Math.abs(woods[i]-woods[(i+1)%woods.length]));
			}
			sb.append(max);
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
