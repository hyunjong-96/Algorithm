package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
dp를 이용해서 dp[i][j]에 부분 문자열 길이를 저장해준다.
연속되는 부분 문자열의 길이를 계산하기 위해 왼쪽 대각선의 값이 필요하기 때문에 dp[S1.length()+1][S2.length()+1]로 가로,세로로 한칸씩 추가해준다.
그렇게 된다면 S1.charAt(i)는 dp[i+1][j]의 위치에 존재하게 된다.
S1.charAt(i) == S2.charAt(j)이면 dp[i+1][j+1]에 동일한 부분 문자열 +1을 해주고 dp[i][j]도 더해준다.
dp[i][j]를 더해주는 이유는 S1.charAt(i)와 S2.charAt(j)가 동일한 문자열이 나온곳 까지 연속되는 부분 문자열이라면
	왼쪽 대각선 dp[i][j]에 연속되는 부분 문자열의 길이가 저장된다.
	연속되는 부분 문자열이 아니라면 왼쪽 대각선이 0이므로 dp[i][j]에는 1만 더해지게 된다.
 */
public class 공통부분문자열{
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String S1 = br.readLine();
		String S2 = br.readLine();

		dp = new int[S1.length()+1][S2.length()+1];

		int answer = 0;
		for(int i=1;i<=S1.length();i++){
			for(int j=1;j<=S2.length();j++){
				if(S1.charAt(i-1) == S2.charAt(j-1)){
					dp[i][j] = 1+dp[i-1][j-1];
					answer = Math.max(dp[i][j], answer);
				}
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}

//메모리초과
// public class 공통부분문자열 {
// 	static Set<String> M1;
// 	static boolean[] check;
// 	static int answer;
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
// 		String S1 = br.readLine();
// 		String S2 = br.readLine();
//
// 		M1 = new HashSet<>();
// 		int size= Math.max(S1.length(), S2.length());
// 		check = new boolean[size+1];
// 		for(int i=0;i<S1.length();i++){
// 			setMap(S1, "", i);
// 		}
//
// 		answer=0;
// 		for(int i=0;i<S2.length();i++){
// 			compareString(S2, "", i);
// 		}
//
//
// 		bw.write(String.valueOf(answer));
// 		bw.flush();
// 		bw.close();
// 	}
//
// 	static void compareString(String S, String word, int idx){
// 		if(idx == S.length()) return;
//
// 		if(M1.contains(word)) answer = Math.max(answer, word.length());
//
// 		compareString(S, word+S.charAt(idx), idx+1);
// 	}
//
// 	static void setMap(String S, String word, int idx){
// 		if(idx == S.length()) return;
//
// 		M1.add(word);
// 		setMap(S, word+S.charAt(idx), idx+1);
// 	}
// }
