package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/*
N개의 숫자 사이에 +,-,' ' 의 연산자를 넣어서 0이되는 경우를 찾아야하기 때문에
브루트포스와 백트래킹을 통해서 각 숫자 사이에 3개의 연산자를 넣어 연산하는 모든 경우의 수를 구한다.
각 숫자 사이에 연산자를 넣은 경우를 완성하게되면 연산자가 포함된 문자열에서 연산자는 연산자리스트, 숫자는 숫자리스트에 저장
그렇게 되면 연산자리스트의 크기는 숫자리스트 크기의 -1이 되게 된다.
numberList.get(i-1) operationsList.get(i-1) numberList.get(i)로 계산해서 결과가 0이 나오게되면 해당 경우의 문자열을 stringbuilder에 저장한다.

여기서 연산자를 넣어주는 순서가 답에 영향을 미치므로 ' ',+,- 순으로 경우의 수를 만들어주도록 하자.
 */
public class 영만들기 {
	static Character[] operation = {' ','+','-'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			int[] numArr = new int[N];

			for(int i=0;i<N;i++){
				numArr[i] = i+1;
			}

			setOp(numArr,"", 0, N, sb);

			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void setOp(int[] numArr, String s, int index, int N, StringBuilder sb) {
		if (index == N-1) {
			s += numArr[index];
			checkZero(s, sb);
			return;
		}

		for(int i=0;i<3;i++){
			String temp = s+numArr[index]+operation[i];
			setOp(numArr, temp, index+1, N, sb);
		}
	}

	static void checkZero(String s, StringBuilder sb){
		List<Integer> numbers = new ArrayList<>();
		List<Character> operations = new ArrayList<>();

		String resultString = s;
		resultString = s.replaceAll(" ","");
		for (int i = 0; i < resultString.length(); i++) {
			String n = "";

			while (i < resultString.length() && (resultString.charAt(i) != '+' && resultString.charAt(i) != '-')) {
				n = n + resultString.charAt(i);
				i++;
			}

			numbers.add(Integer.parseInt(n));

			if (i < resultString.length() && (resultString.charAt(i) == '+' || resultString.charAt(i) == '-')) {
				operations.add(resultString.charAt(i));
			}
		}

		int result = numbers.get(0);
		for(int i=1;i<numbers.size();i++){
			if(operations.get(i-1)=='+'){
				result += numbers.get(i);
			}else{
				result -= numbers.get(i);
			}
		}
		if(result == 0) sb.append(s).append("\n");
	}
}
