package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class K번째수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		long front = 1;

		//N이 100000이기 때문에 long을 써주거나 구하고자 하는 수값은 K를 벗어나지 못하므로 K로 써준다.
		long rear = (long)N *N;
		long mid;
		while(front<rear){
			mid = (front+rear)/2;

			long count=0;
			for(int i=1;i<=N;i++){
				//N보다 큰 값을 찾고자 할때 1행과 같은 곳에서는 N보다 큰값을 가질수 없기 때문에 최대 N으로 설정
				count += Math.min(N, mid/i);
			}

			if(count<K){
				front = mid+1;
			}else{
				rear = mid;
			}
		}

		bw.write(String.valueOf(rear));
		bw.flush();
		bw.close();
	}
}
