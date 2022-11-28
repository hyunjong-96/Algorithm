package org.algorithm.java.hyunjong.Algorithm.해커랭크;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayManipulation {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, m).forEach(i -> {
			try {
				queries.add(
					Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt)
						.collect(toList())
				);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		long result = arrayManipulation(n, queries);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}

	public static long arrayManipulation(int n, List<List<Integer>> queries) {
		// Write your code here
		long[] arr = new long[n+2];
		long max = 0;
		for(List<Integer> query : queries){
			int a = query.get(0);
			int b = query.get(1);
			int k = query.get(2);

			arr[a] += k;
			arr[b+1] -= k;
		}

		long prefixSum = 0;
		for(int i=1;i<=n;i++){
			prefixSum += arr[i];
			max = Math.max(max, prefixSum);
		}
		return max;
	}
}