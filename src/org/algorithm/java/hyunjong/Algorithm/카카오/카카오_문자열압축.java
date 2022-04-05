package org.algorithm.java.hyunjong.Algorithm.카카오;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 카카오_문자열압축 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ans = solution(br.readLine());
		bw.write(String.valueOf(ans));
		bw.flush();
		bw.close();
	}

	static int solution(String s) {
		int answer = s.length();

		//문자열 압축 단위
		for (int i = 1; i <= s.length() / 2; i++) {
			StringBuilder sb = new StringBuilder();
			//해당 압축 단위의 첫번째 문자열
			String prev = s.substring(0, i);
			String next = "";
			int cnt = 1;
			//첫번째 문자열 다음으로 오는 압축 단위의 문자를 비교하기 위한 반복문
			for (int j = i; j < s.length(); j += i) {
				/*
				다음 압축 문자열의 index + 압축 단위가 원본 문자열의 길이보다 같다면
				substring에서 끝 index는 해당 index의 -1 까지 문자열을 자르기 떄문에 괜찮다
				하지만 원본 문자열의 길이보다 크다면 더이상 비교해서 압축할수 없기 때문에
				j부터 남은 원본 문자열의 문자를 sb에 넣어준다.
				 */
				if(j+i > s.length()){
					sb.append(s.substring(j));
					break;
				}
				next = s.substring(j, j + i);
				if (prev.equals(next)) {
					cnt++;
				}else{
					if(cnt>1){
						sb.append(cnt).append(prev);
					}else{
						sb.append(prev);
					}
					cnt = 1;
				}
				prev = next;
			}
			/*
			만약 마지막 압축 단위까지 모두 비교했을때
			이전 반복문 내부에서 발생한 계산이 마무리 되지않고 반복문을 빠져나오게된다.
			그렇기 때문에 prev와 cnt의 값에 대해서 마무리 정리를 해준다.
			 */
			if(cnt>1){
				sb.append(cnt).append(prev);
			}else{
				sb.append(prev);
			}

			answer = Math.min(answer, sb.length());
		}

		return answer;
	}

}
