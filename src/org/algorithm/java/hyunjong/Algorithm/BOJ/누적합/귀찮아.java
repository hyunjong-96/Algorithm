package org.algorithm.java.hyunjong.Algorithm.BOJ.누적합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
N이 최대 10만개이기 때문에 2for문을 사용하게되면 시간초과 발생
누적합을 통해서 O(n)으로 문제를 해결할 수 있다.

x1x2+x1x3+x1x4+...x1xn 일경우 x1(x2+x3+x4+...xn)으로 풀이를 생각해볼수 있다.

누적합을 통해 i번째까지의 누적합을 sum[i]에 저장한다.
for문을 돌려 첫번째 수부터 i+1번째 수부터 N까지의 합과 곱한것을 더해가며 반복한다.

값은 |xi|<=100이기때문에 100*(100000*100)*100000 의 값이 나올수 있으므로 long타입.
(특정i번째 최대값 * i+1번째부터 N까지 값의 합 ) * N
 */
public class 귀찮아 {
	static long answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] sum = new int[N+1];
		String[] x = br.readLine().split(" ");
		for(int i=1;i<=N;i++){
			int num = Integer.parseInt(x[i-1]);
			arr[i] = num;
			sum[i] = sum[i-1]+num;
		}

		answer = 0;
		for(int i=1;i<=N;i++){
			int rangeSum = rangeSum(i+1, N, sum);
			answer += arr[i]*(long)rangeSum;
		}


		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int rangeSum(int start, int end, int[] sum){
		return sum[end]-sum[start-1];
	}
}
