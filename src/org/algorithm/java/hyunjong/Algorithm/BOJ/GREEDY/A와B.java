package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
S부터 모든경우의 수를 판단하여 T를 만들수있는지 여부를 확인하는 것은 시간복잡도가 너무 오래걸린다.
그렇기 때문에 T에서부터 조건에 따라 T의 문자를 제거하면서 S길이만큼 되었을 경우 같은지 판단하면 O(N)으로 끝낼수 있다.
 */
public class A와B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String S = br.readLine();
		String T = br.readLine();

		while(T.length() > S.length()){
			char lastChar = T.charAt(T.length()-1);

			if(lastChar == 'A'){
				T = T.substring(0, T.length()-1);
			}else if(lastChar =='B'){
				T = T.substring(0, T.length()-1);
				StringBuilder sb = new StringBuilder(T);
				sb.reverse();
				T = sb.toString();
			}else{
				break;
			}
		}

		int answer = 0;
		if(T.length() == S.length() && T.equals(S)){
			answer = 1;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
