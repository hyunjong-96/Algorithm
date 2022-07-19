package org.algorithm.java.hyunjong.Algorithm.BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//블루레이 크기의 최솟값을 구하는 문제이기 때문에 이분탐색 고려
//이분탐색이기때문에 mid를 블루레이의 임시 크기로 놓는다. start는 강의 크기중 가장 큰 값, end는 강의의 총 합
//임시 크기 mid를 가지고 N개의 강의를 몇개 블루레이로 만들수 있는지 계산한다.
//mid의 크기로 만들수 있는 블루레이 개수 count가 M보다 작다면 최소 M개를 만들어야하기 때문에 mid의 크기를 증가시키기 위해 start=  mid+1
//count가 M보다 작거나 같다면 최소 M개의 블루레이를 만들 수 있고 그 중 최소를 구해야하기 때문에 mid의 크기를 줄이기 위해 end=mid-1
//그러면서 answer에 mid를 갱신시켜준다. 결국 하나의 mid값을 찾기 때문에 마지막 mid값이 최소가 되게 된다.
public class 기타레슨 {
	static int N;
	static int M;
	static int sum;
	static int max;
	static int[] classes;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		classes = new int[N];
		sum = 0;
		max = 0;
		for (int i = 0; i < N; i++) {
			classes[i] += Integer.parseInt(st.nextToken());
			sum += classes[i];
			max = Math.max(max, classes[i]);
		}

		answer = Integer.MAX_VALUE;
		binary_search();

		bw.write(String.valueOf(answer));
		bw.flush();
		bw.close();
	}

	static void binary_search() {
		int start = max;
		int end = sum;

		while (start <= end) {
			int mid = (start + end) / 2;

			int count = countGroup(mid);

			if(count>M) start=mid+1;
			else{
				// if(count==M){
				// 	answer = Math.min(answer, mid);
				// }
				answer = mid;
				end = mid-1;
			}
		}
	}

	static int countGroup(int mid) {
		int count = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (mid < sum + classes[i]) {
				count++;
				sum = 0;
			}

			sum += classes[i];
		}
		count++;

		return count;
	}
}
