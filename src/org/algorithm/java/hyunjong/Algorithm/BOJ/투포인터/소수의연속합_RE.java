package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class 소수의연속합_RE {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Integer> primeList = init(N);

		int result = prefixSum(N, primeList);

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	static int prefixSum(int N, List<Integer> primeList) {
		if(N==1) return 0;
		int start = 0;
		int end = 0;

		int prefixSum = primeList.get(0);
		int count = 0;
		while (start <= end) {
			if (prefixSum <= N) {
				if (prefixSum == N)
					count++;
				if (end == primeList.size() - 1)
					break;
				prefixSum += primeList.get(++end);
			} else {
				prefixSum -= primeList.get(start++);
			}
		}

		return count;
	}

	static List<Integer> init(int N) {
		boolean[] prime = new boolean[N + 1];
		List<Integer> primeList = new ArrayList<>();

		prime[0] = prime[1] = true;
		for (int i = 2; i <= (int)Math.sqrt(N); i++) {
			if (!prime[i]) {

				for (int j = (int)Math.pow(i, 2); j <= N; j += i)
					prime[j] = true;
			}
		}

		for (int i = 2; i <= N; i++) {
			if (!prime[i])
				primeList.add(i);
		}

		Collections.sort(primeList);
		return primeList;
	}
}
