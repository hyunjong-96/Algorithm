package org.algorithm.java.hyunjong.Algorithm.BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
처음에는 그리디식으로 어떤 경우로 가야 짧은 시간안에 해결할수 있을까를 생각했다.
브루트 포스로 블럭의 최저 높이와 최고 높이를 구하여 이 사이의 높이를 기준으로 하여 space의 블럭을 제거하고 쌓는 식으로 구현했다.
이때 주의해야할 점은 내가 소유하고 있는 블럭의 개수 B를 직접 연산에 사용하게되면
다른 높이를 구하는데 추가되거나 삭제되었던 블럭이 영향을 미치기 때문에
B를 저장하는 변수를 하나 지정해주고 해당 높이에서 블럭을 제거하고 쌓는 연산을 한다.
즉, 초기 위치에서 h까지 만드는데 걸리는 시간과 최대 높이를 구하는것.
 */
public class 마인크래프트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int highest = 0;
		int lowest = 0;
		int[][] space = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				highest = Math.max(highest, space[i][j]);
				lowest = Math.min(lowest, space[i][j]);
			}
		}

		int time = Integer.MAX_VALUE;
		int high = 0;
		for (int h = lowest; h <= highest; h++) {
			int t = 0;
			int block = B;
			for(int i=0;i<N;i++){
				for(int j=0;j<M;j++){
					if(space[i][j] > h){
						int extra = space[i][j] - h;
						t += 2*extra;
						block += extra;
					}else if(space[i][j] < h){
						int need = h-space[i][j];
						t += need;
						block -= need;
					}
				}
			}

			if(block >= 0){
				if(t <= time){
					time = t;
					high = h;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(time);
		sb.append(" ");
		sb.append(high);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
