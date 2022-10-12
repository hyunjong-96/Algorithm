package org.algorithm.java.hyunjong.Algorithm.BOJ.누적합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
각 구간별로 출석되지않은 학생을 구해야한다.
각 구간이 최대 50000이기때문에 학생수 5000이면 2중for문으로는 시간초과가 발생한다.
출석 여부를 판단하는 boolean[] 배열을 통해 출석이 되지 않은 학생이 있을때마다 누적합을 증가시켜 저장하고
구간별 누적합을 구해 출석되지 않은 학생 수를 구할 수 있다.
 */
public class 출석체크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] info = br.readLine().split(" ");
		int N = Integer.parseInt(info[0]);//학생수
		int K = Integer.parseInt(info[1]);//졸고있는 학생수
		int Q = Integer.parseInt(info[2]);//코드보낼 학생 수
		int M = Integer.parseInt(info[3]);//주어질 구간 수
		boolean[] sleep = new boolean[N+3];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<K;i++){
			sleep[Integer.parseInt(s[i])] = true;
		}
		boolean[] check = new boolean[N+3];
		String[] c = br.readLine().split(" ");
		for(int i=0;i<Q;i++){
			int checkNum = Integer.parseInt(c[i]);
			check(check, sleep, checkNum, N);
		}

		int[] prefixSum = new int[N+3];
		for(int i=3;i<N+3;i++){
			prefixSum[i] = prefixSum[i-1];
			if(!check[i]) prefixSum[i]++;
		}

		StringBuilder sb = new StringBuilder();
		for(int m = 0;m<M;m++){
			String[] rangeInfo = br.readLine().split(" ");
			int S = Integer.parseInt(rangeInfo[0]);
			int E = Integer.parseInt(rangeInfo[1]);

			sb.append(prefixSum[E]-prefixSum[S-1]);
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void check(boolean[] check, boolean[] sleep, int checkNum, int N){
		if(sleep[checkNum]) return;

		int num = checkNum;
		while(num <= N+2){
			if(!sleep[num]){
				check[num] = true;
			}
			num += checkNum;
		}
	}
}
