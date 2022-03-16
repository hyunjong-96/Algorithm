package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 2칸 위로, 1칸 오른쪽
 * 1칸 위로, 2칸 오른쪽
 * 1칸 아래로, 2칸 오른쪽
 * 2칸 아래로, 1칸 오른쪽
 */
//https://songwonseok.github.io/algorithm/BOJ-1783/
public class 병든나이트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int max = 0;
		if (N == 1) {//1
			max = 1;
		} else if (N == 2) {//2

			if (M > 6)
				max = 4;
			else {
				max = (M+1) / 2;
			}
		} else {	//3
			if (M <= 4) {
				max = M;
			} else if (M == 5 || M == 6) {
				max = 4;
			} else {
				max = M - 2;
			}
		}
		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}

/*
1. N이 1일때는 아무 방향으로도 움직일수 없으므로 무조건 max = 1
2. N이 2일때는 2번방법과 3번 방법으로밖에 움직일수 없다 그렇기 때문에 (M+1)/2의 값이 max값이다.
하지만 M이 7이상 부터는 방문한 칸의 갯수가 4개 밖에 움직일수 없다(다른 방향으로 움직일수 없기때문) 그래서 M>=7부터는 무조건 max=4

3. N이 3이상일때는 모든 방향으로 움직일수 있다. 하지만 M<=4까지는 최대한 많이 움직이기 위해서 1번, 4번 방법으로만으로 움직인다.
 M==5, M==6일때는 1번,4번으로만 움직이면 방문한 칸이 4가 넘어버리기 때문에 방문한 칸을 4로 고정시킨다.
 M>=7부터는 모든칸을 움직일수 있기 때문에 모든칸을 움직였을때 M이 7이 되고 최대 방문한 칸은 5가 된다.
 M==7의 방문칸은 5, M==8의 방문칸은 6이기때문에 M>=7이상일때의 최대 방문 칸 갯수는 M-2가 된다.

 */
