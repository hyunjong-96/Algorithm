package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
방번호가 가장 큰 조건
1. 자릿수가 가장 많다
2. 방번호 앞자리가 가장 크다
 */
public class 방번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] cost = new int[N];
		int minCost = Integer.MAX_VALUE;
		int minCostRoom = -1;
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			if (cost[i] <= minCost) {
				minCost = cost[i];
				minCostRoom = i;
			}
		}
		int M = Integer.parseInt(br.readLine());

		int numberSize = M / minCost;
		int[] number = new int[numberSize];    //구매할수 있는 방번호(각 자리에 방번호 하나씩 들어간다)
		int start = 0;    //number의 시작 index
		int money = M % minCost;
		;    //남은 돈
		boolean flag = false;
		//최소 비용으로 number 초기화
		for (int i = 0; i < numberSize; i++) {
			number[i] = minCostRoom;
		}

		/*
		number 배열을 start index로 돌면서 다른 큰값들과 바꿀수 있는지 확인한다.
		현재 가지고 있는 money와 최소가격(number의 초기값)의 합이 cost의 맨뒤 index값(방 번호가 제일 높음)부터 비교
		교환이 가능하다면 해당 number의 인덱스에 해당 방번호로 변경, money값에서 해당되는 cost를 money += min-cost[i] 해준다.
		만약 바꿀수없다면 start를 +1로 이동시켜주고 money를 최소가격(number의 초깃값)을 더해준다. 자리수를 포기하고 최대한 큰값을 얻기위함
		 */
		for (int i = 0; i < numberSize; i++) {
			for (int j = cost.length-1; j >= 0; j--) {
				if (cost[j] <= money + minCost) {
					number[i] = j;
					money += minCost - cost[j];
					break;
				}
			}
			//number배열에서 start가 0이라는 것은 0으로 시작하는 방번호는 없기때문에 0의 가격을 money에 돌려줌으로써 다른 비싼 방번호를 얻기위함
			if (number[start] == 0) {
				start++;
				money+=minCost;
			}
		}

		if(start == numberSize){
			sb.append("0");
		}else{
			for (int i = start; i < numberSize; i++) {
				sb.append(number[i]);
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
