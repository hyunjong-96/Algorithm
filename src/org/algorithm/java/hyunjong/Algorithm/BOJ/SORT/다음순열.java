package org.algorithm.java.hyunjong.Algorithm.BOJ.SORT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
순열의 내림차순
순열을 내림차순으로 정렬할때 수열중 어떠한값 num[i]의 다음 값 num[i+1]이 더 큰 부분이 오름차순 정렬되어있는 순열 num[i]의 마지막 수열이된다.
예를 들어 7 2 3 6 5 4 1 의 수열이 있을때 num[i]의 다음 값이 큰 곳은 3과 6이다.
즉, 그 뒤에 있는 6 5 4 1 은 이미 내림차순 정렬이 되어있기떄문에7 2 3 의 마지막 수열이 되게 된다.
그 다음 수열은 3 다음으로 큰 수와 그 뒤의 수는 오름차순 정렬이 되어있어야한다.
7 2 4 1 3 5 6 이 7 2 3 6 5 4 1의 다음 수열이 되게 된다.
 */
public class 다음순열 {
	static int N;
	static int[] seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		seq = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		/*
		다음수열(nextPermutation)이 없는 마지막 수열인 경우 false,
		다음 수열이 존재하는 경우 true
		 */
		if (nextPermutation()) {
			for (int i = 0; i < N; i++) {
				sb.append(seq[i]).append(" ");
			}
		}else{
			sb.append(-1);
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	/*
	다음 수열을 알아보기 위해서는 3가지 단계를 거쳐야한다.
	1. num[i-1] < num[i] 인 수를 찾아야 한다. 그래야 다음 수열을 시작할 값을 가져올수 있다. 7 2 (3 6) 5 4 1
	2. i값이 1보다 작아지면 더이상 num[i]값보다 큰 값이 없다는 의미 즉, 내림차순이 완료가 되었다는 뜻이다. false 반환
	3. 1번을 통해 i-1값을 찾게되면, 뒤에서 부터 i-1 보다 큰 첫번째 수를 찾아야한다(i-1 뒤 부터는 내림차순이 되어있기때문에 역순으로 찾으면 i-1다음으로 큰수) 7 2 (3) 6 5 (4) 1
	4. num[i-1]값과 num[j] 값을 swap한다.i-1의 자리에 num[j]값이 오게 되고 num[j]의 뒤에 값부터 새로운 오름차순 순열이 생성되고 내림차순 정렬을 수행해야한다. 7 2 (4) 6 5 (3) 1
	5. i부터 마지막까지 즉, 새로 내림차순 정렬을 해줘야하는 시작 값의 뒤 부터 오름차순으로 정렬해줘야한다. 7 2 4 (1 3 5 6)
	 */
	static boolean nextPermutation() {
		int i = N - 1;
		while (i > 0 && seq[i - 1] >= seq[i]) {	//1
			i--;
		}
		if (i < 1) {	//2
			return false;
		}

		int j = N - 1;
		while (seq[i - 1] >= seq[j]) {	//3
			j--;
		}
		swap(i-1, j);	//4

		j = N - 1;
		while (i < j) {	//5
			swap(i, j);
			i++;
			j--;
		}

		return true;
	}

	static void swap(int i, int j) {
		int tmp = seq[j];
		seq[j] = seq[i];
		seq[i] = tmp;
	}

}
