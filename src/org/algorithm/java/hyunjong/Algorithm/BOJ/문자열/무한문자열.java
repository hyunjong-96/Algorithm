package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
두 문자열이 무한대로 증가할때 동일한 무한 문자열이 되는지 확인해야한다.
무한대로 증가할때, 두 문자열이 같은 길이일때 각 문자를 비교해보면 무한대로 증가했을때에도 동일한지 확인할 수 있다.
공통 길이를 알기 위해서 최소공배수를 유클리드 호제법을 이용해 구한다.
그리고 최소공배수만큼 각 문자열을 복사해주고 최소공배수만큼 문자열을 비교해서 하나라도 다르다면 0을 모두 같다면 1을 반환한다.
 */
public class 무한문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String w1 = br.readLine();
		String w2 = br.readLine();
		int gcd = getGCD(w1.length(), w2.length());

		int lcm = w1.length()*w2.length()/gcd;

		StringBuilder sb1 = new StringBuilder(w1);
		while(sb1.length() < lcm){
			sb1.append(w1);
		}
		StringBuilder sb2 = new StringBuilder(w2);
		while(sb2.length() < lcm){
			sb2.append(w2);
		}

		boolean isEquals = true;
		for(int i=0;i<lcm;i++){
			if(sb1.charAt(i) != sb2.charAt(i)) {
				isEquals=false;
				break;
			}
		}

		String answer = isEquals ? "1" : "0";
		bw.write(answer);
		bw.flush();
		bw.close();
	}

	//유클리드 호제법
	static int getGCD(int a, int b){
		int min = Math.min(a, b);
		int gcd = 0;
		for(int i=1;i<=min;i++){
			if(a%i == 0 && b%i == 0){
				gcd = i;
			}
		}

		return gcd;
	}
}
