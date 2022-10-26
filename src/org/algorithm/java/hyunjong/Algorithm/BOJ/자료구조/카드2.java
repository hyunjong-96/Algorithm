package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2 {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int N = Integer.parseInt(br.readLine());
			Queue<Integer> queue = new LinkedList<>();

			for(int i=1;i<=N;i++){
				queue.offer(i);
			}

			while(queue.size() > 1){
				queue.remove();
				if(queue.size()==1) break;

				int out = queue.poll();
				queue.offer(out);
			}

			bw.write(String.valueOf(queue.poll()));
			bw.flush();
			bw.close();
		}
}
