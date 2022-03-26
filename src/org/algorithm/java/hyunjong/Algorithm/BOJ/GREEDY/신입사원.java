package org.algorithm.java.hyunjong.Algorithm.BOJ.GREEDY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class 신입사원 {

	/*
	서류결과를 정렬하고 면접결과를 정렬하고 각 면접결과에 해당하는 면접자들을 비교하려니 이중for문이 발생해서
	이를 최대한 줄여주는 방법이 없을까 생각했었고
	서류결과를 index로 면접 결과를 value로 넣어주면 1개의 배열을 가지고 비교하기 때문에 for하나가 줄어들게 된다.
	1번째 index(서류결과 1등)을 기준으로 1번의 면접결과 보다 낮게된다면(등수이기 떄문에 높을수록 안좋은것)
	자신보다 서류결과는 높지만 면접 점수가 낮기때문에 해당 면접자를 합격하게 된다. passCount++
	그리고 해당 면접자의 면접결과를 기준으로 다음 면접자의 면접결과를 비교하며 합격자를 카운트하면 된다.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		int[] result;
		while (tc-- > 0) {
			int N = Integer.parseInt(br.readLine());
			result = new int[N + 1];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int paper = Integer.parseInt(st.nextToken());
				int meeting = Integer.parseInt(st.nextToken());

				result[paper] = meeting;
			}

			int pass = 1;
			int meetingRat = result[1];
			for (int i = 2; i < result.length; i++) {
				if(meetingRat > result[i]){
					pass++;
					meetingRat = result[i];
				}
			}
			sb.append(pass).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	/*
	심사에 기준이 서류 결과와 면접 결과가 다른 면접자보다 둘 다 뒤쳐지는 경우 심사에서 떨어지게 된다.
	그렇다는 것은 서류점수가 자신 보다 높은 면접자보다 낮은 면접 점수가 있다면 탈락하게 되는 것이다.
	그렇기 떄문에 서류 결과를 오름차순으로 정렬(순위가 높은순) 후
	서류결과가 낮은 사람이 높은 사람들을 비교하면서 자신보다 높은 면접결과가 있다면 떨어지게된다.
	탈락한 면접자의 명수를 지원자에서 빼다보면 총 합격한 면접자가 나오게 된다.

	결과 : 시간 초과
	각 테스트 케이스 떄문에 3중 반복문이 나오게 되는 것이 마음에 걸렸었는데 결국 초과가 나버렸다.
	 */
	// static class Result implements Comparable<Result> {
	// 	int paper;
	// 	int meeting;
	//
	// 	public Result(int paper, int meeting) {
	// 		this.paper = paper;
	// 		this.meeting = meeting;
	// 	}
	//
	// 	@Override
	// 	public int compareTo(Result o) {
	// 		if (this.paper > o.paper)
	// 			return 11;
	// 		else if (this.paper < o.paper) {
	// 			return -1;
	// 		} else {
	// 			if (this.meeting > o.meeting)
	// 				return 1;
	// 			else
	// 				return -1;
	// 		}
	// 	}
	// }
	// public static void main(String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	// 	StringBuilder sb = new StringBuilder();
	// 	int T = Integer.parseInt(br.readLine());
	//
	// 	int N;
	// 	Result[] results;
	// 	for (int i = 0; i < T; i++) {
	// 		N = Integer.parseInt(br.readLine());
	// 		results = new Result[N];
	// 		for (int j = 0; j < N; j++) {
	// 			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	// 			int paper = Integer.parseInt(st.nextToken());
	// 			int meeting = Integer.parseInt(st.nextToken());
	// 			results[j] = new Result(paper, meeting);
	// 		}
	//
	// 		Arrays.sort(results);
	//
	// 		int passCount = N;
	// 		for (int p = results.length - 1; p > 0; p--) {
	// 			for (int m = p - 1; m >= 0; m--) {
	// 				if (results[p].meeting > results[m].meeting) {
	// 					passCount--;
	// 					break;
	// 				}
	// 			}
	// 		}
	// 		sb.append(passCount).append("\n");
	// 	}
	// 	bw.write(sb.toString());
	// 	bw.flush();
	// 	bw.close();
	// }
}
