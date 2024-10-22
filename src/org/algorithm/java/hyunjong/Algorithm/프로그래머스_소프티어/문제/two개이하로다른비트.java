package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;


/*
주어진 정수와 비트가 2개 이하다르면서 큰 정수 중 가장 작은 수를 구할 때
주어진 정수의 이진수가 짝수 일 경우 1의 자리수는 무조건 0이기 때문에 1의 자리수를 1로 바꿔주면된다(주어진 정수+1)
홀수 일 경우 이진수가 1로만 이루어져있거나 0이 포함된 홀수여부를 파악해야한다
	1로만 이루어진 이진수는 맨 앞에 1을 추가하고 다음 자리 수를 0으로 변경하면 2개의 비트가 다르면서 주어진 수보다 큰 값 중 가장 작은 값을 구하게된다.
	0이 포함된 이진수는 마지막 자릿수에 있는 0을 1로 변경하고 그 다음 자리 수를 0으로 변경해주면 된다. (11 : 1011 -> 13 : 1101)
 */
public class two개이하로다른비트 {
	public static void main(String[] args) {
		long[] numbers = {2, 7};
		long[] result = solution(numbers);

		for (long r : result) {
			System.out.println(r);
		}
	}

	static long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			long number = numbers[i];

			//짝수인 경우 +1큰 수가 조건에 부합하는 정수
			if (number % 2 == 0) {
				answer[i] = number + 1;
			}
			//홀수인 경우 1로만 이루어졌는지 0이 포함된 이진수를 가지는지 확인한다.
			else {
				String binaryNumber = Long.toBinaryString(number);

				int zeroLastIndex = binaryNumber.lastIndexOf("0");

				StringBuilder sb = new StringBuilder(binaryNumber);
				//1로만 이루어진 이진수 일때
				if (zeroLastIndex == -1) {
					//이진수 맨 앞에 1를 포함하고 다음 자리수를 0으로 변경해준다.
					sb.reverse().append("1").reverse();
					sb.setCharAt(1, '0');
				}
				//0이 포함된 이진수 일때
				else {
					//마지막에 있는 0을 1로 변경해준다.
					sb.setCharAt(zeroLastIndex, '1');
					//만약 마지막에 있는 0뒤에 1이 존재한다면 마지막 0뒤에 있는 1을 0으로 변경해준다.
					if(zeroLastIndex+1<binaryNumber.length()) sb.setCharAt(zeroLastIndex+1, '0');
				}

				answer[i] = Long.parseLong(sb.toString(), 2);
			}
		}

		return answer;
	}
}
