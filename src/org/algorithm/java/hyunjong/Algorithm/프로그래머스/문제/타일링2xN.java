package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

/*
가로가 n인 타일을 만들기 위해서는
이전타일(n-1)에 세로길이의 타일(ㅣ)을 오른쪽에 추가한다.
2개전 타일(n-2)에 가로길이의 타일(ㅡ)를 오른쪽에 추가한다.
그렇게 되면 중복없이 n길이의 타일을 만들 수 있다.

경우의 수가 많아 질수 있기 때문에 경우의 수를 배열에 넣을 때 1000000007으로 나눈 나머지를 넣어준다.
 */
public class 타일링2xN {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
	}

	static int solution(int n){
		int[] arr = new int[n+1];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		for(int i=4;i<=n;i++){
			arr[i] = (arr[i-1]+arr[i-2])%1000000007;
		}
		return arr[n];
	}
}
