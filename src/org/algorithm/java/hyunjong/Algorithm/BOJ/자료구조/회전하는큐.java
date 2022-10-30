package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
Deque만 생각해서 접근하지 못했는데, 생각만 조금 다르게 하면 쉽게 풀수있는 문제였다.
찾고자 하는 숫자를 찾기 위해 2,3번 연산 중 어떤걸 수행해야 최소값이 나올지 못구했는데
LinkedList를 통해 indexOf를 통해 찾고자하는 숫자의 위치를 파악해 중간값보다 작다면 2번 연산을,
	중간값보다 크다면 3번 연산을 수행해주면 되었었다.
N의 크기가 50인 이유가 있었는데 indexOf를 해서 찾아주는데 문제없는 크기였다.

그리고 linkedlist의 size가 찾고자하는 숫자의 위치가 짝수일때는 중간값보다 작은경우 2번을,
	홀수일때는 중간값보다 작거나 같은 경우 2번 연산을 해주어야 최소가 나오기 때문에 이를 분기처리해준다.
 */
public class 회전하는큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		LinkedList<Integer> dq = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			dq.add(i);
		}

		st = new StringTokenizer(br.readLine(), " ");
		int[] findIdx = new int[M];
		for (int i = 0; i < M; i++) {
			findIdx[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		for (int idx : findIdx) {
			while (true) {
				int targetIdx = dq.indexOf(idx);
				int mid = dq.size() / 2;

				if (targetIdx == 0) {
					dq.removeFirst();
					break;
				} else {
					if (dq.size() % 2 == 0) {
						if (targetIdx < mid) {
							int tmp = dq.removeFirst();
							dq.add(tmp);
						} else {
							int tmp = dq.removeLast();
							dq.addFirst(tmp);
						}
					}else{
						if(targetIdx<=mid){
							int tmp = dq.removeFirst();
							dq.addLast(tmp);
						}else{
							int tmp = dq.removeLast();
							dq.addFirst(tmp);
						}
					}

					count++;
				}
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
