package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
Deque를 이용해서 deque의 peek값이 해당 범위의 최소값이 되도록 한다.(Deque를 이용한 슬라이딩 윈도우)
deque의 0번째 인자는 숫자, 1번째 인자는 index를 저장한다.
deque에 들어오려는 index-L보다 deque.peek의 index가 작다면 슬라이딩 윈도우 범위에 벗어나는 숫자이므로 peek()값을 뺴준다.(pollFirst())
그리고 deque에 들어오려는 숫자가 최소값이라면 deque의 맨 앞부분에 위치해야하므로 deque안에 존재하는 숫자들을 제거해준다.
안에 있는 숫자를 제거해도 슬라이딩 윈도우 범위에서 가장 작은 숫자만 필요하기 때문에 deque에는 최소값의 수만 존재해도 풀이에는 상관없다.
들어오려는 숫자가 최소가 아니라면 일단 deque에 넣어놓는다. 앞의 숫자가 범위 밖으로 나갔을때 해당 숫자가 최소값이 될수도 있기 떄문이다.
 */
public class 최소값찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		Deque<int[]> dq = new LinkedList<>();

		st = new StringTokenizer(br.readLine(), " ");

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!dq.isEmpty() && dq.peek()[1] <= i - L) {
				dq.poll();
			}

			while (!dq.isEmpty()) {
				if(dq.peekLast()[0] > num){
					dq.pollLast();
				}else{
					break;
				}
			}
			dq.offer(new int[]{num,i});

			sb.append(dq.peekFirst()[0]);
			sb.append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
