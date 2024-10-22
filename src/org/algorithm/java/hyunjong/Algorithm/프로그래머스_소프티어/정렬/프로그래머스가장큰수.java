package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.정렬;

import java.util.Arrays;
import java.util.Comparator;

/*
각 배열의 수를 각각 문자열로 더해서 값을 비교하려고 했는데 더 좋은 방법이 있었다.
정렬에 각 요소들을 비교해서 정렬하는 기능만 있는줄 알았는데
다른 요소들과의 합의 결과로 정렬을 할수 있었다.
예를들어 6,10,2의 값이 있는데 Comparator를 통해 비교 요소를 앞뒤로 붙이고 int타입으로 변경해서 크기를 비교하여 정렬하는것이다.
그러면 6,2,10으로 정렬이 된다.(610 > 106, 62 > 26, 102 < 210)
 */
public class 프로그래머스가장큰수 {
	public static void main(String[] args) {
		int[] numbers = {3,30,34,5,9};
		System.out.println(solution(numbers));
	}
	static int solution(int[] numbers){
		StringBuilder sb = new StringBuilder();
		String[] stringNumbers = new String[numbers.length];
		for(int i=0;i<numbers.length;i++){
			stringNumbers[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(stringNumbers, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				if(Integer.parseInt(o2+o1) > Integer.parseInt(o1+o2)) return 1;
				return -1;
			}
		});
		
		if(stringNumbers[0].equals("0")){
			sb.append(0);
		}else{
			for(String n:stringNumbers){
				sb.append(n);
			}
		}
		return Integer.parseInt(sb.toString());
	}
}
