package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//주어진 추를 오름차순 정렬 시 1부터 추의 합을 통해 구할수 있는 무게를 알 수 있다.
//sum은 0부터 i-1까지 추의 합이다. 1~sum까지의 무게는 weight[0]~weight[i-1]을 이용해서 표현가능하다는 뜻.
//sum=0부터 weight[i]<=sum+1 으로 비교했을때 조건을 만족한다면  1~sum+1까지의 무게를 표현할 수 있게된다는 의미이다.
public class 저울 {
	static int N;
	static int[] weights;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		weights = new int[N];
		for (int i = 0; i < N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(weights);

		int sum = 0;
		for(int i=0;i<N;i++){
			if(weights[i]<=sum+1){
				sum += weights[i];
			}else{
				break;
			}
		}

		bw.write(String.valueOf(sum+1));
		bw.flush();
		bw.close();
	}
}
