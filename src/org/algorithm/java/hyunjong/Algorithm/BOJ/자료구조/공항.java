package org.algorithm.java.hyunjong.Algorithm.BOJ.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
비행기가 도킹할수 있는 최대 게이트 gi
union[gi]는 gi가 도킹할수있는 게이트를 가리킨다.
docking[union[gi]] == false라면 해당 게이트(gi)에 도킹할 수 있는 것이다.
	docking[union[gi]] = true로 변경하고 count를 +1 증가시킨다.
docking[union[gi]] == true라면 해당 게이트(gi)에 도킹할 수 없다.
	union을 -1감소시키고 다시 docking[union[gi]]를 체크한다.
만약 union[gi] == 0이되면 더이상 gi에는 도킹할 수없기 때문에 현재까지의 count를 반환한다.
비행기를 최대한 많이 도킹하기 위해서는 1부터 게이트를 확인하는것이아니라
	현재 도킹할 수 있는 최대 게이트 gi에서부터 gi-1 게이트씩 확인하면서 도킹가능한 게이트를 찾는다.
	앞의 비행기에서 다른 비행기의 gi에 도킹을 해도 최대 도킹개수는 정해져있기 떄문에 가능.
 */
public class 공항 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int[] airplane = new int[P + 1];
		for (int i = 1; i <= P; i++) {
			airplane[i] = Integer.parseInt(br.readLine());
		}
		int[] union = new int[G+1];
		for(int i=1;i<=G;i++){
			union[i] = i;
		}

		int count=0;
		boolean[] docking = new boolean[G+1];
		for(int i=1;i<=P;i++){
			int gi = airplane[i];
			while(union[gi] != 0){
				if(!docking[union[gi]]){
					docking[union[gi]] = true;
					count++;
					break;
				}else{
					union[gi]--;
				}
			}

			if(union[gi] == 0){
				break;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}
}
