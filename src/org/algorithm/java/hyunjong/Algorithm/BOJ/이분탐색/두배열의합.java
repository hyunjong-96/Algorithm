package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//두 배열이 있을때 각 배열의 부 배열의 합이 T가되는 쌍의 개수를 구하는 문제
//각 배열의 부 배열(sumA, sumB)을 만들어준다
//sumA 부 배열을 기준으로 합이 T가 되는지 확인하기 위해 T-sumA[i]를 sumB에 있는지 확인하고 있다면 sumB에서 upperBound-lowerBound로 개수를 구해준다.
//이때 upperBound-lowerBound시 upperBound와 lowerBound가 같을 수 있기 때문에 upperBound==lowerBound일 때 1로 변환시켜준다.
//[1,2,3,4,5] 일때 target = 5이면, upper = 4, lower = 4가 된다.
//그리고 lowerBound에서 반환된 값이 sumB범위 안 일때 반환된 값이 target이 아니라면(sumB에 T-sumA[i]가 없다)
public class 두배열의합 {
	static int T;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		int[] B = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		List<Long> sumA = new ArrayList<>();
		List<Long> sumB = new ArrayList<>();
		setSum(sumA, A, N);
		setSum(sumB, B, M);

		Collections.sort(sumB);
		long answer = 0;
		for(long a : sumA){
			int lower = lowerBound(sumB, T-a);
			// if(lower<0 || lower>=sumB.size()) continue;
			if(lower >= sumB.size()) continue;
			if(sumB.get(lower) != T-a) continue;

			int upper = upperBound(sumB, T-a);

			if(upper == lower) answer += 1;
			else answer += upper - lower;
		}

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static int lowerBound(List<Long> compareList, long target){
		int start = 0;
		int end = compareList.size();

		while(start<end){
			int mid = (start+end)/2;

			if(compareList.get(mid) < target){
				start = mid+1;
			}else{
				end = mid;
			}
		}

		return end;
	}
	static int upperBound(List<Long> compareList, long target){
		int start = 0;
		int end = compareList.size();

		while(start<end){
			int mid = (start+end)/2;

			if(compareList.get(mid) <= target){
				start = mid+1;
			}else{
				end = mid;
			}
		}

		return end;
	}

	static void setSum(List<Long> sumList, int[] arr, int size) {
		for(int i=0;i<size;i++){
			long s = 0;
			for(int j=i;j<size;j++){
				s += arr[j];
				sumList.add(s);
			}
		}
	}
}
