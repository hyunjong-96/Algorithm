package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
nP3의 조합을 이용해서 약 3000000의 크기에서 M개를 하나하나 비교한다면 M은 최대가 10000이기 때문에 시간초과가 발생한다.
그렇기 때문에 2차원 boolean 배열을 사용해서 각 M의 조합의 위치에 true로 설정하여 3개의 아이스크림 조합이 만들어졌을때
2개씩 비교하여 unMatch[i][j], unMatch[j][i]가 true라면 맛이없는 조합이 되기 때문에 false를 반환한다.
M을 반복하는 것이 아닌 2차원 배열로 3P2(3) 으로 비교할수 있다.
 */
public class 한윤정이이탈리아에가서아이스크림을먹는데 {
	static boolean[][] unMatch;
	static int N;
	static int M;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		unMatch = new boolean[N+1][N+1];
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine()," ");
			int unMatch1 = Integer.parseInt(st.nextToken());
			int unMatch2 = Integer.parseInt(st.nextToken());

			unMatch[unMatch1][unMatch2] = true;
			unMatch[unMatch2][unMatch1] = true;
		}

		answer = 0;
		setIceCream(new int[3], new boolean[N+1], 1, 0);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void setIceCream(int[] iceCream, boolean[] check, int idx, int depth){
		if(depth == 3){
			if(isMatching(iceCream)) answer++;
			return;
		}

		for(int i=idx;i<=N;i++){
			if(!check[i]){
				check[i] = true;
				iceCream[depth] = i;
				setIceCream(iceCream, check, i+1, depth+1);
				iceCream[depth] = 0;
				check[i] = false;
			}
		}
	}

	static boolean isMatching(int[] iceCream){
		for(int i=0;i<3;i++){
			for(int j=i+1;j<3;j++){
				if(unMatch[iceCream[i]][iceCream[j]] && unMatch[iceCream[j]][iceCream[i]]) return false;
			}
		}
		return true;
	}
}
