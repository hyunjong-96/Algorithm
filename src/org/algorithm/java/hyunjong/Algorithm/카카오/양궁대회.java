package org.algorithm.java.hyunjong.Algorithm.카카오;

public class 양궁대회 {
	public static void main(String[] args) {
		int n = 5;
		int[] info = {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
		System.out.println(TOSTRING(solution(n, info)));
	}

	static int[] Info;
	static int N;
	static int RyanScore;
	static int[] RyanInfo;
	static boolean haveWin;

	static int[] solution(int n, int[] info) {
		Info = info;
		N = n;

		RyanScore = 0;
		RyanInfo = new int[11];
		haveWin = false;

		dfs(0, 0, new int[11]);

		int[] answer = new int[] {-1};
		if (haveWin) {
			answer = RyanInfo;
		}
		return answer;
	}

	static void dfs(int count, int idx, int[] ryanInfo) {
		if(count==N){
			//info와 ryanInfo의 각 점수 비교해서 ryanInfo가 더 크다면 isWin에 true
			//그리고 ryanScore와 현재 점수를 비교해서 더 큰 값을 갱신하고 ryanInfo에 저장
			compareing(ryanInfo);
			return;
		}

		for(int i=0;i<11&&ryanInfo[i]<=Info[i];i++){
			// ryanInfo[i]++;
			// dfs(count+1, i, ryanInfo);
			// ryanInfo[i]--;
			ryanInfo[i]++;
			dfs(count+1, i+1, ryanInfo);
			ryanInfo[i]--;
		}
	}

	static void compareing(int[] ryanInfo) {
		int peachTotal = 0;
		int ryanTotal = 0;

		for (int i = 0; i < 11; i++) {
			int peachPoint = Info[i];
			int ryanPoint = ryanInfo[i];

			if(peachPoint == 0 && ryanPoint == 0){
				peachTotal += 0;
				ryanTotal += 0;
			}else if(peachPoint >= ryanPoint){
				peachTotal+=10-i;
			}else{
				ryanTotal+=10-i;
			}
			// peachTotal += peachPoint;
			// ryanTotal += ryanPoint;
		}

		boolean isRyanWin = ryanTotal > peachTotal;
		if(isRyanWin){
			System.out.println("ryanInfo : " + TOSTRING(ryanInfo) + " is ryanWin :" + isRyanWin);
		}

		if (ryanTotal > peachTotal) {
			haveWin = true;

			if (ryanTotal > RyanScore) {
				RyanScore = ryanTotal;
				for (int j = 0; j < 11; j++) {
					RyanInfo[j] = ryanInfo[j];
				}
			} else if (ryanTotal == RyanScore) {
				boolean original = true;
				for (int j = 10; j >= 0; j--) {
					if (RyanInfo[j] < ryanInfo[j]) {
						original = false;
						break;
					}
				}
				if (!original) {
					for (int j = 0; j < 11; j++) {
						RyanInfo[j] = ryanInfo[j];
					}
				}
			}
		}
	}

	static String TOSTRING(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			sb.append(" ");
		}
		return sb.toString();
	}
}
