package org.algorithm.java.hyunjong.Algorithm.BOJ.재귀;

import java.io.*;
import java.util.StringTokenizer;

public class Z_RE {
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		result = 0;
		setNumber(0, 0, 0, (int)Math.pow(2, N),r,c);

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}

	static void setNumber(int y, int x, int count, int length, int r, int c) {
		if (length == 1) {
			result = count;
			return;
		}

		int half = length / 2;
		if(half > r && half > c){
			setNumber(y, x, count , half, r, c);
		}
		else if(half > r && half <= c){
			count += (length*length)/4;
			setNumber(y, x+half, count, half, r, c-half);
		}
		else if(half <= r && half > c){
			count += ((length*length)/4)*2;
			setNumber(y+half, x, count, half, r-half, c);
		}
		else{
			count += ((length*length)/4)*3;
			setNumber(y + half, x + half, count, half, r-half, c-half);
		}
	}
}