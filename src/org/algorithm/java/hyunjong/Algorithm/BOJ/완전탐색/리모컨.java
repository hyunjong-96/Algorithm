package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//O(n^2)의 시간복잡도를 가지고 있고 n이 1000000이기때문에 안될줄 알았는데 2초의 시간이라서 가능한것같다.
public class 리모컨 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int brokenCount = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10]; //boolean default is 'false'

		//망가진 버튼이 있다면 broken배열 초기화
		if(brokenCount != 0){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}

		//버튼 클릭의 초기화값은 '+','-'만 누른 경우.
		int move = Math.abs(N - 100);

		/*
		N<=500000 이지만 버튼을 모두 눌렀을경우 999999이기 때문에 버튼을 0~999999을 누른 모든 경우의 수를 확인한다.
		해당 버튼을 String으로 변경해서 2개 이상의 버튼(10의 자리 이상)을 눌렀을 경우를 확인할수있다.
		buttonLen은 누른 버튼의 수가 될것이고, String으로 변환한 button을 쪼개서 각각의 버튼의 고장여부를 확인한다.
		고장이 났을경우 버튼을 누를수 없기때문에 해당 버튼에 대한 로직은 넘어간다.
		고장이 나지 않았을경우 해당 버튼을 누르고(buttonLen) N까지 '+','-'를 누른갯수(Math.abs(N-Integer.parseInt(button))를 구하고,
		현재 움직인 횟수와 비교해서 적은값을 move에 재 선언해준다.
		 */
		for (int i = 0; i < 1000000; i++) {
			String button = String.valueOf(i);
			int buttonLen = button.length();

			boolean isBroken = false;
			for (int j = 0; j < buttonLen; j++) {
				int b = button.charAt(j)-'0';
				if (broken[b]) {
					isBroken = true;
					break;
				}
			}

			if (!isBroken) {
				int IntegerButton = Integer.parseInt(button);
				int buttonMove = Math.abs(N - IntegerButton) + buttonLen;
				move = Math.min(buttonMove, move);
			}
		}

		bw.write(String.valueOf(move));
		bw.flush();
		bw.close();
	}
}
