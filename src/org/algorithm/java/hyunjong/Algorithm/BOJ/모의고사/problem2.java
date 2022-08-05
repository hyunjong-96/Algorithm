package org.algorithm.java.hyunjong.Algorithm.BOJ.모의고사;

import java.util.HashMap;
import java.util.Map;

public class problem2 {
	public static void main(String[] args) {
		String[] want = {"banana"};
		int[] number = {2};
		String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};

		System.out.println(solution(want, number, discount));
	}
	static public int solution(String[] want, int[] number, String[] discount) {
		Map<String, Integer> sales = new HashMap<>();
		int answer = 0;

		for(int i=0;i<10;i++){
			String product = discount[i];
			if(sales.containsKey(product)){
				sales.put(product, sales.get(product)+1);
			}else{
				sales.put(product,1);
			}

			if(checkWant(sales, want, number)) answer++;
		}

		int start = 0;
		int end = 10;

		while(end < discount.length){
			String out = discount[start++];
			String in = discount[end++];

			sales.put(out, sales.get(out)-1);

			if(sales.containsKey(in)){
				sales.put(in, sales.get(in)+1);
			}else{
				sales.put(in, 1);
			}

			if(checkWant(sales, want, number)) answer++;
		}

		return answer;
	}

	static boolean checkWant(Map<String, Integer> sales, String[] want, int[] number){
		boolean isSuccess = true;
		for(int i=0;i<want.length;i++){
			String p = want[i];
			int n = number[i];

			if(!sales.containsKey(p) || (sales.containsKey(p) && sales.get(p) != n)){
				isSuccess = false;
				break;
			}
		}
		return isSuccess;
	}
}
