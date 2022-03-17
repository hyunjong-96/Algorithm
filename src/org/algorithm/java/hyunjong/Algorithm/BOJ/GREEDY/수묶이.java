package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수묶이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		List<Integer> minusList = new ArrayList<>();
		List<Integer> plusList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n > 0) {
				plusList.add(n);	//pluseList에는 양수를 넣어준다.
			} else {
				minusList.add(n);	//minusList에는 음수와 0을 넣어준다.
			}
		}

		//양수 리스트와 음수 리스트를 정렬하게되면
		// 음수의 값들은 서로 곱하면 값이 커지고  0과 곱했을때 값이 더 커지게 되기떄문.
		//양수의 값들은 서로 곱하면 값이 커지고 1일 경우 더하는 경우가 더 커지기 때문.
		Collections.sort(minusList);
		Collections.sort(plusList);

		int sum = 0;
		int i = 0;
		/*
		minusList의 크기가 1일때는 하나있는 값만 sum에 더해준다.
		그렇지 않은 경우 minusList의 minusList.size() -2까지 만 탐색한다.
		size가 짝수일경우에는 모든 음수 또는 0의 값을 곱해서 sum에 더해준다..
		홀수일 경우에는 하나의 값을 제외하고는 모두 곱을 한 결과값에 sum을 더해준다.
		홀수가 되면 i값은 size-1값이 되게 되는데 이 값을 sum에 더해준다.
		 */
		if (minusList.size() == 1) {
			sum += minusList.get(0);
		} else {
			for (i = 0; i < minusList.size() - 1; i += 2) {
				sum += minusList.get(i) * minusList.get(i + 1);
			}
			if (i == minusList.size() - 1) {
				sum += minusList.get(i);
			}
		}

		/*
		양수리스트도 마찬가지로 size가 1일때는 하나의 값만 sum에 더해준다.
		양수 리스트는 뒤에서 부터 자신 또는 자신의 앞에 있는 값이 1이 아닌 이상 곱해준다.
		size가 짝수일 경우에는 모든 값을 비교해서 곱하거나 더해줄수 있고
		홀수일 경우에는 하나의 값(size-1 인덱스)만 남도록 index 1 까지만 탐색해준다. 그리고 남은 index 0의 값을 sum에 더해준다.
		 */
		if (plusList.size() == 1) {
			sum += plusList.get(0);
		} else {
			for (i = plusList.size() - 1; i > 0; i -= 2) {
				if(plusList.get(i) == 1 || plusList.get(i-1) == 1){
					sum += plusList.get(i);
					sum += plusList.get(i-1);
				}else{
					sum += plusList.get(i) * plusList.get(i - 1);
				}
			}
			if (i == 0){
				sum += plusList.get(i);
			}
		}

		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}
