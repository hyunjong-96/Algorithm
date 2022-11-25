package org.algorithm.java.hyunjong.Algorithm.BOJ.재귀;

import java.io.*;
import java.util.StringTokenizer;
public class Z{
	static int count = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int size = (int)Math.pow(2,N);
		find(size, r, c);

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}

	static void find(int size, int r, int c){
		if(size == 1) return;

		if(size/2 > r && size/2 > c){
			find(size/2, r, c);
		}else if(size/2 > r && size/2 <= c){
			count += (size*size)/4;
			find(size/2, r, c-size/2);
		}else if(size/2 <= r && size/2 > c){
			count += (size*size/4)*2;
			find(size/2, r-size/2, c);
		}else{
			count += (size*size/4)*3;
			find(size/2, r-size/2, c-size/2);
		}
	}
}