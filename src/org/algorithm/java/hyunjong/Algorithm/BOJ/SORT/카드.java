package org.algorithm.java.hyunjong.Algorithm.BOJ.SORT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 카드 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		long[] array = new long[N];

		for (int i = 0; i < N; i++) {
			array[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(array);

		//maxCount =0이게되면 [1,2]일때 index값이 2가 되게된다.
		//하지만 같은 갯수를 가진 수라면 작은 정수를 출력해야하므로 maxCount=1로 초기화 해야한다.
		int maxCount = 1;
		int count=1;
		long index = array[0];
		for (int i = 1; i < N; i++) {
			if(array[i] == array[i-1]) count++;
			else count = 1;

			if(maxCount<count){
				maxCount = count;
				index = array[i];
			}
		}

		bw.write(String.valueOf(index));
		bw.flush();
		bw.close();
	}
}
