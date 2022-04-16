package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
이런 생 구현문제에 너무 약한것 같다. 결국 다른 분들의 풀이를 보았다.
checkRoad라는 특정 라인(행 or 열)을 문제에서 주어주는 조건인 경사로의 바닥이 L이상이고 경사의 차이가 2이상이 아닌 길을 찾는 메소드를 만들어준다.
그리고 반환값을 boolean으로 처리하여 checkRoad가 true를 반환하면 길의 갯수를 구하는 count를 카운트해준다.
각 조건에 맞는 코드만 잘 짜면 되는데 참 쉽지가 않은것같다.
 */
public class 경사로 {
	static int N;
	static int L;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			int[] rowLine = new int[N];
			int[] colLine = new int[N];
			for (int j = 0; j < N; j++) {
				rowLine[j] = map[i][j];
				colLine[j] = map[j][i];
			}
			if (checkRoad(rowLine))
				count++;
			if (checkRoad(colLine))
				count++;
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}

	static boolean checkRoad(int[] line) {
		int h = line[0];
		boolean[] visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			//높이차가 동일하다면 다음 높이 비교.
			if (h == line[i])
				continue;
			//높이 차가 2이상이면 불가능.
			if (Math.abs(h - line[i]) > 1)
				return false;
			//이전 높이보다 1 낮다면
			if (h - line[i] == 1) {
				//i부터 L개(i+L-1)까지의 index를 비교한다.(i도 L개에 포함되기 때문)
				for (int j = 0; j < L; j++) {
					//i+j가 N 이상이거나 이미 경사로가 놓여져있거나 이전 높이와 다르다면 false
					if(i+j >= N || visit[i+j] || line[i] != line[i+j]) return false;
					//조건을 통과하면 경사로를 놓아준다.
					visit[i+j]=true;
				}
			}
			//이전 높이보다 1 낮다면
			else if (h - line[i] == -1) {
				//i-1부터 L개(i-L)까지의 index를 거꾸로 비교한다(i는 L개에 포함되지 않는다)
				for (int j = 0; j < L; j++) {
					//i-1-j가 0이하거나 이미 경사로가 놓아져있거나 이후 높이와 다르다면 false
					if(i-1-j<0 || visit[i-1-j] || line[i-1] != line[i-1-j]) return false;
					//조건을 통과하면 경사로를 놓아준다.
					visit[i-1-j] = true;
				}
			}
			h = line[i];
		}
		return true;
	}
}
