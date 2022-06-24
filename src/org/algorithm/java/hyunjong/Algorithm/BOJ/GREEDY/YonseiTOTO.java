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

public class YonseiTOTO {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] myMileage = new int[N];
		List<Integer>[] mileageOfSubject = new List[N];
		int[][] subjectInfo = new int[N][2];
		for (int i = 0; i < N; i++) {
			mileageOfSubject[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int P = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");

			subjectInfo[i] = new int[] {P, L};
			for (int l = 0; l < P; l++) {
				mileageOfSubject[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int i = 0; i < N; i++) {
			List<Integer> mileage = mileageOfSubject[i];

			mileage.sort(Collections.reverseOrder());

			int p = subjectInfo[i][0];
			int l = subjectInfo[i][1];

			if (p >= l) {
				int limitStudentsMileage = mileage.get(l-1);
				myMileage[i] = limitStudentsMileage;
			} else {
				myMileage[i] = 1;
			}
		}

		Arrays.sort(myMileage);

		int count = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += myMileage[i];
			if (sum > M)
				break;
			count++;
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
