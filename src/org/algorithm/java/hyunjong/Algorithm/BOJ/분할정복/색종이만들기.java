package org.algorithm.java.hyunjong.Algorithm.BOJ.분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
분할 정복
 */
public class 색종이만들기 {
	static int[][] paper;
	static int blue;
	static int white;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for(int i=0;i<N;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		blue = 0;
		white = 0;
		cut(N,N,N);

		StringBuilder sb = new StringBuilder();
		sb.append(white);
		sb.append("\n");
		sb.append(blue);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void cut(int x, int y, int size){
		int blueCount = 0;
		int whiteCount = 0;

		for(int i=y-size;i<y;i++){
			for(int j=x-size;j<x;j++){
				if(paper[i][j] == 1) blueCount++;
				else whiteCount++;
			}
		}

		if(blueCount * whiteCount == 0){
			if(blueCount != 0) blue++;
			else white++;
			return;
		}

		size /= 2;
		cut(x-size, y-size, size);
		cut(x-size, y, size);
		cut(x, y-size, size);
		cut(x,y,size);
	}
}
