package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
특점 지점에서 모든 지점과의 차이의 합이 최소가 되기 위해서는 모든 지점에서의 중간값이 조건을 만족한다.(중간값의 성질)
그렇기 때문에 주어진 지점을 오름차순 정렬 후
홀수이면 가운뎃값, 짝수이면 가운뎃값 중 왼쪽의 값(같은 값이라면 왼쪽값을 가져와야함)을 가져와야하기 때문에
(지점의 개수-1)/2의 위치에 존재하는 지점이 모든 지점과의 차이 합이 최소가 나오는 지점이다.
 */
public class 안테나 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] home = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++){
			home[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(home);

		int answer = home[(N-1)/2];

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
