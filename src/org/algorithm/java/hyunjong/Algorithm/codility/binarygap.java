package org.algorithm.java.hyunjong.Algorithm.codility;

/*
https://app.codility.com/demo/results/trainingA2YUQD-N22/
 */
public class binarygap {
	public static void main(String[] args) {
		int N = 529;
		System.out.println(solution(N));
	}

	static int solution(int N){
		int answer = 0;

		String s = Integer.toBinaryString(N);

		int count=0;
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);

			if(c=='1'){
				answer = Math.max(answer, count);
				count=0;
			}else{
				count++;
			}
		}
		return answer;
	}
}
