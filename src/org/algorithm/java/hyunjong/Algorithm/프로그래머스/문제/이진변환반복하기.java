package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

/*
주어진 s가 1이 될때까지 s의 0을 제거하고 길이로 이진법 변환을 해준다.
 */
public class 이진변환반복하기 {
	public static void main(String[] args) {
		String s = "110010101001";
		int[] result = solution(s);
		System.out.println(result[0]+" "+result[1]);
	}

	static int[] solution(String s){
		int turn = 0;
		int count = 0;

		while(!s.equals("1")){
			int zeroCount = 0;
			for(int i=0;i<s.length();i++){
				if(s.charAt(i) == '0') zeroCount++;
			}
			count += zeroCount;

			s = s.replace("0","");
			s = Integer.toBinaryString(s.length());
			turn++;
		}

		int[] answer = new int[]{turn, count};
		return answer;
	}
}
