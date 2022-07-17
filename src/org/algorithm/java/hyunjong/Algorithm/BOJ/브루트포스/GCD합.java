package org.algorithm.java.hyunjong.Algorithm.BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//https://velog.io/@kimmjieun/%EB%B0%B1%EC%A4%80-9613%EB%B2%88-GCD-%ED%95%A9-Java-%EC%9E%90%EB%B0%94
//gcd : 최대공약수(b==0일때까지 a=b,b=a%b 반복, 단 a에는 a,b중 큰값이어야한다), lcm : 최소공약수(A*B/gcd)
public class GCD합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[] nums = new int[N];

			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			long sum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					sum += gcd(nums[i], nums[j]);
				}
			}
			sb.append(sum);
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static int gcd(int a, int b) {
		if(a<b){
			int tmp = a;
			a = b;
			b = tmp;
		}
		while(b!=0){
			int n = a%b;
			a = b;
			b = n;
		}
		return a;
		// if (b == 0)
		// 	return a;
		// return gcd(b, a % b);
	}
}
