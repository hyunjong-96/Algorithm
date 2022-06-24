package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class 전화번호목록 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (tc-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String[] numbers = new String[N];

			for (int i = 0; i < N; i++) {
				numbers[i] = br.readLine();
			}
			Arrays.sort(numbers);

			boolean isConsistency = true;
			for(int i=0;i<N-1;i++){
				if(numbers[i+1].startsWith(numbers[i])) {
					isConsistency = false;
					break;
				}
			}
			// for (int i = 0; i < N; i++) {
			// 	for (int j = 0; j <= i; j++) {
			// 		if(i==j || numbers[i].length() <= numbers[j].length()) continue;
			//
			// 		if(numbers[i].startsWith(numbers[j])){
			// 			isConsistency = false;
			// 			break;
			// 		}
			// 	}
			// 	if(!isConsistency) break;
			// }

			if(isConsistency){
				sb.append("YES");
			}else{
				sb.append("NO");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
