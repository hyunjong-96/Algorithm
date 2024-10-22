package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 영어끝말잇기 {
	public static void main(String[] args) {
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] result = solution(n, words);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

	static int[] solution(int n, String[] words){
		int[] answer = {0,0};
		//해당 사용자의 차례
		Map<Integer, Integer> turn = new HashMap<>();
		//사용한 단어
		Set<String> wordSet = new HashSet<>();

		int num = 0;
		//주어진 단어가 n에 맞게 주어지지 않는 경우도 있기 때문에 각각의 단어에 사용자와 사용자의 차례를 구해야한다.
		for(int i=0;i<words.length;i++){
			//해당 차례의 사용자 (사용자가 1~n 까지 반복되기 때문에 num으로 (num+1)%n으로 변경해주면서 그 값에 +1로 하여
			//실제 사용자 번호로 만들어준다.
			int currentNum = num+1;
			//사용자 차례 업데이트
			turn.put(currentNum, turn.getOrDefault(currentNum,0)+1);

			String currentWord = words[i];
			boolean isSuccess = true;
			//첫번째 단어는 이전 어떤 단어를 사용해도 상관없다.
			if(i>0){
				/*
				이전 단어와 비교하여 이전 단어의 마지막 문자와 현재 단어의 첫번째 문자를 비교한다.
				 */
				String prevWord = words[i-1];
				char prevLastChar = prevWord.charAt(prevWord.length()-1);
				char currentFirstChar = currentWord.charAt(0);

				if(prevLastChar != currentFirstChar) isSuccess = false;
			}
			//중복 단어를 사용했는지 확인한다.
			if(wordSet.contains(currentWord)) isSuccess = false;

			//문자가 다르거나 중복 단어를 사용했다면 해당 사용자의 번호와 사용자의 실패 차례를 저장하고 끝낸다.
			if(!isSuccess){
				answer[0] = currentNum;
				answer[1] = turn.get(currentNum);
				break;
			}

			//올바른 단어를 사용했다면 사용한 단어를 set에 저장하고 다음 사용자로 변경해준다.
			wordSet.add(currentWord);
			num = (num+1)%n;
		}

		return answer;
	}
}
