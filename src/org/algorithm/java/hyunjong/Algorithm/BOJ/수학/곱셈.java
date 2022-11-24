package org.algorithm.java.hyunjong.Algorithm.BOJ.수학;

import java.io.*;
import java.util.StringTokenizer;
public class 곱셈{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long answer = moduler(A,B,C);
		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static long moduler(long A, long B, long C){
		if(B==1) return A%C;

		long tmp = moduler(A%C, B/2, C);

		if(B%2==0) {
			return (tmp*tmp)%C;
		}else{
			return (tmp*tmp)%C*A%C;
		}
	}
}
