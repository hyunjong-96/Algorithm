package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
LCS(Longest Common Subsequence) 최장 공통 부분수열은 수열중 부분적으로 공통되는 수열들을 찾는 알고리즘.
최장 공통 부분 수열의 길이를 찾는 방법은
2차 배열을 이용해서 각 문자가 같다면 LCS[j-1][i-1]의 값에 +1을 해주고
문자가 다르다면 LCS[j-1][i]와 LCS[j][i-1]의 값중 큰값을 저장해준다.
최장 공통 부분 수열의 수열을 찾는 방법은
앞에서 설명된 공통 부분 수열의 길이를 구한 2차 배열에서
왼쪽과 위쪽 좌표를 비교하면서 같은 값이 있다면 해당 좌표로 이동
같은 값이 없다면 현재 좌표의 문자를 저장한 후 왼쪽이나 오른쪽 좌표로 이동하게 된다(이동하면 현재 좌표의 값보다 1작은 값)
그러고 난후 현재 다음 좌표가 0일때까지 반복하고 저장된 문자열을 역전시키면 최장 공통 수열이 나오게 된다.
 */
public class LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s1 = br.readLine();
		String s2 = br.readLine();

		int[][] LCS = new int[s2.length() + 1][s1.length() + 1];

		for (int j = 1; j < LCS.length; j++) {
			for (int i = 1; i < LCS[j].length; i++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					LCS[j][i] = LCS[j - 1][i - 1] + 1;
				} else {
					LCS[j][i] = Math.max(LCS[j - 1][i], LCS[j][i - 1]);
				}
			}
		}

		bw.write(String.valueOf(LCS[s2.length()][s1.length()]));
		bw.flush();
		bw.close();
	}
}
