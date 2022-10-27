package org.algorithm.java.hyunjong.Algorithm.BOJ.수학;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 벌집 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();

		int num = 1;
		int plus = 1;
		while(num <= N){
			list.add(num);
			num += plus++*6;
		}
		list.add(num);

		int index = 1;
		for(int n : list){
			if(n >= N){
				break;
			}
			index++;
		}

		bw.write(String.valueOf(index));
		bw.flush();
		bw.close();
	}
}
