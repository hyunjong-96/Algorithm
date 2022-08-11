package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*
모든 책을 제자리에 두었을때 0으로 돌아오지 않아도 되기때문에 가장 멀리 이동해야하는 곳을 마지막으로 이동해야한다.
멀리 이동해야할 때 최대한 M개의 책을 이동시켜야하고 한쪽 방향으로만 이동시켜야하기 때문에
음수 방향으로 이동하는 배열과 양수 방향으로 이동하는 배열을 구분한다.
그리고 각 방향에서 가장 먼 쪽부터 이동하면서 M개를 이동시켜야 최소한으로 움직일수 있기 때문에 내림차순 정렬하여
0번 부터 M번씩 이동하고 M개중 가장 큰 수를 왕복으로 answer에 저장한다.
모든 책을 이동시켰을때 마지막으로 이동했을때는 왕복을 하지 않아도 되기 때문에 주어진 책 위치 중 가장 큰 값을 마지막으로 이동시키기 위해
answer에서 주어진 위치중 최대 위치를 빼주어 최소 이동거리를 구한다.

앞에서 부터 정렬해서 조건에 맞는 값을 찾는게 보이지 않다면 반대로도 생각해보자
 */
public class 도서관 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine()," " );
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		List<Integer> maxList = new ArrayList<>();
		List<Integer> minList = new ArrayList<>();
		int biggest = 0;
		for(int i=0;i<N;i++){
			int b = Integer.parseInt(st.nextToken());
			if(b>0) maxList.add(b);
			else minList.add(Math.abs(b));
			biggest = Math.max(biggest, Math.abs(b));
		}

		maxList.sort(Comparator.reverseOrder());
		minList.sort(Comparator.reverseOrder());

		int sum=0;
		for(int i=0;i<maxList.size();i+=M){
			sum += maxList.get(i)*2;
		}
		for(int i=0;i<minList.size();i+=M){
			sum += minList.get(i)*2;
		}

		sum -= biggest;

		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
	}
}
