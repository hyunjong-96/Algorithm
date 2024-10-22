package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.카카오;

import java.util.HashMap;
import java.util.Map;

/*
Map자료구조를 이용한 문자열 문제.
반례를 못찾아서 오래걸린 문제인것 같다.
자카드 유사도를 구하고 문제에서 알려준 공식대로 65536을 곱해서 정수부만 출력한다.
자카드 유사도는 두 집합의 교집합과 합집합을 구해야하는데
교집합은 각 문자열의 두글자 집합에 대해 사용 갯수(중복수) 중 두 map에 저장된 두글자 집합의 값중 작은 값들의 합.
합집합은 하나의 다중집합(map1)에서 중복된 집합중 큰 값을 더하고 다른 다중집합(map2)의 값을 0으로 갱신한다.
이렇게 다른 다중집합의 값을 0으로 갱신하면 map2의 집합의 갯수를 합할때 map1에서 합한 값을 중복으로 계산하지 않기 때문이다.

위의 설명대로 주어진 문자열을 두글자씩 끊어서 다중집합을 만든다.
이때 문자열에는 a~b, A~b 그리고 다른 문자들이 포함되어있는데 소문자,대문자 알파벳만 다중집합에 포함될수있다.
그렇기 때문에 문자열의 각 문자들을 탐색하며 알파벳에 포함된 문자들만 각 문자열의 map에 갯수를 갱신 및 저장해준다.
 */
public class 뉴스클러스터링 {
	public static void main(String[] args) {
		String str1 = "A+B";
		String str2 = "CDE";
		System.out.println(solution(str1,str2));
	}

	static HashMap<String, Integer> map1;
	static HashMap<String, Integer> map2;
	static int solution(String str1, String str2){
		map1 = new HashMap<String, Integer>();
		map2 = new HashMap<String, Integer>();

		//str1에서 조건에 맞는(대,소문자 알파벳) 두글자 문자의 사용 횟수를 저장 및 갱신한다.
		for(int s = 0; s<str1.length()-1;s++){
			char first = str1.charAt(s);
			char next = str1.charAt(s+1);
			if((first>='A'&& first<='Z' || first>='a'&&first<='z') && (next>='A'&&next<='Z' || next>='a'&&next<='z')){
				String group = String.valueOf(first)+String.valueOf(next);
				//대,소문자 구문을 하지 않기 때문에 대문자로 통일해서 key로 저장
				group = group.toUpperCase();
				map1.put(group, map1.getOrDefault(group, 0)+1);
			}
		}

		//str2도 동일
		for(int s=0; s<str2.length()-1;s++){
			char first = str2.charAt(s);
			char next = str2.charAt(s+1);
			if((first>='A'&& first<='Z' || first>='a'&&first<='z') && (next>='A'&&next<='Z' || next>='a'&&next<='z')){
				String group = String.valueOf(first)+String.valueOf(next);
				group = group.toUpperCase();
				map2.put(group, map2.getOrDefault(group, 0)+1);
			}
		}

		/*
		두 문자열 집합의 교집합은 중복된 집합의 값 중 작은 값의 합
		ex) map1에서 FR : 1, CN : 2 / map2에서 FR : 1, CN : 1이라면
		1 + min(2,1) = 2, 즉 교집합의 값은 2가 된다.
		 */
		int mix=0;
		for(Map.Entry<String,Integer> entry : map1.entrySet()){
			if(map2.containsKey(entry.getKey())){
				mix += Math.min(entry.getValue(), map2.get(entry.getKey()));
			}
		}

		/*
		합집합은 map1을 기준으로 중복되는 집합의 값중 최댓값을 합하고 map2에 중복되는 집합의 값을 0으로 갱신
		중복되지 않는 집합의 값들을 합한다.
		그리고 map2에서는 모든 값들을 합하는데 map1과 중복되는 집합은 0으로 치환되었기 때문에 중복되는 계산은 없게된다.
		 */
		int all=0;
		for(Map.Entry<String,Integer> entry : map1.entrySet()){
			if(map2.containsKey(entry.getKey())){
				all += Math.max(entry.getValue(), map2.get(entry.getKey()));
				map2.put(entry.getKey(),0);
			}else{
				all += entry.getValue();
			}
		}
		for(int v : map2.values()){
			all += v;
		}
		int answer=0;

		/*
		반례를 못찾아서 헤맸던 부분이다.
		두 집합이 모두 공집합이라면 자카드 유사도는 1이라고 했기 때문에 66536을 반환.
		그렇지 않고 둘 중 하나만 공집합이거나 교집합이 없다면 교집합이 0이 되기 때문에 계산에서 오류가 발생한다.
		그렇기 때문에 교집합이 0인 경우 0/n은 0이기 떄문에 0을 반환해준다(반례)
		그 외에는 교집합과 합집합을 나눈값에 65536을 곱하여 정수부만 출력해주면된다.
		이때 정수부만 출력하기 위해 Double 타입의 intValue함수를 사용.
		 */
		if(mix == 0 && all == 0){ answer = 65536;}
		else if(mix == 0) {answer = 0;}
		else{
			double s = (double)mix/all;
			Double ds = (s*65536);
			answer = ds.intValue();
		}
		return answer;
	}
}
