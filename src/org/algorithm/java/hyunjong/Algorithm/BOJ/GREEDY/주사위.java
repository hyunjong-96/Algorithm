package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/*
주사위에서 3면만 노출되는 부위의 개수는 4개
2면만 노출되는 부위는 8(N-2) + 4개
1면만 노출되는 부위는 4(N-2)^2 + 4(N-2)개
각 주어진 주사위의 면에 있는 숫자에서 (A,F), (B,E), (C,D)의 쌍에서 가장 작은 값을 노출시켜야 합이 최소가 된다.
nums[0]은 3면, nums[1]은 2면, nums[2]는 1면이 노출되는 식을 구해서 각 노출되는 면이 가장 작은 숫자를 나타내도록 합을 구해서 곱해준다.

주사위가 1개만 주어졌을때는 가장 큰값을 제외한 5개를 노출시켜야하기 때문에 주사위를 정렬하여 가장큰 값만 빼고 합을 구한다.
 */
public class 주사위 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] dice = new int[6];
		for (int i = 0; i < 6; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> minList = new ArrayList<>();
		minList.add(Math.min(dice[0], dice[5]));
		minList.add(Math.min(dice[1], dice[4]));
		minList.add(Math.min(dice[2], dice[3]));
		Collections.sort(minList);

		long[] nums = new long[3];
		nums[0] = 5 * (long)Math.pow(N-2,2) + 4 * (N - 2);
		nums[1] = 8 * (N - 2) + 4;
		nums[2] = 4;

		long sum = 0;
		if (N != 1) {
			//1면 노출
			nums[0] *= minList.get(0);

			//2면 노출
			for(int i=0;i<2;i++){
				sum += minList.get(i);
			}
			nums[1] *= sum;

			//3면 노출
			sum = 0;
			for(int i=0;i<3;i++){
				sum += minList.get(i);
			}
			nums[2] *= sum;

			sum = 0;
			for(int i=0;i<3;i++){
				sum += nums[i];
			}

		} else {
			Arrays.sort(dice);
			for (int i = 0; i < 5; i++) {
				sum += dice[i];
			}
		}

		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}
