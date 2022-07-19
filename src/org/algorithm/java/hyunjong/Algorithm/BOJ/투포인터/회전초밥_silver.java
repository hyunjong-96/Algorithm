package org.algorithm.java.hyunjong.Algorithm.BOJ.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//map에 먹었던 초밥 종류를 저장한다 window내의 각 초밥 개수를 저장한다.
//end가 이동했을 때 sushis[end]가 가리키는 초밥 개수를 map에서 더하고
//start가 이동했을 떄 sushis[start]가 가리키는 초밥 개수를 map에서 뺸다.
//window를 움직였을 때 map에 있는 key를 꺼내어 쿠폰 초밥을 먹었는지 여부를 확인하고 1개 이상의 value를 가진 초밥이 있다면 count+1
//그 값의 최대값을 구한다

//end를 이동시킬때 eat[sushis[end]]가 0이라면 count+1, 1이상이라면 그냥 이동
//start를 이동시킬때 eat[sushis[start]]가 1이라면 count-1, 2이상이라면 그냥 이동 해서 시간을 단축시킬 수 있다.
public class 회전초밥_silver {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	//접시 수
		int d = Integer.parseInt(st.nextToken());	//초밥 가짓 수
		int k = Integer.parseInt(st.nextToken());	//연속 접시 수
		int c = Integer.parseInt(st.nextToken());	//쿠폰 번호

		int[] sushis = new int[N];
		for(int i=0;i<N;i++){
			sushis[i] = Integer.parseInt(br.readLine());
		}

		Map<Integer,Integer> map = new HashMap<>();

		for(int i=1;i<=d;i++){
			map.put(i,0);
		}

		int start=0;
		int end=0;
		for(end=0;end<k;end++){
			int sushi = sushis[end];
			map.put(sushi, map.get(sushi)+1);
		}

		int max=0;
		while(start != N){
			map.put(sushis[end], map.get(sushis[end])+1);

			map.put(sushis[start], map.get(sushis[start])-1);
			start++;
			end = (end+1)%N;
			int count=0;
			if(map.get(c) == 0) count++;
			for(int key : map.keySet()){
				if(map.get(key) != 0){
					count++;
				}
			}

			max = Math.max(max,count);
		}

		bw.write(String.valueOf(max));
		bw.flush();
		bw.close();
	}
}
