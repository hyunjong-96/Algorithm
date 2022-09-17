package org.algorithm.java.hyunjong.Algorithm.BOJ.완전탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
첫번째 풀이에서는 A,C,G,T의 뉴클레오티드를 가지고 길이 M의 DNA를 만들고 DNA들과 비교했다.
이건 시간복잡도를 잘못생각했는데  4^50이 나오니까 절대 될리가 없다.

두번째 풀이에서는 HammingDistance는 각 뉴클레오티드가 다른 개수이므로, 각 자리의 가장 많은 뉴클레오티드를 넣어주어야한다.
DNAS[자리 index][뉴클레오티드]로 놓고 개수를 구한다음. 가장 큰 뉴클레오티드를 넣어주는 식으로 구현
하지만 간과한 사실이, HammingDistance가 여러개있을때 사전 앞순의 DNA를 반환해야한다.

세번째 풀이
DNAS의 두번째 배열에서 A,T,G,C로 선언했던것을 G,T,C,A로 변경하여 사전순으로 뉴클레오티드가 정렬되게 바꾸어주었고
각 뉴클레오티드의 개수를 비교할때도 DNAS[j][뉴클레오티드] > count를 DNAS[j][뉴클레오티드] >= count로 변경해주었다.
 */
public class DNA {
	/*
	0 : T, 1 : G, 2 : C, 3 : A
	 */
	static int[][] DNAS;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);


		DNAS = new int[M][4];
		for (int i = 0; i < N; i++) {
			String dna = br.readLine();
			for(int j=0;j<M;j++){
				char n = dna.charAt(j);
				if(n=='T'){
					DNAS[j][0]++;
				}else if(n=='G'){
					DNAS[j][1]++;
				}else if(n=='C'){
					DNAS[j][2]++;
				}else{
					DNAS[j][3]++;
				}
			}
		}

		StringBuilder dna = new StringBuilder();
		int hammingDistance = 0;
		for(int i=0;i<M;i++){
			String n = "T";
			int count=DNAS[i][0];
			if(DNAS[i][1] >= count){
				n = "G";
				count = DNAS[i][1];
			}
			if(DNAS[i][2] >= count){
				n = "C";
				count = DNAS[i][2];
			}
			if(DNAS[i][3] >= count){
				n = "A";
				count = DNAS[i][3];
			}
			dna.append(n);
			hammingDistance += N-count;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(dna);
		sb.append("\n");
		sb.append(hammingDistance);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
