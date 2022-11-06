package org.algorithm.java.hyunjong.Algorithm.BOJ.누적합;

import java.io.*;
import java.util.StringTokenizer;

/*
i번째 악보의 난이도가 i+1번째 악보의 난이도보다 어려우면 실수한다.
질문의 개수가 최대 10만개이고 악보의 개수가 최대 10만개이기때문에 각 질문에서 악보를 선형탐색한다면 시간초과.

질문에서의 실수개수를 구하는 것이 O(1)이나 O(logN)이 되어야한다.

N번째 악보에서부터 i번째까지의 실수개수를 누적합으로 구한다면 O(1)로 x~y까지의 악보에서 발생한 실수개수를 구할 수 있다.

N-1번째 악보부터 1번째 악보까지 돌면서 i번째 악보가 i+1번쨰 악보보다 어렵다면 fail[i] = fail[i+1]+1이 된다. (실수 개수)
이를 반복하여 x~y범위의 실수 개수는 fail[x] - fail[y]를 구한다면 x에서 N까지의 실수 개수에서 y에서 N까지의 실수 개수를 빼준다면
x~y까지의 실수 개수를 구할 수 있다.
 */
public class 피아노체조{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] level = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++){
			level[i] = Integer.parseInt(st.nextToken());
		}

		int[] fail = new int[N+1];
		for(int i=N-1;i>0;i--){
			if(level[i] > level[i+1]){
				fail[i] = fail[i+1]+1;
			}else{
				fail[i] = fail[i+1];
			}
		}

		StringBuilder sb = new StringBuilder();
		int Q = Integer.parseInt(br.readLine());
		while(Q-- > 0){
			st = new StringTokenizer(br.readLine()," ");
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());

			sb.append(String.valueOf(fail[X]-fail[Y])).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
