package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//lis의 마지막 요소보다 sequence[i]가 크다면 lis의 마지막 요소로 추가한다.
//lis의 마지막 요소보다 sequence[i]가 작다면 sequence[i]는 lis에서 적절한 부분에 대치한다.
//대치하는 이유는 sequence[i]로 대치함으로써 다음 요소 sequence[j]가 대치됨이 반복되서 sequence[i]를 대치하기 전보다 lis의 길이가 더 커질수도 있다.
//물론 sequence[i]를 대치한것보다 대치전이 lis의 길이가 더 클 수 있지만 sequence[i]와 대치해서 요소를 추가하는데 문제 생기진 않는다.
//sequence[i]를 대치한다면 lis 안의 요소가 정답과 다를 수 있다. [10,20,30] 일때 sequence[i]가 15여서 [10,15,30]으로 구현방법으로는 변경이된다.
//하지만 문제에서 요구하는 것은 lis의 요소의 값이 아닌 lis의 길이이기때문에 문제 풀이에 영향을 크게 미치지 않는다.
public class 가장긴증가하는부분수열2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] sequence = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++){
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> lis = new ArrayList<>();
		for(int i=0;i<N;i++){
			if(lis.isEmpty()){
				lis.add(sequence[i]);
			}else if(lis.get(lis.size()-1) < sequence[i]){
				lis.add(sequence[i]);
			}else if(lis.get(lis.size()-1) > sequence[i]){
				int start=0;
				int end=lis.size()-1;

				while(start<end){
					int mid = (start+end)/2;
					if(lis.get(mid) < sequence[i]) start = mid+1;
					else end = mid;
				}

				lis.set(end, sequence[i]);
			}
		}

		bw.write(String.valueOf(lis.size()));
		bw.flush();
		bw.close();
	}
}
