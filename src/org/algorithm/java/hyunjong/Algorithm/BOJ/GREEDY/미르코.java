package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 미르코 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] number = br.readLine().split("");
		Arrays.sort(number);
		int biggestNum = Integer.parseInt(number[number.length - 1]);
		int[] countNumArr = new int[biggestNum + 1];
		int total = 0;
		for (String s : number) {
			int num = Integer.parseInt(s);
			countNumArr[num]++;
			total += num;
		}

		//30의 배수가 되려면
		// 1. 주어진 값 즁 0이 무조건 포함되어야하고
		//2. 주어진 값의 합이 3의 배수여야한다.
		//해당 조건이 모두 만족하면 30의 배수이기 때문에 최대값은 각 숫자를 큰 값부터 정렬하면된다(counting sort)
		if (total % 3 != 0 || countNumArr[0] == 0) {
			bw.write("-1");
		} else {
			for (int i = countNumArr.length - 1; i >= 0; i--) {
				while (countNumArr[i]>0){
					sb.append(i);
					countNumArr[i]--;
				}
			}
			bw.write(sb.toString());
		}
		bw.flush();
		bw.close();
	}
}
