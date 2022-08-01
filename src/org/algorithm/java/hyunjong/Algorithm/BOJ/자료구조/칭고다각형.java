package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

/*
천장을 덮을 기둥은 가운데 가장 높은 기둥을 기준으로 좌우가 가장 높은 기둥보다 낮아야하며
가장 높은 가운데 기둥을 기준으로 왼쪽은 왼쪽 첫번째 기둥부터 높이가 오름차순인 기둥이 세워져야한다.
가장 높은 가운데 기둥을 기준으로 오른쪽은 오른쪽 마지막 기둥부터 높이가 오름차순인 기둥이 세워져야한다.
왼쪽 기둥부터 가장 높은 기둥의 위치까지 점점 높은 기둥을 선택하여 stack에 넣고
	stack.peek()의 높이(이전 기둥의 높이)보다 큰 기둥이 들어오게되면 이전에 있던 기둥에서 현재 기둥의 위치까지의 면적을 구한다.
마찬가지로 오른쪽기둥부터 가장 높은 기둥의 위치까지 점점 높은 기둥을 선택하여 stack에 넣어 기둥 범위를 구한다.
이때 높이가 동일한 기둥은 먼저들어온 기둥의 위치를 기준으로 다음에 해당 기둥보다 높은 기둥이 들어올때 위치를 기준으로 범위를 구하면되기 때문에
	동일한 높이의 기둥은 계산하지 않는다.
그렇기 때문에 가운데에서 가장 높이가 긴 기둥이 하나든 하나 이상이든 범위 계산이 되지 않으므로
가장 긴 기둥의 개수를 구하여 마지막에 가장 긴 기둥의 범위를 구해준다.
 */
public class 칭고다각형 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[][] pillars = new int[N][3];

		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			pillars[i][0] = L;
			pillars[i][1] = H;
			pillars[i][2] = 0;
		}
		Arrays.sort(pillars, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2){
				return o1[0]-o2[0];
			}
		});

		int maxIdx = 0;
		int maxCount=1;
		for(int i=0;i<N;i++){
			if(pillars[maxIdx][1] < pillars[i][1]) {
				maxIdx = i;
				maxCount = 1;
			}else if(pillars[maxIdx][1] == pillars[i][1]) maxCount=pillars[i][0]-pillars[maxIdx][0]+1;
		}

		int answer=0;

		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<=maxIdx;i++){
			if(stack.isEmpty()){
				stack.push(i);
			}else{
				if(pillars[stack.peek()][1] < pillars[i][1]){
					answer += pillars[stack.peek()][1] * (pillars[i][0]-pillars[stack.peek()][0]);
					stack.push(i);
				}
			}
		}


		stack = new Stack<>();
		for(int i=N-1;i>=maxIdx;i--){
			if(stack.isEmpty()){
				stack.push(i);
			}else{
				if(pillars[stack.peek()][1] < pillars[i][1]){
					answer += pillars[stack.peek()][1] * (pillars[stack.peek()][0]-pillars[i][0]);
					stack.push(i);
				}
			}
		}

		answer += maxCount * pillars[maxIdx][1];

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
