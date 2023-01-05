package org.algorithm.java.hyunjong.Algorithm.BOJ.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NQueen {
	static int answer;
	static int N;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		check = new boolean[N];

		setQueen(arr, 0);

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void setQueen(int[] arr, int index) {
		if (index == N) {
			answer++;
			return;
		}

		for (int value = 0; value < N; value++) {
			arr[index] = value;
			if(!check[value] && isCross(arr, index, value)){
				check[value] = true;
				setQueen(arr, index+1);
				check[value] = false;
			}
		}
	}

	static boolean isCross(int[] arr, int currentY, int currentX){
		for(int y=0;y<currentY;y++){
			if(Math.abs(currentY-y)==Math.abs(currentX-arr[y])) return false;
		}

		return true;
	}
}
