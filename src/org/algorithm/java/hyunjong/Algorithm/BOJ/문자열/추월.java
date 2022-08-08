package org.algorithm.java.hyunjong.Algorithm.BOJ.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/*
추월 여부를 확인하기 위해 먼저 들어간 순서대로 탐색하면서
in[i]와 out[o]가 다르면 추월한것이기 때문에 개수를 새어주면서 in[i] == out[o]일때까지 반복한다.
이때 in[i]가 이미 추월해서 나간 차 일수 있기 때문에 Set으로 나간차를 넣어주고 set에 있다면 해당 in[i]는 넘어간다.
 */
public class 추월 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String[] in = new String[N];
		String[] out = new String[N];

		for(int i=0;i<N;i++){
			in[i] = br.readLine();
		}
		for(int i=0;i<N;i++){
			out[i] = br.readLine();
		}

		Set<String> outCar = new HashSet<>();
		int count=0;
		int o = 0;
		for(int i=0;i<N;i++){
			if(outCar.contains(in[i])) continue;

			while(!out[o].equals(in[i])){
				outCar.add(out[o]);
				count++;
				o++;
			}
			o++;
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
