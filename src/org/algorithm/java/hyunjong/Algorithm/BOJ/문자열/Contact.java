package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*regex을 사용할줄 아는지 물어보는 문제
str.matches(regex) : 문자열이 regex을 만족하는지
() : 괄호 안의 문자를 하나의 문자로 인식
+ : 앞의 문자 하나가 1개 이상
| : 패턴안에서 or연산 수행
 */
public class Contact {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String reg = "(100+1+|01)+";
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T-- > 0){
			String S = br.readLine();
			if(S.matches(reg)) sb.append("YES");
			else sb.append("NO");
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
