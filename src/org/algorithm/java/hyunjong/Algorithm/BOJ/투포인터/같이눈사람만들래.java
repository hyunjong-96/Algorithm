package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 같이눈사람만들래 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] snow = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++){
			snow[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(snow);

		int answer = Integer.MAX_VALUE;
		for(int elsaStart=0;elsaStart<N;elsaStart++){
			for(int elsaEnd=N-1;elsaEnd>elsaStart;elsaEnd--){
				int elsaSnowMan = snow[elsaStart]+snow[elsaEnd];
				int annaStart = 0;
				int annaEnd = N-1;

				while(annaStart<annaEnd){
					if(annaStart == elsaStart || annaStart == elsaEnd){
						annaStart++;
						continue;
					}
					if(annaEnd == elsaEnd || annaEnd == elsaStart){
						annaEnd--;
						continue;
					}

					int annaSnowMan = snow[annaStart]+snow[annaEnd];
					answer = Math.min(answer, Math.abs(elsaSnowMan - annaSnowMan));

					if(elsaSnowMan < annaSnowMan){
						annaEnd--;
					}else if(elsaSnowMan > annaSnowMan){
						annaStart++;
					}else{
						break;
					}
				}
			}
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}
}
