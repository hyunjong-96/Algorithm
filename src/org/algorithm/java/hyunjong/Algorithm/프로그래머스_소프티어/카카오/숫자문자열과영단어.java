package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

import java.util.HashMap;
import java.util.Map;

public class 숫자문자열과영단어 {
	public static void main(String[] args){
		String s = "2three45sixseven";
		System.out.println(solution(s));
	}

	static int solution(String s){
		Map<String,Integer> number_map = new HashMap<>();
		setMap(number_map);
		StringBuilder resultSb = new StringBuilder();
		StringBuilder sb = new StringBuilder();

		//문자열 반복
		//해당 index의 문자가 문자이고 number_map에 있다면 resultSb에 숫자로 변경해서 저장, sb 초기화
		//문자가 문자이고 number_map에 없는 문자라면 sb 유지
		//문자가 숫자라면 resultSb에 문자 그대로 저장
		for(char c : s.toCharArray()){
			if(c>='0' && c<='9'){
				resultSb.append(c);
			}else{
				sb.append(c);
				if(number_map.containsKey(sb.toString())){
					resultSb.append(number_map.get(sb.toString()));
					sb = new StringBuilder();
				}
			}
		}
		int answer = Integer.parseInt(resultSb.toString());
		return answer;
	}

	static void setMap(Map<String, Integer> number_map){
		number_map.put("one",1);
		number_map.put("two",2);
		number_map.put("three",3);
		number_map.put("four",4);
		number_map.put("five",5);
		number_map.put("six",6);
		number_map.put("seven",7);
		number_map.put("eight",8);
		number_map.put("nine",9);
		number_map.put("zero",0);
	}
}
