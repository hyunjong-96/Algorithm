package org.algorithm.java.hyunjong.Algorithm.프로그래머스_소프티어.문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/84512#

완탐으로 모든 단어의 조합을 만들어 정렬하고 단어 리스트에 몇번째에 있는지 확인

5개의 문자로 5자리를 만들어야하기 때문에 5+25+125+725+3124 로 3905의 경우의 수가 필요하다
 */
public class 모음사전 {
	public static void main(String[] args) {
		String word = "EIO";
		System.out.println(solution(word));
	}

	static int solution(String word){
		char[] alp = new char[]{'A','E','I','O','U'};
		List<String> words = new ArrayList<>();
		compare(alp, words, "", 0);

		Collections.sort(words);

		int answer = 0;
		for(int i=0;i<words.size();i++){
			if(words.get(i).equals(word)){
				answer = i;
				break;
			}
		}
		return answer;
	}

	static void compare(char[] alp, List<String> words, String word, int depth){
		words.add(word);
		if(depth >= 5) return;

		for(char a : alp){
			compare(alp, words, word+a, depth+1);
		}
	}
}
