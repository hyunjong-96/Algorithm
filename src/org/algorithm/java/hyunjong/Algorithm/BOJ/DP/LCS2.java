package org.algorithm.java.hyunjong.Algorithm.BOJ.DP;

import java.util.Scanner;

public class LCS2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();

		int dp[][] = new int[s2.length() + 1][s1.length() + 1];

		char[] s1Arr = new char[s1.length()+1];
		char[] s2Arr = new char[s2.length()+1];
		for(int i = 1;i<=s1.length();i++){
			s1Arr[i] = s1.charAt(i-1);
		}
		for(int i = 1;i<=s2.length();i++){
			s2Arr[i] = s2.charAt(i-1);
		}

		for (int i = 1; i < s2Arr.length; i++) {//Y
			for (int j = 1; j < s1Arr.length; j++) {//X
				if (s2Arr[i] == s1Arr[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		int lastDP = dp[s2Arr.length-1][s1Arr.length-1];
		System.out.println(lastDP);

		int currentDP = lastDP;
		StringBuilder st = new StringBuilder();
		int x = s1Arr.length-1;
		int y = s2Arr.length-1;
		while (currentDP != 0){
			if(dp[y-1][x] == currentDP){
				y -= 1;
			}else if(dp[y][x-1] == currentDP){
				x -=1;
			}else{
				st.append(s1Arr[x]);
				x -=1;
				y -=1;
			}
			currentDP = dp[y][x];
		}
		if(lastDP != 0){
			System.out.println(st.reverse());
		}
	}
}
