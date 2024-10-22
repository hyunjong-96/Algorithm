package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

/*
n의 최대가 10000000이기때문에 모든 배열에 값을 넣고 과정을 구하면 시간초과가 날수밖에없다.
힌트에서는 n의 나머지와 몫을 잘 이용하라는 것을 보고 left와 right사이의 값을 나머지와 몫을 구했을때
나머지와 몫 중 큰값에 +1을 해준 값이 배열에 들어가있는 값임을 알게되었다.

예를 들어 n=3이고 right 5이면 (5/3, 5%3) = (1,2)이다 이때 배열의 값은 3이므로
left와 right사이의 값을 모두 구한다음 배열에 넣어주었다.
right-left는 최대 10만이기때문에 시간초과없이 구할수 있다.

주의사항은 주어진 left와 right는 long타입이고 반환할 배열은 int타입이니 타입 변환을 잘해주어야한다.
 */
public class n제곱배열자르기 {
	public static void main(String[] args) {
		int n = 4;
		long left = 2;
		long right = 5;
		int[] result = solution(n, left, right);
	}

	static int[] solution(int n, long left, long right){
		int[] arr = new int[(int)(left-right)+1];

		for(long i=left;i<=right;i++){
			arr[(int)(i-left)] = (int)Math.max(i/n,i%n)+1;
		}

		return arr;
	}
}
