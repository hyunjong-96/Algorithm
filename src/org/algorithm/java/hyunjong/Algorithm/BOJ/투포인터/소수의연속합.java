package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 소수의연속합 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		List<Integer> primeList = setPrimes();

		int answer = countPrime(primeList);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int countPrime(List<Integer> primeList) {
		int start = 0;
		int end = 0;

		int count = 0;
		int sum = 0;

		while(true){
			if(sum>=N){
				sum -= primeList.get(start++);
			}else if(end == primeList.size()){
				break;
			}else{
				sum += primeList.get(end++);
			}

			if(sum == N) count++;
		}
		// while (start <= end && end < primeList.size()) {
		// 	if (sum < N) {
		// 		sum += primeList.get(end++);
		// 	} else {
		// 		if (sum == N)
		// 			count++;
		// 		sum -= primeList.get(start++);
		// 	}
		// }
		return count;
	}

	static List<Integer> setPrimes() {
		boolean[] isPrimes = new boolean[N + 1];
		List<Integer> primeList = new ArrayList<>();

		Arrays.fill(isPrimes, true);
		isPrimes[0] = isPrimes[1] = false;

		for (int i = 2; i <= Math.sqrt(N); i++) {
			if (isPrimes[i]) {
				for (int j = i * i; j <= N; j += i) {
					isPrimes[j] = false;
				}
			}
		}

		for (int i = 0; i < isPrimes.length; i++) {
			if (isPrimes[i])
				primeList.add(i);
		}

		return primeList;
	}
}
