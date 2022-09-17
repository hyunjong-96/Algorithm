package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
각 스티커를 하나씩 비교해보면서 스티커를 붙이는 8가지와 비교하여 겹치지않고 모눈종이 안에 접하는 최대 넓이를 구한다.
s1의 R,C와 s2의 R,C를 세로로 이어붙이고 가로로 이어붙이면서 90도씩 돌려보며 비교한다.
- 스티커를 세로로 이어붙였을 때 H를 넘지않고 두 스티커의 가로 중 큰 값이 W를 넘지않는 경우(4가지)와
- 스티커를 가로로 이어붙였을 때 W를 넘지않고 두 스티커의 세로 중 큰 값이 H를 넘지않는 경우(4가지)

(기존 스티커가 ㅣㅣ 일때)
s1[0] + s2[0] <= H && Math.max(s1[1],s2[1]) <= W
	ㅣ
	ㅣ
s1[0] + s2[1] <= H && Math.max(s1[1],s2[0]) <= W
	ㅣ
	ㅡ
s1[1] + s2[0] <= H && Math.max(s1[0],s2[1]) <= W
	ㅡ
	ㅣ
s1[1] + s2[1] <= H && Math.max(s1[0],s2[0]) <= W
	ㅡ
	ㅣ
s1[0] + s2[0] <= W && Math.max(s1[1],s2[1]) <= H
	ㅣㅣ
s1[0] + s2[1] <= W && Math.max(s1[1],s2[0]) <= H
	ㅣㅡ
s1[1] + s2[0] <= W && Math.max(s1[0],s2[1]) <= H
	ㅡ ㅣ
s1[1] + s2[1] <= W && Math.max(s1[0],s2[0]) <= H
	ㅡ ㅡ

이 중 하나라도 조건을 만족한다면 두 스티커의 넓이를 구해서 area에 갱신한다. (area는 MAX만 가지게 된다)

처음에는 두 스티커의 가로,세로를 모두 더해가며 값을 구했더니 실패해서 스티커를 붙이는 경우의 수 8개를 모두 찾아주었다.
 */
public class 두스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] paperInfo = br.readLine().split(" ");
		int H = Integer.parseInt(paperInfo[0]);
		int W = Integer.parseInt(paperInfo[1]);
		int N = Integer.parseInt(br.readLine());
		//0:R 1:C
		int[][] stickers = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] stickersInfo = br.readLine().split(" ");
			stickers[i][0] = Integer.parseInt(stickersInfo[0]);
			stickers[i][1] = Integer.parseInt(stickersInfo[1]);
		}

		int area = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				int[] s1 = stickers[i];
				int[] s2 = stickers[j];

				if (s1[0] + s2[0] <= H && Math.max(s1[1],s2[1]) <= W
					|| s1[0] + s2[1] <= H && Math.max(s1[1],s2[0]) <= W
					|| s1[1] + s2[0] <= H && Math.max(s1[0],s2[1]) <= W
					|| s1[1] + s2[1] <= H && Math.max(s1[0],s2[0]) <= W
					|| s1[0] + s2[0] <= W && Math.max(s1[1],s2[1]) <= H
					|| s1[0] + s2[1] <= W && Math.max(s1[1],s2[0]) <= H
					|| s1[1] + s2[0] <= W && Math.max(s1[0],s2[1]) <= H
					|| s1[1] + s2[1] <= W && Math.max(s1[0],s2[0]) <= H
				) {
					area = Math.max(area, s1[0]*s1[1]+s2[0]*s2[1]);
				}
			}
		}

		bw.write(String.valueOf(area));
		bw.flush();
		bw.close();
	}
}
