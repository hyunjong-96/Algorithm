package org.algorithm.java.hyunjong.Algorithm.BOJ.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class 에디터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		LinkedList<Character> memoList = new LinkedList<>();
		String s = br.readLine();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < s.length(); i++) {
			memoList.add(s.charAt(i));
		}

		//LinkedList를 사용하면 삽입삭제에서 빠른 효율을 낼수 있지만 검색시 해당 인덱스에 대한 값을 전체순환을 해서 찾아야하기 떄문에 시간초과 발생
		//ListIterator를 사용하면 위치를 검색하는 계산 없이 해당하는 위치에 계속있으면서 삽입/삭제를 처리할수 있다.
		ListIterator<Character> memo = memoList.listIterator(memoList.size());

		//memo가 가리키고 있는 인덱스는 해당 인덱스의 문자가 커서의 오른쪽에 있다는것.
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String method = st.nextToken();

			switch (method) {
				case "L":
					if(memo.hasPrevious()){
						memo.previous();
					}
					break;
				case "D":
					if (memo.hasNext()) {
						memo.next();
					}
					break;
				case "B":
					if (memo.hasPrevious()) {
						memo.previous();
						memo.remove();
					}
					break;
				case "P":
					char c = st.nextToken().charAt(0);
					memo.add(c);
					break;
			}
		}
		for(char c : memoList){
			sb.append(c);
		}
		System.out.println(sb);
	}
}
