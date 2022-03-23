package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
다음 순열과 반대로 이전 수열은 seq[i-1] > seq[i]인 수를 찾아야한다.
예를 들어 7 2 3 1 4 5 6 에서 seq[i-1]>seq[i]인 값은 7 2 (3 1) 4 5 6 이게 되는데
이는 seq[i-1]의 첫번째 수열이게 되기 떄문이다.
그 다음 seq[i-1]보다 다음으로 작은 수를 찾아서 seq[i-1]값과 swap을 해준후 7 2 (3) (1) 4 5 6 -> 7 2 (1) (3) 4 5 6
내림차순을 해주면 된다. 7 2 1 6 5 4 3
 */
public class 이전수열 {
	static int N;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		seq = new int[N];
		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		if (prevPermutation()) {
			for (int i = 0; i < N; i++) {
				sb.append(seq[i]).append(" ");
			}
		} else {
			sb.append(-1);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static boolean prevPermutation() {
		int i = N - 1;
		while (i > 0 && seq[i - 1] <= seq[i]) {
			i--;
		}
		if (i < 1)
			return false;

		int j = N-1;
		while(seq[i-1]<=seq[j]){
			j--;
		}
		swap(i - 1, j);

		j = N - 1;
		while (i < j) {
			swap(i, j);
			i++;
			j--;
		}

		return true;
	}

	static void swap(int i, int j) {
		int tmp = seq[i];
		seq[i] = seq[j];
		seq[j] = tmp;
	}
}
