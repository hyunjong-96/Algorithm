package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 기적의매매법 {
	static final String JUN_ANSWER = "BNP";
	static final String SUNG_ANSWER = "TIMING";
	static final String SAME_ANSWER = "SAMESAME";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] jusik = new int[14];
		for (int i = 0; i < 14; i++) {
			jusik[i] = Integer.parseInt(st.nextToken());
		}

		int junCost = M;
		int sungCost = M;
		//0:jun, 1:sung
		int[] jusikCount = new int[2];
		int[] sungMinGraph = new int[2];
		for (int i = 0; i < 14; i++) {
			//준현
			//해당 주식을 1개 이상 살수 있는 경우 준현은 산다.
			if(junCost/jusik[i] > 0 && junCost/jusik[i] > 0){
				jusikCount[0] += junCost/jusik[i];
				junCost -= (junCost/jusik[i])*jusik[i];
			}

			//성민
			if(i==0) continue;

			//오늘 주식이 하락장일때
			if(jusik[i-1] > jusik[i]){
				//0 : 연속상승개수, 1 : 연속 하락 개수
				sungMinGraph[0]=0;
				sungMinGraph[1]++;

				//연속 내림이 3일 이상이고 1개 이상의 주식을 살 수 있을때 주식을 살수 있는만큼 산다
				if(sungMinGraph[1]>=3 && sungCost/jusik[i] > 0){
					//성민의 주식 개수를 추가해준다.
					jusikCount[1] += sungCost/jusik[i];
					//가진 돈을 감소시킨다.
					sungCost -= (sungCost/jusik[i])*jusik[i];
					// sungMinGraph[1]=0;
				}
			}
			//오늘 주식이 상승장일때
			else if(jusik[i-1] < jusik[i]){
				//상승개수 추가
				sungMinGraph[0]++;
				sungMinGraph[1] = 0;

				//연속 상승 개수가 3일 이상이라면
				if(sungMinGraph[0]>=3){
					sungCost += jusik[i]*jusikCount[1];
					jusikCount[1]=0;
					// sungMinGraph[0]=0;
				}
			}
		}

		String answer = SAME_ANSWER;
		int junResult = junCost + jusik[13]*jusikCount[0];
		int sungResult = sungCost + jusik[13]*jusikCount[1];
		if(junResult > sungResult){
			answer = JUN_ANSWER;
		}else if(junResult < sungResult){
			answer = SUNG_ANSWER;
		}

		bw.write(answer);
		bw.flush();
		bw.close();
	}
}
