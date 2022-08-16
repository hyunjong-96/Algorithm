package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

/*
1,2,3 을 각각 3으로 나누면 나머지가 1,2,0 이 나온다. 1,2,3 을 각각 124 진법으로 나누면 1,2,4가 나온다.
그러므로 나머지 0은 124 진법으로 4, 1은 1, 2는 2가 나오게된다.
5를 3으로 나누면 몫은 1, 나머지는 2가 나오게 되므로 124 진법은 12가 된다.
이때 나머지가 0이 나오게 되면 몫에서 1를 감소시키고 나머지를 구한다.
몫이 0이 될때까지 반복한다.
 */
public class 나라의숫자124 {
	public static void main(String[] args) {
		int n = 27;
		System.out.println(solution(n));
	}

	static String solution(int n){
		int[] arr = {4,1,2};

		StringBuilder sb = new StringBuilder();
		//몫이 0이게 되면 중지
		while(n!=0){
			//몫의 몫 (처음에는 n의 몫)
			int value = n/3;
			//몫의 나머지 (처음에는 n의 나머지)
			int rest = n%3;

			//만약 나머지가 0이게 되면 몫에서 1를 감소시킨다.
			if(rest == 0) value--;

			//나머지 값을 124진법으로 바꾸어 저장.
			sb.append(arr[rest]);

			//몫을 갱신한다.
			n = value;
		}

		return sb.reverse().toString();
	}
}
