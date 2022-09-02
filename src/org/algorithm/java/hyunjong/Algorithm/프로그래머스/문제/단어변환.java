package org.algorithm.java.hyunjong.Algorithm.프로그래머스.문제;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
words의 모든단어의 각 index의 문자를 Set<Character>[] charOfIndex에 저장한다.
begin의 각 자릿수를 바꿀수 있는 문자로 변경하면서 target과 동일한 문자열을 가지기 위해 BFS로 최소한의 변경과정을 찾는다.

begin의 각 자릿수에 바꿀수 있는 문자로 변경하고 이미 변경하지 않았고 words에 포함되어있는 단어라면
queue와 visit에 저장한다.

다른 방법으로, 비교 문자열과 words의 단어를 비교하면서 다른 문자가 1개 인 경우 dfs로 다른 문자열을 호출시키고 백트래킹 하는 방벙도 있다.
이게 더 쉬울 듯.
 */
public class 단어변환 {
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(begin, target, words));
	}

	static int answer;

	static int solution(String begin, String target, String[] words) {
		Set<Character>[] charOfIndex = new HashSet[begin.length()];
		for (int i = 0; i < begin.length(); i++) {
			charOfIndex[i] = new HashSet<>();
		}
		for (int w = 0; w < words.length; w++) {
			String word = words[w];
			for(int i=0;i<word.length();i++){
				charOfIndex[i].add(word.charAt(i));
			}
		}

		Set<String> set = new HashSet<>();
		set.addAll(Arrays.asList(words));
		answer = 0;
		bfs(begin, target, set, charOfIndex);

		return answer;
	}

	static void bfs(String begin, String target, Set<String> words, Set<Character>[] charOfIndex) {
		Queue<String> queue = new LinkedList<>();
		Set<String> visit = new HashSet<>();

		queue.offer(begin);
		visit.add(begin);

		int count = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				String current = queue.poll();

				//해당 문자열의 각 자릿수 반복
				for (int i = 0; i < current.length(); i++) {
					//해당 자릿수에서 변경할 수 있는 문자
					for (char c : charOfIndex[i]) {
						StringBuilder sb = new StringBuilder(current);
						sb.setCharAt(i, c);
						String change = sb.toString();

						//해당 자리에 문자를 변경했을 때 target과 동일하면 반복 끝
						if (change.equals(target)) {
							answer = count;
							return;
						}
						//변경한 문자열이 처음 나왔고 words에 포함되어있다면 다른 문자로 변경하기 위해 queue에 저장
						if (words.contains(change) && !visit.contains(change)) {
							queue.offer(change);
							visit.add(change);
						}
					}
				}
			}
			count++;
		}
	}
}
