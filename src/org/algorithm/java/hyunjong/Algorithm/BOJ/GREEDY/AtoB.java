package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
처음에는 BFS로 풀었으나 A,B가 최대로 가질수 있는 값이 10^9이 너무나 큰 수라 메모리 초과 발생
A->B 가 아닌 B->A로 가는 방법을 사용했다.
B->A로 갈때의 조건은 B가 짝수이거나(A->B로 갈때 *2이기 떄문), 맨 뒤의 숫자가 1인경우(A->B일 때 뒤에 1을 추가)
B가 A보다 작아 질때까지 반복문을 돌리고 B가 A보다 작아질때, B가 2의 배수도 아니고 맨 뒤의 숫자가 1이 아닌경우에는
더 이상 B를 A로 만들수 없기 때문에 -1을 출력
그렇지 않다면 맨 뒤의 숫자가 1인 경우 1을 제거하면서 count, 2의 배수라면 2를 나누어 주면서 count
결과값이 count가 된다.
B가 10^9가 되어도 A->B로 가기 위해 모든 경우(*2, 1추가)를 다 확인하는 것에 비해 훨씬 가벼워짐
 */
public class AtoB {
	static int A;
	static int B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		int count = 1;
		while (B != A) {
			if (B < A) {
				count = -1;
				break;
			}
			String sB = String.valueOf(B);

			if (B % 2 != 0 && sB.charAt(sB.length() - 1) != '1') {
				count = -1;
				break;
			}

			if(sB.charAt(sB.length()-1) == '1'){
				B = Integer.parseInt(sB.substring(0, sB.length()-1));
				count++;
			}else{
				B = B/2;
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
