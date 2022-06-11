package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 걷기 {
	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			//평면 이동
			long move1 = (long) (x+y)*w;

			//대각선 이동
			long move2 = 0;
			if((x+y)%2 == 0) move2 = (long) Math.max(x,y)*s;
			else move2 = (((long)Math.max(x,y)-1)*s)+w;

			//대각선 + 평면
			long move3 = 0;
			long cross = (long)Math.min(x,y)*s;
			long straight = ((long)Math.max(x,y)-(long)Math.min(x,y))*w;
			move3 = cross+straight;

			long answer = Math.min(move1, Math.min(move2,move3));

			bw.write(String.valueOf(answer));
			bw.flush();
			bw.close();
	}
}
